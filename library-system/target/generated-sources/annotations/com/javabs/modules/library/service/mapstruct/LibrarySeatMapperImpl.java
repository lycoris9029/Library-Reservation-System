package com.javabs.modules.library.service.mapstruct;

import com.javabs.modules.library.domain.LibrarySeat;
import com.javabs.modules.library.service.dto.LibrarySeatDto;
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
public class LibrarySeatMapperImpl implements LibrarySeatMapper {

    @Override
    public LibrarySeat toEntity(LibrarySeatDto dto) {
        if ( dto == null ) {
            return null;
        }

        LibrarySeat librarySeat = new LibrarySeat();

        librarySeat.setId( dto.getId() );
        librarySeat.setCard( dto.getCard() );
        librarySeat.setRoomId( dto.getRoomId() );
        librarySeat.setRoomName( dto.getRoomName() );
        librarySeat.setStatus( dto.getStatus() );

        return librarySeat;
    }

    @Override
    public LibrarySeatDto toDto(LibrarySeat entity) {
        if ( entity == null ) {
            return null;
        }

        LibrarySeatDto librarySeatDto = new LibrarySeatDto();

        librarySeatDto.setId( entity.getId() );
        librarySeatDto.setCard( entity.getCard() );
        librarySeatDto.setRoomId( entity.getRoomId() );
        librarySeatDto.setRoomName( entity.getRoomName() );
        librarySeatDto.setStatus( entity.getStatus() );

        return librarySeatDto;
    }

    @Override
    public List<LibrarySeat> toEntity(List<LibrarySeatDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<LibrarySeat> list = new ArrayList<LibrarySeat>( dtoList.size() );
        for ( LibrarySeatDto librarySeatDto : dtoList ) {
            list.add( toEntity( librarySeatDto ) );
        }

        return list;
    }

    @Override
    public List<LibrarySeatDto> toDto(List<LibrarySeat> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LibrarySeatDto> list = new ArrayList<LibrarySeatDto>( entityList.size() );
        for ( LibrarySeat librarySeat : entityList ) {
            list.add( toDto( librarySeat ) );
        }

        return list;
    }
}
