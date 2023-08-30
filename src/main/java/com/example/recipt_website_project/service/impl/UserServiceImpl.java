package com.example.recipt_website_project.service.impl;

import com.example.recipt_website_project.entity.User;
import com.example.recipt_website_project.repo.UserRepo;
import com.example.recipt_website_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public List<User> login(User user) {
        return userRepo.findAll();
    }
}
