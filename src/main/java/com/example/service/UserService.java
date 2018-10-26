package com.example.service;

import com.example.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {

    public ArrayList<UserDTO> getAllUser();

    public UserDTO getUser(int userId);

    public boolean deleteUser(int userId);

    public boolean saveUser(UserDTO user);

    public boolean updateUser(UserDTO user);

}
