package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.persistence.model.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class GithubOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserService userService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(oAuth2UserRequest);
        Integer githubUserId = user.getAttribute("id");
        if (userService.userExistsForGithubUserId(githubUserId)) {
            return GithubUser.of(userService.findUserByGithubUserId(githubUserId));
        } else {
            GithubUser githubUser = populateGithubUser(user);
            return GithubUser.of(userService.createUserForGithubUser(githubUser));
        }
    }

    private GithubUser populateGithubUser(OAuth2User oAuth2User) {
        GithubUser githubUser = new GithubUser();
        githubUser.setId(oAuth2User.getAttribute("id"));
        githubUser.setUsername(oAuth2User.getAttribute("login"));
        githubUser.setBio(oAuth2User.getAttribute("bio"));
        githubUser.setAvatarUrl(oAuth2User.getAttribute("avatar_url"));
        githubUser.setName(oAuth2User.getAttribute("name"));
        githubUser.setCompany(oAuth2User.getAttribute("company"));
        githubUser.setLocation(oAuth2User.getAttribute("location"));
        return  githubUser;
    }
}
