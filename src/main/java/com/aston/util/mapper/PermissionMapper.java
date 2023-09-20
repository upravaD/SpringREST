package com.aston.util.mapper;

import com.aston.dto.PermissionDto;
import com.aston.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermissionMapper {
    PermissionMapper instance = Mappers.getMapper(PermissionMapper.class);
    PermissionDto entityToDto(Permission permission);
}
