package com.expertsoft.phoneshop.exception;

public class GithubUserIdNotFound extends RuntimeException {

    public GithubUserIdNotFound(Integer githubUserId) {
        super("Githubuser not found for id = " + githubUserId);
    }
}
