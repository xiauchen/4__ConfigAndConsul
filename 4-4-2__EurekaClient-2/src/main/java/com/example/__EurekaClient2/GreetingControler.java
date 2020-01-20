package com.example.__EurekaClient2;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingControler {
    @RequestMapping("/greeting")
    String greeting();

}
