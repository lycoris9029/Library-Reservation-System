
package com.javabs.modules.library.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
*
* @description /
* @author 李寻欢
* @date 2023-04-03
**/
@Data
public class LibraryVolationDto implements Serializable {

    private Integer id;

    private Long sendId;

    /** 举报人 */
    private String sendName;

    private Long receiveId;

    /** 举报对象 */
    private String receiveName;

    /** 举报时间 */
    private Timestamp sendTime;

    /** 状态 */
    private Integer status;

    /** 扣除信用分 */
    private Integer num;

    /** 违规详情 */
    private String remark;
}
