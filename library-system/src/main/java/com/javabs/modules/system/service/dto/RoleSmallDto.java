
package com.javabs.modules.system.service.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * @author 李寻欢
 * @date 2023-03-23
 */
@Data
public class RoleSmallDto implements Serializable {

    private Long id;

    private String name;

    private Integer level;

    private String dataScope;
}
