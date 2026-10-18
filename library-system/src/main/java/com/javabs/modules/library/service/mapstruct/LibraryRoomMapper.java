
package com.javabs.modules.library.service.mapstruct;

import com.javabs.base.BaseMapper;
import com.javabs.modules.library.domain.LibraryRoom;
import com.javabs.modules.library.service.dto.LibraryRoomDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
*
* @author 李寻欢
* @date 2023-04-02
**/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LibraryRoomMapper extends BaseMapper<LibraryRoomDto, LibraryRoom> {

}
