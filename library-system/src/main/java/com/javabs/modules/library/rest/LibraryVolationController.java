package com.javabs.modules.library.rest;

import com.javabs.modules.library.domain.LibraryVolation;
import com.javabs.modules.library.service.LibraryVolationService;
import com.javabs.modules.library.service.dto.LibraryVolationDto;
import com.javabs.modules.library.service.dto.LibraryVolationQueryCriteria;
import com.javabs.modules.system.domain.User;
import com.javabs.modules.system.service.UserService;
import com.javabs.modules.system.service.dto.UserDto;
import com.javabs.utils.SecurityUtils;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;

/**
*
* @author 李寻欢
* @date 2023-04-03
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "检举管理")
@RequestMapping("/api/libraryVolation")
public class LibraryVolationController {

    private final LibraryVolationService libraryVolationService;

    private final UserService userService;

    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('libraryVolation:list')")
    public void exportLibraryVolation(HttpServletResponse response, LibraryVolationQueryCriteria criteria) throws IOException {
        libraryVolationService.download(libraryVolationService.queryAll(criteria), response);
    }

    @GetMapping
    @ApiOperation("查询检举")
    @PreAuthorize("@el.check('libraryVolation:list')")
    public ResponseEntity<Object> queryLibraryVolation(LibraryVolationQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(libraryVolationService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("新增检举")
    @PreAuthorize("@el.check('libraryVolation:add')")
    public ResponseEntity<Object> createLibraryVolation(@Validated @RequestBody LibraryVolation resources){

        resources.setSendId(SecurityUtils.getCurrentUserId());
        resources.setSendName(SecurityUtils.getCurrentUsername());
        resources.setStatus(0);
        resources.setNum(0);
        UserDto userDto = userService.findById(resources.getReceiveId());
        resources.setReceiveName(userDto.getNickName());
        return new ResponseEntity<>(libraryVolationService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("修改检举")
    @PreAuthorize("@el.check('libraryVolation:edit')")
    public ResponseEntity<Object> updateLibraryVolation(@Validated @RequestBody LibraryVolation resources){
        UserDto userDto = userService.findById(resources.getReceiveId());
        resources.setReceiveName(userDto.getNickName());
        libraryVolationService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @ApiOperation("删除检举")
    @PreAuthorize("@el.check('libraryVolation:del')")
    public ResponseEntity<Object> deleteLibraryVolation(@RequestBody Integer[] ids) {
        libraryVolationService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("chuli")
    @PreAuthorize("@el.check('libraryVolation:chuli')")
    public ResponseEntity<Object> operateVolation( @RequestBody LibraryVolation resources) throws Exception{
        if(resources.getStatus() == 2){
            resources.setNum(0);
        }
        libraryVolationService.update(resources);
        LibraryVolationDto volationDto = libraryVolationService.findById(resources.getId());
        UserDto userDto = userService.findById(volationDto.getReceiveId());
        User user = new User();
        user.setId(userDto.getId());
        user.setNum(userDto.getNum()-resources.getNum());
        userService.updateNum(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
