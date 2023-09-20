package com.aston.service;

import com.aston.dto.PermissionDto;
import com.aston.entity.Permission;
import com.aston.util.mapper.PermissionMapper;
import com.aston.repository.PermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionService implements RestService<Permission, PermissionDto> {

    private final PermissionRepository repository;

    @Autowired
    public PermissionService(PermissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Permission permission) {
        repository.save(permission);
    }

    @Override
    public List<PermissionDto> getAll() {
        List<Permission> permissions = repository.findAll();
        return permissions
                .stream()
                .map(PermissionMapper.instance::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PermissionDto findById(Long id) {
        Permission permission = repository
                .findById(id)
                .orElseGet(() -> new Permission(-1L, "emptyPermission", new ArrayList<>()));
        return PermissionMapper.instance.entityToDto(permission);
    }

    @Override
    public void update(Permission permission) {
        repository.save(permission);
    }

    @Override
    public void delete(Permission permission) {
        repository.delete(permission);
    }
}
