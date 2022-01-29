package io.javabrains.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting:default-value}")
    private String greetingMessage;

    @Value("Some static message.")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

//    @Value("#{${db.connection}}")
//    private Map<String, String> dbValues;

    @Autowired
    private DBSettings dbSettings;

    @Autowired
    private Environment env;

    @GetMapping("/greeting")
    public String greeting() {
        return greetingMessage +
                "<br/>" + listValues +
                // "<br/>" + dbValues +
                "<br/>" + dbSettings;
    }

    @GetMapping("/envdetails")
    public String getEnvDetails() {
        return env.toString();
    }
}
