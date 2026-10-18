
package com.javabs.modules.library.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
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
@Table(name="library_volation")
public class LibraryVolation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "id")
    private Integer id;

    @Column(name = "`send_id`")
    @ApiModelProperty(value = "sendId")
    private Long sendId;

    @Column(name = "`send_name`")
    @ApiModelProperty(value = "举报人")
    private String sendName;

    @Column(name = "`receive_id`")
    @ApiModelProperty(value = "receiveId")
    private Long receiveId;

    @Column(name = "`receive_name`")
    @ApiModelProperty(value = "举报对象")
    private String receiveName;

    @Column(name = "`send_time`")
    @ApiModelProperty(value = "举报时间")
    @CreationTimestamp
    private Timestamp sendTime;

    @Column(name = "`status`")
    @ApiModelProperty(value = "状态")
    private Integer status;

    @Column(name = "`num`")
    @ApiModelProperty(value = "扣除信用分")
    private Integer num;

    @Column(name = "`remark`")
    @ApiModelProperty(value = "违规详情")
    private String remark;

    public void copy(LibraryVolation source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
