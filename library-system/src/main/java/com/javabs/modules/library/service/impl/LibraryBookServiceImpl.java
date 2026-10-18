
package com.javabs.modules.library.service.impl;

import com.javabs.modules.library.domain.LibraryBook;
import com.javabs.utils.FileUtil;
import com.javabs.utils.PageUtil;
import com.javabs.utils.QueryHelp;
import com.javabs.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import com.javabs.modules.library.repository.LibraryBookRepository;
import com.javabs.modules.library.service.LibraryBookService;
import com.javabs.modules.library.service.dto.LibraryBookDto;
import com.javabs.modules.library.service.dto.LibraryBookQueryCriteria;
import com.javabs.modules.library.service.mapstruct.LibraryBookMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
*
* @description 服务实现
* @author 李寻欢
* @date 2023-04-02
**/
@Service
@RequiredArgsConstructor
public class LibraryBookServiceImpl implements LibraryBookService {

    private final LibraryBookRepository libraryBookRepository;
    private final LibraryBookMapper libraryBookMapper;

    @Override
    public Map<String,Object> queryAll(LibraryBookQueryCriteria criteria, Pageable pageable){
        Page<LibraryBook> page = libraryBookRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(libraryBookMapper::toDto));
    }

    @Override
    public List<LibraryBookDto> queryAll(LibraryBookQueryCriteria criteria){
        return libraryBookMapper.toDto(libraryBookRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public LibraryBookDto findById(Integer id) {
        LibraryBook libraryBook = libraryBookRepository.findById(id).orElseGet(LibraryBook::new);
        ValidationUtil.isNull(libraryBook.getId(),"LibraryBook","id",id);
        return libraryBookMapper.toDto(libraryBook);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LibraryBookDto create(LibraryBook resources) {
        return libraryBookMapper.toDto(libraryBookRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LibraryBook resources) {
        LibraryBook libraryBook = libraryBookRepository.findById(resources.getId()).orElseGet(LibraryBook::new);
        ValidationUtil.isNull( libraryBook.getId(),"LibraryBook","id",resources.getId());
        libraryBook.copy(resources);
        libraryBookRepository.save(libraryBook);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            libraryBookRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<LibraryBookDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (LibraryBookDto libraryBook : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("名字", libraryBook.getName());
            map.put("价格", libraryBook.getPrice());
            map.put("作者", libraryBook.getAuthor());
            map.put("出版社", libraryBook.getPress());
            map.put("出版时间", libraryBook.getPressTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
