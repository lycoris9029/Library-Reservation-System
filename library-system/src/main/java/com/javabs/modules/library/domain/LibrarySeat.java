
package com.javabs.modules.library.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.io.Serializable;

/**
*
* @description /
* @author 李寻欢
* @date 2023-04-02
**/
@Entity
@Data
@Table(name="library_seat")
public class LibrarySeat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "id")
    private Integer id;

    @Column(name = "`card`")
    @ApiModelProperty(value = "座位编号")
    private String card;

    @Column(name = "`room_id`")
    @ApiModelProperty(value = "roomId")
    private Integer roomId;

    @Column(name = "`room_name`")
    @ApiModelProperty(value = "所属阅览室")
    private String roomName;

    @Column(name = "`status`")
    @ApiModelProperty(value = "状态")
    private Integer status;

    public void copy(LibrarySeat source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
