
package com.javabs.modules.system.service.mapstruct;

import com.javabs.base.BaseMapper;
import com.javabs.modules.system.domain.Job;
import com.javabs.modules.system.service.dto.JobSmallDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author 李寻欢
* @date 2023-03-29
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobSmallMapper extends BaseMapper<JobSmallDto, Job> {

}
