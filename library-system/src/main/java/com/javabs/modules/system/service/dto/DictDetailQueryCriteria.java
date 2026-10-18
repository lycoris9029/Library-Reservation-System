
package com.javabs.modules.system.service.dto;

import com.javabs.annotation.Query;
import lombok.Data;

/**
* @author 李寻欢
* @date 2023-04-10
*/
@Data
public class DictDetailQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String label;

    @Query(propName = "name",joinName = "dict")
    private String dictName;
}
