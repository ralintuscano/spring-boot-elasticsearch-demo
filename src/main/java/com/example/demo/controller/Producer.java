package com.example.demo.controller;

import org.apache.kafka.common.protocol.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping("/publish")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void publishAndConvert(@RequestBody String message){
        System.out.println("Message received: " + message);
        streamBridge.send("uppercase-in-0", message);
    }

}
