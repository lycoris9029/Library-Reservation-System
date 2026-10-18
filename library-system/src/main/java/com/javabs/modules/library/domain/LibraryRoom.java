
package com.javabs.modules.library.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
* 
* @description /
* @author 李寻欢
* @date 2023-04-02
**/
@Entity
@Data
@Table(name="library_room")
public class LibraryRoom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "id")
    private Integer id;

    @Column(name = "`name`")
    @ApiModelProperty(value = "名称")
    private String name;

    @Column(name = "`address`")
    @ApiModelProperty(value = "地址")
    private String address;

    public void copy(LibraryRoom source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
