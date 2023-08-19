package com.example.recipt_website_project.repo;

import com.example.recipt_website_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
