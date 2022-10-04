package com.expertsoft.phoneshop.persistence.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GithubUser implements OAuth2User {
    private Integer id;

    private String username;

    private String name;

    private String bio;

    private String avatarUrl;

    private String location;

    private String company;

    private String role;

    public static GithubUser of(User user) {
        GithubUser githubUser = new GithubUser();
        githubUser.username = user.getUsername();
        githubUser.name = user.getName();
        githubUser.bio = user.getBio();
        githubUser.avatarUrl = user.getAvatarUrl();
        githubUser.location = user.getLocation();
        githubUser.company = user.getCompany();
        githubUser.role = user.getRole();
        return githubUser;
    }

    @Override
    public Map<String, Object> getAttributes() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("usename", username);
        attributes.put("name", name);
        attributes.put("bio", bio);
        attributes.put("avatarUrl", avatarUrl);
        attributes.put("location", location);
        attributes.put("company", company);
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getName() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
