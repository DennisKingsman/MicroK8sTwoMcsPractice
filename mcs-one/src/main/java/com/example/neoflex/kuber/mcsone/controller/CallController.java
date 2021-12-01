package com.example.neoflex.kuber.mcsone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/mcs1")
public class CallController {

    @Value( "${call.url}" )
    private String callUrl;

    private WebClient webClient;

    @Autowired
    public void setWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/call")
    public String helloWebClient() {
        String response = webClient.get()
                .uri(callUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return "Hello mcs 1. Message from mcs 2 is " + response;
    }

    @GetMapping("/test")
    public String test() {
        return "Test";
    }

}
