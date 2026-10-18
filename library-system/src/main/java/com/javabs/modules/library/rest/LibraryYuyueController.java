package com.javabs.modules.library.rest;

import com.javabs.config.AccessToken;
import com.javabs.config.FileProperties;
import com.javabs.exception.BadRequestException;
import com.javabs.modules.library.domain.LibrarySeat;
import com.javabs.modules.library.domain.LibraryYuyue;
import com.javabs.modules.library.service.LibrarySeatService;
import com.javabs.modules.library.service.LibraryYuyueService;
import com.javabs.modules.library.service.dto.LibrarySeatDto;
import com.javabs.modules.library.service.dto.LibraryYuyueDto;
import com.javabs.modules.library.service.dto.LibraryYuyueQueryCriteria;
import com.javabs.modules.system.domain.User;
import com.javabs.modules.system.service.UserService;
import com.javabs.modules.system.service.dto.UserDto;
import com.javabs.utils.FileUtil;
import com.javabs.utils.SecurityUtils;
import com.javabs.utils.StringUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;

/**
*
* @author 李寻欢
* @date 2023-04-03
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "预约管理")
@RequestMapping("/api/libraryYuyue")
public class LibraryYuyueController {

    private final LibraryYuyueService libraryYuyueService;

    private final LibrarySeatService librarySeatService;

    private final UserService userService;

    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('libraryYuyue:list')")
    public void exportLibraryYuyue(HttpServletResponse response, LibraryYuyueQueryCriteria criteria) throws IOException {
        libraryYuyueService.download(libraryYuyueService.queryAll(criteria), response);
    }

    @GetMapping
    @ApiOperation("查询预约")
    @PreAuthorize("@el.check('libraryYuyue:list')")
    public ResponseEntity<Object> queryLibraryYuyue(LibraryYuyueQueryCriteria criteria, Pageable pageable){
        // 查询自己的
        criteria.setUserId(SecurityUtils.getCurrentUserId());
        return new ResponseEntity<>(libraryYuyueService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("新增预约")
    @PreAuthorize("@el.check('librarySeat:yuyue')")
    public ResponseEntity<Object> createLibraryYuyue(@Validated @RequestBody LibraryYuyue resources){

        UserDto userDto = userService.findById(SecurityUtils.getCurrentUserId());
        if(userDto.getNum() < 0){
            // 不能预约
           return new ResponseEntity<>("信誉分不足，无法预约",HttpStatus.CREATED);
        }

        LibrarySeatDto seat = librarySeatService.findById(resources.getSeatId());
        resources.setSeatName(seat.getCard());
        resources.setRoomName(seat.getRoomName());
        resources.setStatus(0);
        resources.setUserId(SecurityUtils.getCurrentUserId());
        resources.setUserName(SecurityUtils.getCurrentUsername());
        // 将座位状态改为占用
        LibrarySeat librarySeat = new LibrarySeat();
        librarySeat.setStatus(2);
        librarySeat.setId(seat.getId());
        librarySeatService.update(librarySeat);
        return new ResponseEntity<>(libraryYuyueService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("修改预约")
    @PreAuthorize("@el.check('libraryYuyue:edit')")
    public ResponseEntity<Object> updateLibraryYuyue(@Validated @RequestBody LibraryYuyue resources){
        libraryYuyueService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @ApiOperation("删除预约")
    @PreAuthorize("@el.check('libraryYuyue:del')")
    public ResponseEntity<Object> deleteLibraryYuyue(@RequestBody Integer[] ids) {
        libraryYuyueService.deleteAll(ids);
        return new ResponseEntity<>("暂离成功",HttpStatus.CREATED);
    }
    @PostMapping("li")
    public ResponseEntity<Object> li(@RequestBody LibraryYuyue resources){
        libraryYuyueService.update(resources);
        return new ResponseEntity<>("暂离成功",HttpStatus.CREATED);
    }
    private final FileProperties properties;

    @PostMapping("dao")
    public ResponseEntity<Object> dao(@RequestParam("file") MultipartFile multipartFile,Integer id,Integer status){

        String image = "gif jpg png jpeg";
        String fileType = FileUtil.getExtensionName(multipartFile.getOriginalFilename());
        if(fileType != null && !image.contains(fileType)){
            throw new BadRequestException("文件格式错误！, 仅支持 " + image +" 格式");
        }

        File file = FileUtil.upload(multipartFile, properties.getPath().getAvatar());
        String path = Objects.requireNonNull(file).getPath();
        System.out.println(path);

        // 判断用户有没有上传头像
        Long currentUserId = SecurityUtils.getCurrentUserId();
        UserDto userDto = userService.findById(currentUserId);
        if(StringUtils.isEmpty(userDto.getAvatarPath())){
            return new ResponseEntity<>("用户未上传头像，请先到个人中心上传头像",HttpStatus.CREATED);
        }
        // 对比图片分数小于80分不是同一个人
        int score = AccessToken.idCard(userDto.getAvatarPath(), path);
        if(score < 80){
            return new ResponseEntity<>("不是用户本人，无法签到",HttpStatus.CREATED);
        }
        LibraryYuyue resources = new LibraryYuyue();
        resources.setId(id);
        resources.setStatus(status);
        resources.setStartTime(new Timestamp(new Date().getTime()));
        libraryYuyueService.update(resources);
        return new ResponseEntity<>("签到成功",HttpStatus.CREATED);
    }

    @PostMapping("tui")
    public ResponseEntity<Object> tui(@RequestParam("file") MultipartFile multipartFile,Integer id,Integer status){

        String image = "gif jpg png jpeg";
        String fileType = FileUtil.getExtensionName(multipartFile.getOriginalFilename());
        if(fileType != null && !image.contains(fileType)){
            throw new BadRequestException("文件格式错误！, 仅支持 " + image +" 格式");
        }

        File file = FileUtil.upload(multipartFile, properties.getPath().getAvatar());
        String path = Objects.requireNonNull(file).getPath();
        System.out.println(path);

        // 判断用户有没有上传头像
        Long currentUserId = SecurityUtils.getCurrentUserId();
        UserDto userDto = userService.findById(currentUserId);
        if(StringUtils.isEmpty(userDto.getAvatarPath())){
            return new ResponseEntity<>("用户未上传头像，请先到个人中心上传头像",HttpStatus.CREATED);
        }
        // 对比图片分数小于80分不是同一个人
        int score = AccessToken.idCard(userDto.getAvatarPath(), path);
        if(score < 80){
            return new ResponseEntity<>("不是用户本人，无法签退",HttpStatus.CREATED);
        }
        LibraryYuyue resources = new LibraryYuyue();
        resources.setId(id);
        resources.setStatus(status);

        resources.setEndTime(new Timestamp(new Date().getTime()));
        libraryYuyueService.update(resources);
        LibraryYuyueDto yuyueDto = libraryYuyueService.findById(resources.getId());
        // 释放座位
        LibrarySeat seat = new LibrarySeat();
        seat.setId(yuyueDto.getSeatId());
        seat.setStatus(1);
        librarySeatService.update(seat);
        return new ResponseEntity<>("签退成功",HttpStatus.CREATED);
    }
}
