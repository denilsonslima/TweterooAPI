package com.project.api.repository;

import com.project.api.models.TweetsModels;
import com.project.api.models.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModels, Long> {
    UserModels findByUsername(String username);
}
