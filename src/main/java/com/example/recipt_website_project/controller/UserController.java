package com.example.recipt_website_project.controller;

import com.example.recipt_website_project.entity.Result;
import com.example.recipt_website_project.entity.User;
import com.example.recipt_website_project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("")
    public String hello(){
        return "welcome welcome!";
    }

    // 查詢全部的user
    @GetMapping("/search")
    public Result  getAllUsers(){
        List<User> userList = userRepo.findAll();
        return Result.success(userList);
    }

    // 增加一個user
    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
        try {
            userRepo.save(user);
            return "Saved...";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to create user...";
        }

    }

    // 修改user
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        try {
            User updatedUser = userRepo.findById(id).get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setNickname(user.getNickname());
            userRepo.save(updatedUser);

            return "id " + id + " has been updated...";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to update the user, id is "+ id +"...";
        }
    }

    // 刪除user
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        try{
            User deletedUser = userRepo.findById(id).get();
            System.out.println(deletedUser);
            userRepo.delete(deletedUser);
            return "Successfully delete user with the id: " + id;
        }catch (Exception e){
            return "Failed to delete the user, id is "+ id +"...";
        }
    }
}
