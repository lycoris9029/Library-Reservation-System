
package com.javabs.modules.library.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
*
* @description /
* @author 李寻欢
* @date 2023-04-02
**/
@Data
public class LibraryBookDto implements Serializable {

    private Integer id;

    /** 名字 */
    private String name;

    /** 价格 */
    private Double price;

    /** 作者 */
    private String author;

    /** 出版社 */
    private String press;

    /** 出版时间 */
    private Timestamp pressTime;
}
