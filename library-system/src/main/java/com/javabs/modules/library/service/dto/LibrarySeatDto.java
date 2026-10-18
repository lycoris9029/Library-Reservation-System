
package com.javabs.modules.library.service.dto;

import lombok.Data;
import java.io.Serializable;

/**
*
* @description /
* @author 李寻欢
* @date 2023-04-02
**/
@Data
public class LibrarySeatDto implements Serializable {

    private Integer id;

    /** 座位编号 */
    private String card;

    private Integer roomId;

    /** 所属阅览室 */
    private String roomName;

    /** 状态 */
    private Integer status;
}
