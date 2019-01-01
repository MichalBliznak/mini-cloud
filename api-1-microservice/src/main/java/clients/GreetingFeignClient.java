package clients;

import entities.Greeting;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("greeting")
public interface GreetingFeignClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api",
            consumes = "application/json"
    )
    Greeting getGreeting(@RequestParam("prefix") String prefix, @RequestParam("name") String name);
}
