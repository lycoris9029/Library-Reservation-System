package com.javabs.modules.library.rest;

import com.javabs.modules.library.domain.LibrarySeat;
import com.javabs.modules.library.service.LibraryRoomService;
import com.javabs.modules.library.service.LibrarySeatService;
import com.javabs.modules.library.service.dto.LibraryRoomDto;
import com.javabs.modules.library.service.dto.LibrarySeatQueryCriteria;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
*
* @author 李寻欢
* @date 2023-04-02
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "座位管理")
@RequestMapping("/api/librarySeat")
public class LibrarySeatController {

    private final LibrarySeatService librarySeatService;

    private final LibraryRoomService libraryRoomService;

    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('librarySeat:list')")
    public void exportLibrarySeat(HttpServletResponse response, LibrarySeatQueryCriteria criteria) throws IOException {
        librarySeatService.download(librarySeatService.queryAll(criteria), response);
    }

    @GetMapping
    @ApiOperation("查询座位")
    @PreAuthorize("@el.check('librarySeat:list')")
    public ResponseEntity<Object> queryLibrarySeat(LibrarySeatQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(librarySeatService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("新增座位")
    @PreAuthorize("@el.check('librarySeat:add')")
    public ResponseEntity<Object> createLibrarySeat(@Validated @RequestBody LibrarySeat resources){
        LibraryRoomDto roomDto = libraryRoomService.findById(resources.getRoomId());
        resources.setRoomName(roomDto.getName());
        resources.setStatus(1);
        return new ResponseEntity<>(librarySeatService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("修改座位")
    @PreAuthorize("@el.check('librarySeat:edit')")
    public ResponseEntity<Object> updateLibrarySeat(@Validated @RequestBody LibrarySeat resources){
        LibraryRoomDto roomDto = libraryRoomService.findById(resources.getRoomId());
        resources.setRoomName(roomDto.getName());
        librarySeatService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @ApiOperation("删除座位")
    @PreAuthorize("@el.check('librarySeat:del')")
    public ResponseEntity<Object> deleteLibrarySeat(@RequestBody Integer[] ids) {
        librarySeatService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
