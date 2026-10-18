
package com.javabs.modules.library.service;

import com.javabs.modules.library.domain.LibraryRoom;
import com.javabs.modules.library.service.dto.LibraryRoomDto;
import com.javabs.modules.library.service.dto.LibraryRoomQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* 
* @description 服务接口
* @author 李寻欢
* @date 2023-04-02
**/
public interface LibraryRoomService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(LibraryRoomQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<LibraryRoomDto>
    */
    List<LibraryRoomDto> queryAll(LibraryRoomQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return LibraryRoomDto
     */
    LibraryRoomDto findById(Integer id);

    /**
    * 创建
    * @param resources /
    * @return LibraryRoomDto
    */
    LibraryRoomDto create(LibraryRoom resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(LibraryRoom resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Integer[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<LibraryRoomDto> all, HttpServletResponse response) throws IOException;
}
