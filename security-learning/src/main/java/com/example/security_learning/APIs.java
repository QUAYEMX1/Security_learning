package com.example.security_learning;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIs {

    @GetMapping("hiAll")
    public String hello() {
        return "Hi all, Welcome to spring security learning";
    }

    @GetMapping("hiAdmin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String helloAdmin() {
        return "Hi Admin!, welcome ";
    }

    @GetMapping("hiUser")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String helloUser() {
        return "Hi! user, Welcome";
    }
}
