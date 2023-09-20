package com.aston.service;

import com.aston.entity.Role;
import com.aston.entity.User;
import com.aston.repository.UserRepository;
import com.aston.dto.UserDto;
import com.aston.util.mapper.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements RestService<User, UserDto> {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(User user) {
        repository.save(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = repository.findAll();
        return users
                .stream()
                .map(UserMapper.instance::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        User user = repository
                .findById(id)
                .orElseGet(() -> new User(-1L, "emptyUser", new Role()));
        return UserMapper.instance.entityToDto(user);
    }

    @Override
    public void update(User user) {
        if (repository.existsById(user.getId())) repository.save(user);
    }

    @Override
    public void delete(User user) {
        if (repository.existsById(user.getId())) repository.delete(user);
    }
}