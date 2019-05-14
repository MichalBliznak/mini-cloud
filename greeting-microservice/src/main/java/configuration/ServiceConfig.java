package configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {

    @Value("${message.prefix}")
    private String messagePrefix;

    public String getMessagePrefix() {
        return messagePrefix;
    }
}
