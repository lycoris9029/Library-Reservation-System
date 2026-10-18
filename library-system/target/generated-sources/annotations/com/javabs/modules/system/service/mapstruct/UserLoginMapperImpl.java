package com.javabs.modules.system.service.mapstruct;

import com.javabs.modules.system.domain.Role;
import com.javabs.modules.system.domain.User;
import com.javabs.modules.system.service.dto.RoleSmallDto;
import com.javabs.modules.system.service.dto.UserLoginDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-03T17:35:23+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
@Component
public class UserLoginMapperImpl implements UserLoginMapper {

    @Override
    public User toEntity(UserLoginDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setCreateBy( dto.getCreateBy() );
        user.setUpdateBy( dto.getUpdateBy() );
        user.setCreateTime( dto.getCreateTime() );
        user.setUpdateTime( dto.getUpdateTime() );
        user.setId( dto.getId() );
        user.setRoles( roleSmallDtoSetToRoleSet( dto.getRoles() ) );
        user.setUsername( dto.getUsername() );
        user.setNickName( dto.getNickName() );
        user.setEmail( dto.getEmail() );
        user.setPhone( dto.getPhone() );
        user.setGender( dto.getGender() );
        user.setAvatarName( dto.getAvatarName() );
        user.setAvatarPath( dto.getAvatarPath() );
        user.setPassword( dto.getPassword() );
        user.setEnabled( dto.getEnabled() );
        user.setIsAdmin( dto.getIsAdmin() );
        user.setPwdResetTime( dto.getPwdResetTime() );
        user.setNum( dto.getNum() );

        return user;
    }

    @Override
    public UserLoginDto toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserLoginDto userLoginDto = new UserLoginDto();

        userLoginDto.setCreateBy( entity.getCreateBy() );
        userLoginDto.setUpdateBy( entity.getUpdateBy() );
        userLoginDto.setCreateTime( entity.getCreateTime() );
        userLoginDto.setUpdateTime( entity.getUpdateTime() );
        userLoginDto.setId( entity.getId() );
        userLoginDto.setRoles( roleSetToRoleSmallDtoSet( entity.getRoles() ) );
        userLoginDto.setUsername( entity.getUsername() );
        userLoginDto.setNickName( entity.getNickName() );
        userLoginDto.setEmail( entity.getEmail() );
        userLoginDto.setPhone( entity.getPhone() );
        userLoginDto.setGender( entity.getGender() );
        userLoginDto.setAvatarName( entity.getAvatarName() );
        userLoginDto.setAvatarPath( entity.getAvatarPath() );
        userLoginDto.setNum( entity.getNum() );
        userLoginDto.setPassword( entity.getPassword() );
        userLoginDto.setEnabled( entity.getEnabled() );
        userLoginDto.setIsAdmin( entity.getIsAdmin() );
        userLoginDto.setPwdResetTime( entity.getPwdResetTime() );

        return userLoginDto;
    }

    @Override
    public List<User> toEntity(List<UserLoginDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtoList.size() );
        for ( UserLoginDto userLoginDto : dtoList ) {
            list.add( toEntity( userLoginDto ) );
        }

        return list;
    }

    @Override
    public List<UserLoginDto> toDto(List<User> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserLoginDto> list = new ArrayList<UserLoginDto>( entityList.size() );
        for ( User user : entityList ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    protected Role roleSmallDtoToRole(RoleSmallDto roleSmallDto) {
        if ( roleSmallDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleSmallDto.getId() );
        role.setName( roleSmallDto.getName() );
        role.setDataScope( roleSmallDto.getDataScope() );
        role.setLevel( roleSmallDto.getLevel() );

        return role;
    }

    protected Set<Role> roleSmallDtoSetToRoleSet(Set<RoleSmallDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new HashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleSmallDto roleSmallDto : set ) {
            set1.add( roleSmallDtoToRole( roleSmallDto ) );
        }

        return set1;
    }

    protected RoleSmallDto roleToRoleSmallDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleSmallDto roleSmallDto = new RoleSmallDto();

        roleSmallDto.setId( role.getId() );
        roleSmallDto.setName( role.getName() );
        roleSmallDto.setLevel( role.getLevel() );
        roleSmallDto.setDataScope( role.getDataScope() );

        return roleSmallDto;
    }

    protected Set<RoleSmallDto> roleSetToRoleSmallDtoSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleSmallDto> set1 = new HashSet<RoleSmallDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleSmallDto( role ) );
        }

        return set1;
    }
}
