package com.expertsoft.phoneshop.persistence.repository;

import com.expertsoft.phoneshop.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    Optional<User> findByGithubUserId(Integer githubUserId);
    boolean existsByGithubUserId(Integer githubUserId);
}