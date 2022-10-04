package com.expertsoft.phoneshop.exception;

public class GithubUserIdNotFound extends RuntimeException {
    private Integer githubUserId;

    public GithubUserIdNotFound(Integer githubUserId) {
        this.githubUserId = githubUserId;
    }

    @Override
    public String toString() {
        return "GithubUserIdNotFound{" +
                "githubUserId=" + githubUserId +
                '}';
    }
}
