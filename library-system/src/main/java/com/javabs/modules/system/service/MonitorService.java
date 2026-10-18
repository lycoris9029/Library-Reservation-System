
package com.javabs.modules.system.service;

import java.util.Map;

/**
 * @author 李寻欢
 * @date 2023-03-02
 */
public interface MonitorService {

    /**
    * 查询数据分页
    * @return Map<String,Object>
    */
    Map<String,Object> getServers();
}
