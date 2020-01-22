package com.example.__EurekaClient;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingControler {
    @PostMapping(value = "/greeting")
    String greeting();

}
