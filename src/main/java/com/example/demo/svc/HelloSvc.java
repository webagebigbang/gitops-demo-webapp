package com.example.demo.svc;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSvc {
    private static int requestCount = 0;

    @GetMapping("/hello")
    public HashMap<String, Object> sayHello() {
        var output = new HashMap<String, Object>();

        output.put("greeting", "Hello!");
        output.put("requestCount", ++requestCount);

        //Access secrets using environment variables
        var dbUser = System.getenv("DB_USER");

        if (dbUser != null) {
            output.put("databaseUser", dbUser);
        }
        
        var dbPass = System.getenv("DB_PASSWORD");

        if (dbPass != null) {
            output.put("databasePassword", dbPass);
        }
        
        return output;
    }
}
