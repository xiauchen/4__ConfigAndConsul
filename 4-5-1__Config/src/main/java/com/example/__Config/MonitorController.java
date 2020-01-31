package com.example.__Config;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

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
    @RequestMapping(value = "/monitorrs")
    @ResponseBody
    public Mono<String> monitorrs(@RequestParam(value = "path", defaultValue = "*") String pathName) throws InterruptedException {
            WebClient webClient = WebClient.builder()
                    .baseUrl("http://localhost:8889")
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded")
                    .build();
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>(1);
            formData.add("path", pathName);
            return webClient.method(HttpMethod.POST).uri("/monitor")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class);
//            Mono<String> response = webClient.method(HttpMethod.POST).uri("/monitor")
//                    .contentType(MediaType.APPLICATION_JSON_UTF8)
//                    .body(BodyInserters.fromFormData(formData))
//                    .retrieve()
//                    .bodyToMono(String.class).timeout(Duration.of(16, ChronoUnit.SECONDS));
//            Thread.sleep(5000);
//            return HttpStatus.OK;
//            return response;
//            String data = response.block();
//            System.out.println("WebPostDemo result----- " + data);
    }
}

