package com.example.__EurekaClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cfg")
@RefreshScope
public class ConfigController {
    @Value("${foo}")
    String foo;

    @Value("${bar}")
    String bar;

    @Value("${eureka.instance.metadata-map.Loadblance}")
    String loadbalance;

    @RequestMapping(value = "/foo")
    public String foo(){
        return foo + "——" + bar;
    }
    @RequestMapping(value = "/matadata")
    public String matadata(){
        return loadbalance;
    }
}
