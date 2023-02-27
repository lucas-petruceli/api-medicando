package com.api.medicando.main.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.medicando.main.data.Questoes;

@RestController
public class QuestoesController {

    private static final String template ="Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping("/questoes")
    public Questoes questoes(
        @RequestParam(value = "name", defaultValue = "world") String name
    ){
        return new Questoes(counter.incrementAndGet(), String.format(template, name));
    }
    
}
