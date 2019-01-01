package services;

import clients.GreetingFeignClient;
import entities.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by michalbliznak on 3.8.17.
 */
@RestController
public class HelloController {

    @Autowired
    GreetingFeignClient greetingClient;

    @RequestMapping("/greeting")
    public Greeting say(@RequestParam(value="name", defaultValue="World") String name) {
        try {
            return greetingClient.getGreeting("Hello", name);
        } catch (Exception e) {
            return new Greeting("Ooops, something went wrong: " + e.getMessage());
        }
    }
}
