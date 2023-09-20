package com.aston.util.mapper;

import com.aston.dto.RoleDto;
import com.aston.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper instance = Mappers.getMapper(RoleMapper.class);
    RoleDto entityToDto(Role role);
}
