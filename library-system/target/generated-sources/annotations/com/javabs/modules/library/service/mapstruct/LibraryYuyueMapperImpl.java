package com.javabs.modules.library.service.mapstruct;

import com.javabs.modules.library.domain.LibraryYuyue;
import com.javabs.modules.library.service.dto.LibraryYuyueDto;
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
public class LibraryYuyueMapperImpl implements LibraryYuyueMapper {

    @Override
    public LibraryYuyue toEntity(LibraryYuyueDto dto) {
        if ( dto == null ) {
            return null;
        }

        LibraryYuyue libraryYuyue = new LibraryYuyue();

        libraryYuyue.setId( dto.getId() );
        libraryYuyue.setUserId( dto.getUserId() );
        libraryYuyue.setUserName( dto.getUserName() );
        libraryYuyue.setRoomName( dto.getRoomName() );
        libraryYuyue.setSeatId( dto.getSeatId() );
        libraryYuyue.setSeatName( dto.getSeatName() );
        libraryYuyue.setStatus( dto.getStatus() );
        libraryYuyue.setYyTime( dto.getYyTime() );
        libraryYuyue.setStartTime( dto.getStartTime() );
        libraryYuyue.setEndTime( dto.getEndTime() );

        return libraryYuyue;
    }

    @Override
    public LibraryYuyueDto toDto(LibraryYuyue entity) {
        if ( entity == null ) {
            return null;
        }

        LibraryYuyueDto libraryYuyueDto = new LibraryYuyueDto();

        libraryYuyueDto.setId( entity.getId() );
        libraryYuyueDto.setUserId( entity.getUserId() );
        libraryYuyueDto.setUserName( entity.getUserName() );
        libraryYuyueDto.setRoomName( entity.getRoomName() );
        libraryYuyueDto.setSeatId( entity.getSeatId() );
        libraryYuyueDto.setSeatName( entity.getSeatName() );
        libraryYuyueDto.setStatus( entity.getStatus() );
        libraryYuyueDto.setYyTime( entity.getYyTime() );
        libraryYuyueDto.setStartTime( entity.getStartTime() );
        libraryYuyueDto.setEndTime( entity.getEndTime() );

        return libraryYuyueDto;
    }

    @Override
    public List<LibraryYuyue> toEntity(List<LibraryYuyueDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<LibraryYuyue> list = new ArrayList<LibraryYuyue>( dtoList.size() );
        for ( LibraryYuyueDto libraryYuyueDto : dtoList ) {
            list.add( toEntity( libraryYuyueDto ) );
        }

        return list;
    }

    @Override
    public List<LibraryYuyueDto> toDto(List<LibraryYuyue> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LibraryYuyueDto> list = new ArrayList<LibraryYuyueDto>( entityList.size() );
        for ( LibraryYuyue libraryYuyue : entityList ) {
            list.add( toDto( libraryYuyue ) );
        }

        return list;
    }
}
