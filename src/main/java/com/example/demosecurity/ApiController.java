package com.example.demosecurity;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ayoub ANBARA
 */
@RestController("api/v1/")
public class ApiController {

    String apiDemo(){
        return "Hello Api";
    }
}
