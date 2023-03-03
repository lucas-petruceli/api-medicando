package com.api.medicando.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.medicando.main.data.DashBoard;
import com.api.medicando.main.db.repositories.QuestoesRepository;
import com.api.medicando.main.db.repositories.TopicosRepository;

@RestController
public class DashBoardController {
    @Autowired
    private QuestoesRepository questoesRepository;
    
    @Autowired
    private TopicosRepository topicosRepository;
    
    // private Logger logger = Logger.getLogger(DashBoardController.class.getName());

    @RequestMapping(
        value = "dashboard",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DashBoard getQuestoesNovas(){
        Integer qtdTopicosMatricula = topicosRepository.countTopicosMatricula();
        Integer qtdQuestoes = questoesRepository.countQuestoes();
        return new DashBoard(qtdTopicosMatricula, qtdQuestoes);
    }
}
