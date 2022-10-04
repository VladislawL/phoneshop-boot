package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.exception.GithubUserIdNotFound;
import com.expertsoft.phoneshop.persistence.model.GithubUser;
import com.expertsoft.phoneshop.persistence.model.User;
import com.expertsoft.phoneshop.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByGithubUserId(Integer githubUserId) {
        return userRepository.findByGithubUserId(githubUserId).orElseThrow(() -> new GithubUserIdNotFound(githubUserId));
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUserForGithubUser(GithubUser githubUser) {
        User user = new User();
        user.setUsername(githubUser.getUsername());
        user.setName(githubUser.getName());
        user.setBio(githubUser.getBio());
        user.setAvatarUrl(githubUser.getAvatarUrl());
        user.setLocation(githubUser.getLocation());
        user.setCompany(githubUser.getCompany());
        user.setGithubUserId(githubUser.getId());
        user.setRole("USER");
        return userRepository.save(user);
    }

    @Override
    public boolean userExistsForGithubUserId(Integer githubUserId) {
        return userRepository.existsByGithubUserId(githubUserId);
    }
}
