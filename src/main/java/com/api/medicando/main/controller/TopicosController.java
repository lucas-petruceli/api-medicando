package com.api.medicando.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.medicando.main.db.repositories.TopicosRepository;
import com.api.medicando.main.db.tables.Topico;

@RestController
public class TopicosController {
    @Autowired
    private TopicosRepository topicosRepository;
    
    @RequestMapping(
        value = "topicos/matricula",
        method = RequestMethod.GET
    )
    public List<Topico> getTopicos(){
        List<Topico> topicos = topicosRepository.findByModulo(2);
        return topicos;
    }
}
