package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.security.oauth2.GithubUser;
import com.expertsoft.phoneshop.persistence.model.User;

import java.util.List;

public interface UserService {
    User findUserByGithubUserId(Integer githubUserId);
    List<User> findAllUsers();
    User createUserForGithubUser(GithubUser githubUser);
    boolean userExistsForGithubUserId(Integer githubUserId);
}
