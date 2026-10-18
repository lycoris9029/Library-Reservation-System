
package com.javabs.modules.system.service.dto;

import com.javabs.annotation.Query;
import lombok.Data;

/**
 * @author 李寻欢
 * 公共查询类
 */
@Data
public class DictQueryCriteria {

    @Query(blurry = "name,description")
    private String blurry;
}
