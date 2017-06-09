package com.lenovo.lic.interview.Endpoint.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenovo.lic.interview.Endpoint.model.Endpoint;

@RestController
public class EndpointController {
	
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/endpoint")
    public Endpoint greeting() {
        return new Endpoint(counter.incrementAndGet());
    }
}
