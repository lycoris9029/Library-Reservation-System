
package com.javabs.modules.library.service.impl;

import com.javabs.modules.library.domain.LibrarySeat;
import com.javabs.utils.FileUtil;
import com.javabs.utils.PageUtil;
import com.javabs.utils.QueryHelp;
import com.javabs.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import com.javabs.modules.library.repository.LibrarySeatRepository;
import com.javabs.modules.library.service.LibrarySeatService;
import com.javabs.modules.library.service.dto.LibrarySeatDto;
import com.javabs.modules.library.service.dto.LibrarySeatQueryCriteria;
import com.javabs.modules.library.service.mapstruct.LibrarySeatMapper;
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
public class LibrarySeatServiceImpl implements LibrarySeatService {

    private final LibrarySeatRepository librarySeatRepository;
    private final LibrarySeatMapper librarySeatMapper;

    @Override
    public Map<String,Object> queryAll(LibrarySeatQueryCriteria criteria, Pageable pageable){
        Page<LibrarySeat> page = librarySeatRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(librarySeatMapper::toDto));
    }

    @Override
    public List<LibrarySeatDto> queryAll(LibrarySeatQueryCriteria criteria){
        return librarySeatMapper.toDto(librarySeatRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public LibrarySeatDto findById(Integer id) {
        LibrarySeat librarySeat = librarySeatRepository.findById(id).orElseGet(LibrarySeat::new);
        ValidationUtil.isNull(librarySeat.getId(),"LibrarySeat","id",id);
        return librarySeatMapper.toDto(librarySeat);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LibrarySeatDto create(LibrarySeat resources) {
        return librarySeatMapper.toDto(librarySeatRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LibrarySeat resources) {
        LibrarySeat librarySeat = librarySeatRepository.findById(resources.getId()).orElseGet(LibrarySeat::new);
        ValidationUtil.isNull( librarySeat.getId(),"LibrarySeat","id",resources.getId());
        librarySeat.copy(resources);
        librarySeatRepository.save(librarySeat);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            librarySeatRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<LibrarySeatDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (LibrarySeatDto librarySeat : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("座位编号", librarySeat.getCard());
            map.put(" roomId",  librarySeat.getRoomId());
            map.put("所属阅览室", librarySeat.getRoomName());
            map.put("状态", librarySeat.getStatus());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
