
package com.javabs.modules.library.service.mapstruct;

import com.javabs.base.BaseMapper;
import com.javabs.modules.library.domain.LibrarySeat;
import com.javabs.modules.library.service.dto.LibrarySeatDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
*
* @author 李寻欢
* @date 2023-04-02
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LibrarySeatMapper extends BaseMapper<LibrarySeatDto, LibrarySeat> {

}
