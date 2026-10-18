
package com.javabs.modules.system.service.mapstruct;

import com.javabs.base.BaseMapper;
import com.javabs.modules.system.domain.Dept;
import com.javabs.modules.system.service.dto.DeptDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author 李寻欢
* @date 2023-03-25
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptMapper extends BaseMapper<DeptDto, Dept> {
}
