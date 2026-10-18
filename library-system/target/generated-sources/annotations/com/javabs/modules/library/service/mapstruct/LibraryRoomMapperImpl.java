package com.javabs.modules.library.service.mapstruct;

import com.javabs.modules.library.domain.LibraryRoom;
import com.javabs.modules.library.service.dto.LibraryRoomDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-03T17:35:23+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
@Component
public class LibraryRoomMapperImpl implements LibraryRoomMapper {

    @Override
    public LibraryRoom toEntity(LibraryRoomDto dto) {
        if ( dto == null ) {
            return null;
        }

        LibraryRoom libraryRoom = new LibraryRoom();

        libraryRoom.setId( dto.getId() );
        libraryRoom.setName( dto.getName() );
        libraryRoom.setAddress( dto.getAddress() );

        return libraryRoom;
    }

    @Override
    public LibraryRoomDto toDto(LibraryRoom entity) {
        if ( entity == null ) {
            return null;
        }

        LibraryRoomDto libraryRoomDto = new LibraryRoomDto();

        libraryRoomDto.setId( entity.getId() );
        libraryRoomDto.setName( entity.getName() );
        libraryRoomDto.setAddress( entity.getAddress() );

        return libraryRoomDto;
    }

    @Override
    public List<LibraryRoom> toEntity(List<LibraryRoomDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<LibraryRoom> list = new ArrayList<LibraryRoom>( dtoList.size() );
        for ( LibraryRoomDto libraryRoomDto : dtoList ) {
            list.add( toEntity( libraryRoomDto ) );
        }

        return list;
    }

    @Override
    public List<LibraryRoomDto> toDto(List<LibraryRoom> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LibraryRoomDto> list = new ArrayList<LibraryRoomDto>( entityList.size() );
        for ( LibraryRoom libraryRoom : entityList ) {
            list.add( toDto( libraryRoom ) );
        }

        return list;
    }
}
