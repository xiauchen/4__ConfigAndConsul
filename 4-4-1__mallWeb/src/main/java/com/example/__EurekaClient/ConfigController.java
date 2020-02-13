package com.example.__EurekaClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cfg")
@Configuration
@EnableAutoConfiguration
@RefreshScope
public class ConfigController {
    @Value("${time}")
    String time;

    @Value("${food}")
    String food;

    @Value("${location}")
    String location;

    @Value("${eureka.instance.metadata-map.Loadbalance}")
    String loadbalance;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        String test_string = "酒館營業時間： "+time + "</br>"
                            + "今日特餐： " + food + "</br>"
                            + "<font color=\"green\">" + "酒館地址： " + location;
        return test_string;
    }

    @RequestMapping(value = "/matadata")
    public String matadata(){
        return loadbalance;
    }
}
