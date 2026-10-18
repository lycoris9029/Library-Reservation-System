
package com.javabs.modules.system.service.mapstruct;

import com.javabs.base.BaseMapper;
import com.javabs.modules.system.domain.Role;
import com.javabs.modules.system.service.dto.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author 李寻欢
 * @date 2023-03-23
 */
@Mapper(componentModel = "spring", uses = {MenuMapper.class, DeptMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends BaseMapper<RoleDto, Role> {

}
