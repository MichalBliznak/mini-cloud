package services;

import configuration.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;

/**
 * Created by michalbliznak on 3.8.17.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class Application {

    @Bean
    public ServiceConfig config() {
        return new ServiceConfig();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
