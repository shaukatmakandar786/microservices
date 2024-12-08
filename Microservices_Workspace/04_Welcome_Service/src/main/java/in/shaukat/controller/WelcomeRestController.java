package in.shaukat.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

    @Autowired
    private Environment env;

    @GetMapping("/welcome")
    public String welcomeMsg(){

        String port = env.getProperty("server.port");
        return "Welcome to shaukat.com ...! ("+port+")";
    }
}
