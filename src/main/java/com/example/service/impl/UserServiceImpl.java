package com.example.service.impl;


import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ArrayList<UserDTO> getAllUser() {
        List<User> users = userRepository.findAll();
        ArrayList<UserDTO> alUsers = new ArrayList<>();

        for (User user:users) {
            UserDTO userDTO = new UserDTO(
                    user.getId(),
                    user.getName(),
                    user.getAddress(),
                    user.getTele(),
                    user.getEmail()
            );
            alUsers.add(userDTO);
        }
        return alUsers;
    }

    @Override
    public UserDTO getUser(int userId) {
        User user = userRepository.findById(userId).get();
        UserDTO userDTO = new UserDTO(user.getId(),
                user.getName(),
                user.getAddress(),
                user.getTele(),
                user.getEmail());
        return userDTO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteUser(int userId) {
        userRepository.deleteById(userId);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveUser(UserDTO user) {
        User us = new User(user.getId(),
                user.getName(),
                user.getAddress(),
                user.getTele(),
                user.getEmail());
        userRepository.save(us);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateUser(UserDTO user) {
        User us = new User(user.getId(),
                user.getName(),
                user.getAddress(),
                user.getTele(),
                user.getEmail());
        userRepository.save(us);
        return true;
    }
}
