
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
public class LibraryYuyueDto implements Serializable {

    private Integer id;

    private Long userId;

    /** 预约人 */
    private String userName;

    /** 阅览室 */
    private String roomName;

    private Integer seatId;

    /** 座位 */
    private String seatName;

    /** 状态，0.未签到，1，已签到，2.暂离，3.已签退 */
    private Integer status;

    /** 预约时间 */
    private Timestamp yyTime;

    /** 签到时间 */
    private Timestamp startTime;

    /** 签退时间 */
    private Timestamp endTime;
}
