
package com.javabs.modules.library.service.dto;

import com.javabs.annotation.Query;
import lombok.Data;
import java.util.List;

/**
*
* @author 李寻欢
* @date 2023-04-03
**/
@Data
public class LibraryVolationQueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String sendName;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String receiveName;
}
