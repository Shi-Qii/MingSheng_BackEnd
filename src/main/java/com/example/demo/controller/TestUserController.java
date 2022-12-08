package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@PreAuthorize("hasRole('ADMIN')")
public class TestUserController {
    //不透過認證前要做的事情@PreAuthorize 就不用登入就可以打入api  其他有加@PreAuthorize才能打入API
    @GetMapping("/all")
//	@PreAuthorize("hasRole('ADMIN')")
    public String allAccess() {
        return "Public Content.";
    }
///api/test/helloWord
    @GetMapping("/helloWord")
    public String hello123() {
        return "hell OK";
    }

    @GetMapping("/user")
    //ROLE_USER or ROLE_MODERATOR or ROLE_ADMIN的身分可打入api  其他api就看註釋說明符合該登入資訊
    //@PreAuthorize可以使用是因為已經在WebSecurityConfig的註釋@EnableGlobalMethodSecurity(prePostEnabled = true)開啟
    //所以可以調用這個annotation
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}