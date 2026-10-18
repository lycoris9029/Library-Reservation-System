
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
* @date 2023-04-02
**/
@Entity
@Data
@Table(name="library_book")
public class LibraryBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id`")
    @ApiModelProperty(value = "id")
    private Integer id;

    @Column(name = "`name`")
    @ApiModelProperty(value = "名字")
    private String name;

    @Column(name = "`price`")
    @ApiModelProperty(value = "价格")
    private Double price;

    @Column(name = "`author`")
    @ApiModelProperty(value = "作者")
    private String author;

    @Column(name = "`press`")
    @ApiModelProperty(value = "出版社")
    private String press;

    @Column(name = "`press_time`")
    @CreationTimestamp
    @ApiModelProperty(value = "出版时间")
    private Timestamp pressTime;

    public void copy(LibraryBook source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
