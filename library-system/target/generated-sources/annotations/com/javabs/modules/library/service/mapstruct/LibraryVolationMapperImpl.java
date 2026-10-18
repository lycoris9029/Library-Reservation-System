package com.javabs.modules.library.service.mapstruct;

import com.javabs.modules.library.domain.LibraryVolation;
import com.javabs.modules.library.service.dto.LibraryVolationDto;
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
public class LibraryVolationMapperImpl implements LibraryVolationMapper {

    @Override
    public LibraryVolation toEntity(LibraryVolationDto dto) {
        if ( dto == null ) {
            return null;
        }

        LibraryVolation libraryVolation = new LibraryVolation();

        libraryVolation.setId( dto.getId() );
        libraryVolation.setSendId( dto.getSendId() );
        libraryVolation.setSendName( dto.getSendName() );
        libraryVolation.setReceiveId( dto.getReceiveId() );
        libraryVolation.setReceiveName( dto.getReceiveName() );
        libraryVolation.setSendTime( dto.getSendTime() );
        libraryVolation.setStatus( dto.getStatus() );
        libraryVolation.setNum( dto.getNum() );
        libraryVolation.setRemark( dto.getRemark() );

        return libraryVolation;
    }

    @Override
    public LibraryVolationDto toDto(LibraryVolation entity) {
        if ( entity == null ) {
            return null;
        }

        LibraryVolationDto libraryVolationDto = new LibraryVolationDto();

        libraryVolationDto.setId( entity.getId() );
        libraryVolationDto.setSendId( entity.getSendId() );
        libraryVolationDto.setSendName( entity.getSendName() );
        libraryVolationDto.setReceiveId( entity.getReceiveId() );
        libraryVolationDto.setReceiveName( entity.getReceiveName() );
        libraryVolationDto.setSendTime( entity.getSendTime() );
        libraryVolationDto.setStatus( entity.getStatus() );
        libraryVolationDto.setNum( entity.getNum() );
        libraryVolationDto.setRemark( entity.getRemark() );

        return libraryVolationDto;
    }

    @Override
    public List<LibraryVolation> toEntity(List<LibraryVolationDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<LibraryVolation> list = new ArrayList<LibraryVolation>( dtoList.size() );
        for ( LibraryVolationDto libraryVolationDto : dtoList ) {
            list.add( toEntity( libraryVolationDto ) );
        }

        return list;
    }

    @Override
    public List<LibraryVolationDto> toDto(List<LibraryVolation> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LibraryVolationDto> list = new ArrayList<LibraryVolationDto>( entityList.size() );
        for ( LibraryVolation libraryVolation : entityList ) {
            list.add( toDto( libraryVolation ) );
        }

        return list;
    }
}
