package com.example.__EurekaClient;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingControler {
    @RequestMapping("/greeting")
    String greeting();

}
