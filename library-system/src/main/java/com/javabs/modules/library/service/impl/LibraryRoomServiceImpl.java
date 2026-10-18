
package com.javabs.modules.library.service.impl;

import com.javabs.modules.library.domain.LibraryRoom;
import com.javabs.utils.FileUtil;
import com.javabs.utils.PageUtil;
import com.javabs.utils.QueryHelp;
import com.javabs.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import com.javabs.modules.library.repository.LibraryRoomRepository;
import com.javabs.modules.library.service.LibraryRoomService;
import com.javabs.modules.library.service.dto.LibraryRoomDto;
import com.javabs.modules.library.service.dto.LibraryRoomQueryCriteria;
import com.javabs.modules.library.service.mapstruct.LibraryRoomMapper;
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
public class LibraryRoomServiceImpl implements LibraryRoomService {

    private final LibraryRoomRepository libraryRoomRepository;
    private final LibraryRoomMapper libraryRoomMapper;

    @Override
    public Map<String,Object> queryAll(LibraryRoomQueryCriteria criteria, Pageable pageable){
        Page<LibraryRoom> page = libraryRoomRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(libraryRoomMapper::toDto));
    }

    @Override
    public List<LibraryRoomDto> queryAll(LibraryRoomQueryCriteria criteria){
        return libraryRoomMapper.toDto(libraryRoomRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public LibraryRoomDto findById(Integer id) {
        LibraryRoom libraryRoom = libraryRoomRepository.findById(id).orElseGet(LibraryRoom::new);
        ValidationUtil.isNull(libraryRoom.getId(),"LibraryRoom","id",id);
        return libraryRoomMapper.toDto(libraryRoom);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LibraryRoomDto create(LibraryRoom resources) {
        return libraryRoomMapper.toDto(libraryRoomRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LibraryRoom resources) {
        LibraryRoom libraryRoom = libraryRoomRepository.findById(resources.getId()).orElseGet(LibraryRoom::new);
        ValidationUtil.isNull( libraryRoom.getId(),"LibraryRoom","id",resources.getId());
        libraryRoom.copy(resources);
        libraryRoomRepository.save(libraryRoom);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            libraryRoomRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<LibraryRoomDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (LibraryRoomDto libraryRoom : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("名称", libraryRoom.getName());
            map.put("地址", libraryRoom.getAddress());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
