package com.javabs.modules.library.rest;

import com.javabs.modules.library.domain.LibraryBook;
import com.javabs.modules.library.service.LibraryBookService;
import com.javabs.modules.library.service.dto.LibraryBookQueryCriteria;
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
@Api(tags = "图书管理")
@RequestMapping("/api/libraryBook")
public class LibraryBookController {

    private final LibraryBookService libraryBookService;

    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('libraryBook:list')")
    public void exportLibraryBook(HttpServletResponse response, LibraryBookQueryCriteria criteria) throws IOException {
        libraryBookService.download(libraryBookService.queryAll(criteria), response);
    }

    @GetMapping
    @ApiOperation("查询图书")
    @PreAuthorize("@el.check('libraryBook:list')")
    public ResponseEntity<Object> queryLibraryBook(LibraryBookQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(libraryBookService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("新增图书")
    @PreAuthorize("@el.check('libraryBook:add')")
    public ResponseEntity<Object> createLibraryBook(@Validated @RequestBody LibraryBook resources){
        return new ResponseEntity<>(libraryBookService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("修改图书")
    @PreAuthorize("@el.check('libraryBook:edit')")
    public ResponseEntity<Object> updateLibraryBook(@Validated @RequestBody LibraryBook resources){
        libraryBookService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @ApiOperation("删除图书")
    @PreAuthorize("@el.check('libraryBook:del')")
    public ResponseEntity<Object> deleteLibraryBook(@RequestBody Integer[] ids) {
        libraryBookService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
