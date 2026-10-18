package com.javabs.modules.library.service.mapstruct;

import com.javabs.modules.library.domain.LibraryBook;
import com.javabs.modules.library.service.dto.LibraryBookDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-03T17:35:22+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
@Component
public class LibraryBookMapperImpl implements LibraryBookMapper {

    @Override
    public LibraryBook toEntity(LibraryBookDto dto) {
        if ( dto == null ) {
            return null;
        }

        LibraryBook libraryBook = new LibraryBook();

        libraryBook.setId( dto.getId() );
        libraryBook.setName( dto.getName() );
        libraryBook.setPrice( dto.getPrice() );
        libraryBook.setAuthor( dto.getAuthor() );
        libraryBook.setPress( dto.getPress() );
        libraryBook.setPressTime( dto.getPressTime() );

        return libraryBook;
    }

    @Override
    public LibraryBookDto toDto(LibraryBook entity) {
        if ( entity == null ) {
            return null;
        }

        LibraryBookDto libraryBookDto = new LibraryBookDto();

        libraryBookDto.setId( entity.getId() );
        libraryBookDto.setName( entity.getName() );
        libraryBookDto.setPrice( entity.getPrice() );
        libraryBookDto.setAuthor( entity.getAuthor() );
        libraryBookDto.setPress( entity.getPress() );
        libraryBookDto.setPressTime( entity.getPressTime() );

        return libraryBookDto;
    }

    @Override
    public List<LibraryBook> toEntity(List<LibraryBookDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<LibraryBook> list = new ArrayList<LibraryBook>( dtoList.size() );
        for ( LibraryBookDto libraryBookDto : dtoList ) {
            list.add( toEntity( libraryBookDto ) );
        }

        return list;
    }

    @Override
    public List<LibraryBookDto> toDto(List<LibraryBook> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LibraryBookDto> list = new ArrayList<LibraryBookDto>( entityList.size() );
        for ( LibraryBook libraryBook : entityList ) {
            list.add( toDto( libraryBook ) );
        }

        return list;
    }
}
