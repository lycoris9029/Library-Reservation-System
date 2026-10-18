
package com.javabs.modules.library.service.impl;

import com.javabs.modules.library.domain.LibraryYuyue;
import com.javabs.utils.FileUtil;
import com.javabs.utils.PageUtil;
import com.javabs.utils.QueryHelp;
import com.javabs.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import com.javabs.modules.library.repository.LibraryYuyueRepository;
import com.javabs.modules.library.service.LibraryYuyueService;
import com.javabs.modules.library.service.dto.LibraryYuyueDto;
import com.javabs.modules.library.service.dto.LibraryYuyueQueryCriteria;
import com.javabs.modules.library.service.mapstruct.LibraryYuyueMapper;
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
public class LibraryYuyueServiceImpl implements LibraryYuyueService {

    private final LibraryYuyueRepository libraryYuyueRepository;
    private final LibraryYuyueMapper libraryYuyueMapper;

    @Override
    public Map<String,Object> queryAll(LibraryYuyueQueryCriteria criteria, Pageable pageable){
        Page<LibraryYuyue> page = libraryYuyueRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(libraryYuyueMapper::toDto));
    }

    @Override
    public List<LibraryYuyueDto> queryAll(LibraryYuyueQueryCriteria criteria){
        return libraryYuyueMapper.toDto(libraryYuyueRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public LibraryYuyueDto findById(Integer id) {
        LibraryYuyue libraryYuyue = libraryYuyueRepository.findById(id).orElseGet(LibraryYuyue::new);
        ValidationUtil.isNull(libraryYuyue.getId(),"LibraryYuyue","id",id);
        return libraryYuyueMapper.toDto(libraryYuyue);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LibraryYuyueDto create(LibraryYuyue resources) {
        return libraryYuyueMapper.toDto(libraryYuyueRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LibraryYuyue resources) {
        LibraryYuyue libraryYuyue = libraryYuyueRepository.findById(resources.getId()).orElseGet(LibraryYuyue::new);
        ValidationUtil.isNull( libraryYuyue.getId(),"LibraryYuyue","id",resources.getId());
        libraryYuyue.copy(resources);
        libraryYuyueRepository.save(libraryYuyue);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            libraryYuyueRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<LibraryYuyueDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (LibraryYuyueDto libraryYuyue : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put(" userId",  libraryYuyue.getUserId());
            map.put("预约人", libraryYuyue.getUserName());
            map.put("阅览室", libraryYuyue.getRoomName());
            map.put(" seatId",  libraryYuyue.getSeatId());
            map.put("座位", libraryYuyue.getSeatName());
            map.put("状态，0.未签到，1，已签到，2.暂离，3.已签退", libraryYuyue.getStatus());
            map.put("预约时间", libraryYuyue.getYyTime());
            map.put("签到时间", libraryYuyue.getStartTime());
            map.put("签退时间", libraryYuyue.getEndTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
