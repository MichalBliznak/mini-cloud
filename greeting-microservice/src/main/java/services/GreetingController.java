package services;

import configuration.ServiceConfig;
import entities.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by michalbliznak on 6.8.17.
 */
@RestController
public class GreetingController {

    final UUID uuid = UUID.randomUUID();

    @Autowired
    private ServiceConfig config;

    @RequestMapping("/")
    public Greeting say(@RequestParam(value="prefix", defaultValue="...") String prefix, @RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(config.getMessagePrefix() + prefix + " " + name + ", says " + uuid.toString());
    }
}