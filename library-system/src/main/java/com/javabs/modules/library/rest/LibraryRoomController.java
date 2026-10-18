package com.javabs.modules.library.rest;

import com.javabs.modules.library.domain.LibraryRoom;
import com.javabs.modules.library.service.LibraryRoomService;
import com.javabs.modules.library.service.dto.LibraryRoomQueryCriteria;
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
@Api(tags = "阅览室管理")
@RequestMapping("/api/libraryRoom")
public class LibraryRoomController {

    private final LibraryRoomService libraryRoomService;

    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('libraryRoom:list')")
    public void exportLibraryRoom(HttpServletResponse response, LibraryRoomQueryCriteria criteria) throws IOException {
        libraryRoomService.download(libraryRoomService.queryAll(criteria), response);
    }

    @GetMapping
    @ApiOperation("查询阅览室管理")
    @PreAuthorize("@el.check('libraryRoom:list')")
    public ResponseEntity<Object> queryLibraryRoom(LibraryRoomQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(libraryRoomService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @GetMapping("select")
    public ResponseEntity<Object> select(LibraryRoomQueryCriteria criteria){
        return new ResponseEntity<>(libraryRoomService.queryAll(criteria),HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("新增阅览室管理")
    @PreAuthorize("@el.check('libraryRoom:add')")
    public ResponseEntity<Object> createLibraryRoom(@Validated @RequestBody LibraryRoom resources){
        return new ResponseEntity<>(libraryRoomService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("修改阅览室管理")
    @PreAuthorize("@el.check('libraryRoom:edit')")
    public ResponseEntity<Object> updateLibraryRoom(@Validated @RequestBody LibraryRoom resources){
        libraryRoomService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @ApiOperation("删除阅览室管理")
    @PreAuthorize("@el.check('libraryRoom:del')")
    public ResponseEntity<Object> deleteLibraryRoom(@RequestBody Integer[] ids) {
        libraryRoomService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
