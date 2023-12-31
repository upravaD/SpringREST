package com.aston.controller;

import com.aston.dto.UserDto;
import com.aston.entity.User;
import com.aston.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@ResponseBody
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/id")
    public UserDto getById(@RequestParam String id) {
        return service.findById(Long.parseLong(id));
    }

    @GetMapping
    public List<UserDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> add(@RequestBody User user) {
        service.create(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody User user, @RequestParam String id) {
        user.setId(Long.parseLong(id));
        service.update(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> delete(@RequestBody User user, @RequestParam String id) {
        user.setId(Long.parseLong(id));
        service.delete(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}