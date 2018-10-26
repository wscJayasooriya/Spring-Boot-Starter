package com.example.controller;

import com.example.dto.UserDTO;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<UserDTO> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUser(@PathVariable("id") int userid) {
        return userService.getUser(userid);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteUser(@PathVariable("id") int userId) {
        return userService.deleteUser(userId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveUser(@RequestBody UserDTO user) {
        return userService.saveUser(user);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateUser(@RequestBody UserDTO user){
        return userService.updateUser(user);
    }
}
