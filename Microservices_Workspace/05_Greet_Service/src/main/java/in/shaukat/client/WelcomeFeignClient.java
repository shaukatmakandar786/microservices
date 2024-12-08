package in.shaukat.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Welcome-Service")
public interface WelcomeFeignClient {

    @GetMapping("/welcome")
    String getWelcomeMsg();
}
