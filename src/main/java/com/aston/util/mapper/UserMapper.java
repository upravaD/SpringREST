package com.aston.util.mapper;

import com.aston.dto.UserDto;
import com.aston.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper instance = Mappers.getMapper(UserMapper.class);
    UserDto entityToDto(User user);
}
