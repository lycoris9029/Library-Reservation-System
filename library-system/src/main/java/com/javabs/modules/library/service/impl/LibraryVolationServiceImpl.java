
package com.javabs.modules.library.service.impl;

import com.javabs.modules.library.domain.LibraryVolation;
import com.javabs.utils.FileUtil;
import com.javabs.utils.PageUtil;
import com.javabs.utils.QueryHelp;
import com.javabs.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import com.javabs.modules.library.repository.LibraryVolationRepository;
import com.javabs.modules.library.service.LibraryVolationService;
import com.javabs.modules.library.service.dto.LibraryVolationDto;
import com.javabs.modules.library.service.dto.LibraryVolationQueryCriteria;
import com.javabs.modules.library.service.mapstruct.LibraryVolationMapper;
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
* @date 2023-04-03
**/
@Service
@RequiredArgsConstructor
public class LibraryVolationServiceImpl implements LibraryVolationService {

    private final LibraryVolationRepository libraryVolationRepository;
    private final LibraryVolationMapper libraryVolationMapper;

    @Override
    public Map<String,Object> queryAll(LibraryVolationQueryCriteria criteria, Pageable pageable){
        Page<LibraryVolation> page = libraryVolationRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(libraryVolationMapper::toDto));
    }

    @Override
    public List<LibraryVolationDto> queryAll(LibraryVolationQueryCriteria criteria){
        return libraryVolationMapper.toDto(libraryVolationRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public LibraryVolationDto findById(Integer id) {
        LibraryVolation libraryVolation = libraryVolationRepository.findById(id).orElseGet(LibraryVolation::new);
        ValidationUtil.isNull(libraryVolation.getId(),"LibraryVolation","id",id);
        return libraryVolationMapper.toDto(libraryVolation);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LibraryVolationDto create(LibraryVolation resources) {
        return libraryVolationMapper.toDto(libraryVolationRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LibraryVolation resources) {
        LibraryVolation libraryVolation = libraryVolationRepository.findById(resources.getId()).orElseGet(LibraryVolation::new);
        ValidationUtil.isNull( libraryVolation.getId(),"LibraryVolation","id",resources.getId());
        libraryVolation.copy(resources);
        libraryVolationRepository.save(libraryVolation);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            libraryVolationRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<LibraryVolationDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (LibraryVolationDto libraryVolation : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put(" sendId",  libraryVolation.getSendId());
            map.put("举报人", libraryVolation.getSendName());
            map.put(" receiveId",  libraryVolation.getReceiveId());
            map.put("举报对象", libraryVolation.getReceiveName());
            map.put("举报时间", libraryVolation.getSendTime());
            map.put("状态", libraryVolation.getStatus());
            map.put("扣除信用分", libraryVolation.getNum());
            map.put("违规详情", libraryVolation.getRemark());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
