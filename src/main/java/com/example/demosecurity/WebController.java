package com.example.demosecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ayoub ANBARA
 */

@RestController
public class WebController {

    @GetMapping("/")
    String publicPage() {
        return "hello ";
    }

    @GetMapping("/private")
    String privatePage(Authentication authentication) {
       // User user = (User) authentication.getPrincipal();

        return "private ";
    }
}
