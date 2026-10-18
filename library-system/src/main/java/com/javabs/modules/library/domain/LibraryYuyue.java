
package com.javabs.modules.library.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
*
* @description /
* @author 李寻欢
* @date 2023-04-03
**/
@Entity
@Data
@Table(name="library_yuyue")
public class LibraryYuyue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "id")
    private Integer id;

    @Column(name = "`user_id`")
    @ApiModelProperty(value = "userId")
    private Long userId;

    @Column(name = "`user_name`")
    @ApiModelProperty(value = "预约人")
    private String userName;

    @Column(name = "`room_name`")
    @ApiModelProperty(value = "阅览室")
    private String roomName;

    @Column(name = "`seat_id`")
    @ApiModelProperty(value = "seatId")
    private Integer seatId;

    @Column(name = "`seat_name`")
    @ApiModelProperty(value = "座位")
    private String seatName;

    @Column(name = "`status`")
    @ApiModelProperty(value = "状态，0.未签到，1，已签到，2.暂离，3.已签退")
    private Integer status;

    @Column(name = "`yy_time`")
    @CreationTimestamp
    @ApiModelProperty(value = "预约时间")
    private Timestamp yyTime;

    @Column(name = "`start_time`")
    @ApiModelProperty(value = "签到时间")
    private Timestamp startTime;

    @Column(name = "`end_time`")
    @ApiModelProperty(value = "签退时间")
    private Timestamp endTime;

    public void copy(LibraryYuyue source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
