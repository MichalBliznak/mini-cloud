package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by michalbliznak on 4.8.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Greeting {

    private final String content;

    public Greeting() {
        this.content = "";
    }
    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
