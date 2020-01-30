package com.example.__Config;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MonitorController {
    @RequestMapping(value = "/refresh")
    @ResponseBody
    public HttpStatus refresh(){
        try{
            return HttpStatus.OK;
        }finally {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, httpHeaders);
            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8889/actuator/bus-refresh",
                    request, String.class);
        }
    }
    @RequestMapping(value = "/refresh-monitor")
    @ResponseBody
    public HttpStatus refreshmonitor(@RequestParam(value = "path", defaultValue = "*") String pathName){
        try{
            return HttpStatus.OK;
        }finally {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            MultiValueMap<String, String> varParams= new LinkedMultiValueMap<String, String>();
            varParams.add("path", pathName);
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(varParams, httpHeaders);
            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8889/monitor",
                    request, String.class);
        }
    }
}
