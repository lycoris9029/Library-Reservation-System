
package com.javabs.modules.system.service.mapstruct;

import com.javabs.base.BaseMapper;
import com.javabs.modules.system.domain.DictDetail;
import com.javabs.modules.system.service.dto.DictDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author 李寻欢
* @date 2023-04-10
*/
@Mapper(componentModel = "spring", uses = {DictSmallMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends BaseMapper<DictDetailDto, DictDetail> {

}
