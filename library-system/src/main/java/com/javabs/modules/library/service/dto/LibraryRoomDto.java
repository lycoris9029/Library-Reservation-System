
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
public class LibraryRoomDto implements Serializable {

    private Integer id;

    /** 名称 */
    private String name;

    /** 地址 */
    private String address;
}
