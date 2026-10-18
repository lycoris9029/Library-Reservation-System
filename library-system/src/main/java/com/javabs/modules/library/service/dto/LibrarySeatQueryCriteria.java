
package com.javabs.modules.library.service.dto;

import com.javabs.annotation.Query;
import lombok.Data;

/**
*
* @author 李寻欢
* @date 2023-04-02
**/
@Data
public class LibrarySeatQueryCriteria{

    /** 精确 */
    @Query
    private String card;

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String roomName;
}
