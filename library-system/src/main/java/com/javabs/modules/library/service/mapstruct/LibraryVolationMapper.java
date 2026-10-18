
package com.javabs.modules.library.service.mapstruct;

import com.javabs.base.BaseMapper;
import com.javabs.modules.library.domain.LibraryVolation;
import com.javabs.modules.library.service.dto.LibraryVolationDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
*
* @author 李寻欢
* @date 2023-04-03
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LibraryVolationMapper extends BaseMapper<LibraryVolationDto, LibraryVolation> {

}
