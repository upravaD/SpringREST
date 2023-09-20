package com.aston;

import com.aston.dto.UserDto;
import com.aston.entity.Role;
import com.aston.entity.User;
import com.aston.util.mapper.UserMapper;

public class Main {

    public static void main(String[] args) {
        Role role = new Role();
        role.setId(1L);

        User user = new User();
        user.setUsername("testUser");
        user.setRole(role);

        UserDto userDto = UserMapper.instance.entityToDto(user);
        System.out.println(userDto);
    }
}