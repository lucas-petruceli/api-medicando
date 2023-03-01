package com.api.medicando.main.controller;


import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.medicando.main.data.Questoes;
import com.api.medicando.main.exceptions.UnsupportedMathOperationException;


@RestController
public class QuestoesController {

    private static final String template ="Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(QuestoesController.class.getName());

    @RequestMapping(
        value = "/questoes",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Questoes questoes(
        @RequestParam(value = "name", defaultValue = "world") String name
    ){
        logger.info(name);
        
        if(name.length() > 5){
            throw new UnsupportedMathOperationException("Nome muito grande");
        }
        return new Questoes(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(
        value = "questoes/cadastrar",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Questoes createQuestoes(@RequestBody Questoes questoes){
        return questoes;
    }
}
