package com.taemin.chat.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/oauth")
public class OAuthController {

    @GetMapping("/loginInfo")
    public ResponseEntity<?> oauthLoginInfo(Authentication authentication) {

        //oAuth2User.toString() 예시 : Name: [12345059213], Granted Authorities: [[USER]], User Attributes: [{id=12345059213, provider=google, name=곽태민, email=taminging2@gmail.com}]
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        //attributes.toString() 예시 : {id=12345059213, provider=google, name=곽태민, email=taminging@gmail.com}
        Map<String, Object> attributes = oAuth2User.getAttributes();

        return ResponseEntity.status(HttpStatus.OK)
                .body(attributes);
    }
}
