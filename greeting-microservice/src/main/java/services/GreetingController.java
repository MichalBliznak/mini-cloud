package services;

import entities.Greeting;
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

    @RequestMapping("/")
    public Greeting say(@RequestParam(value="prefix", defaultValue="...") String prefix, @RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(prefix + " " + name + ", says " + uuid.toString());
    }
}