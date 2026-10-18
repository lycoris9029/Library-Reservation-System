
package com.javabs.modules.system.service.mapstruct;

import com.javabs.base.BaseMapper;
import com.javabs.modules.system.domain.Dict;
import com.javabs.modules.system.service.dto.DictSmallDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author 李寻欢
* @date 2023-04-10
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictSmallMapper extends BaseMapper<DictSmallDto, Dict> {

}
