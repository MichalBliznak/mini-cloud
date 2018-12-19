package services;

import entities.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by michalbliznak on 3.8.17.
 */
@RestController
public class HelloController {

    @LoadBalanced
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/greeting")
    public Greeting say(@RequestParam(value="name", defaultValue="World") String name) {
        try {
            return restTemplate.getForObject("http://greeting/api?prefix={prefix}&name={name}", Greeting.class, "Hello", name);
        } catch (Exception e) {
            return new Greeting("Ooops, something went wrong: " + e.getMessage());
        }
    }
}
