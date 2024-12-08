package in.shaukat.controller;

import in.shaukat.client.WelcomeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {

    @Autowired
    private WelcomeFeignClient welcomeFeignClient;

    @GetMapping("/greet")
    public String greetMsg(){
        String welcomeMsg = welcomeFeignClient.getWelcomeMsg();
        return "Good Morning, "+welcomeMsg;
    }
}
