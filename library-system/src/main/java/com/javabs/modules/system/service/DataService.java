
package com.javabs.modules.system.service;

import com.javabs.modules.system.service.dto.UserDto;

import java.util.List;

/**
 * 数据权限服务类
 * @author 李寻欢
 * @date 2023-03-07
 */
public interface DataService {

    /**
     * 获取数据权限
     * @param user /
     * @return /
     */
    List<Long> getDeptIds(UserDto user);
}
