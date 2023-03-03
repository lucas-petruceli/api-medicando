package com.api.medicando.main.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.api.medicando.main.data.request.QuestaoRequest;
import com.api.medicando.main.db.repositories.AlternativaRepository;
import com.api.medicando.main.db.repositories.QuestoesAlternativasRepository;
import com.api.medicando.main.db.repositories.QuestoesRepository;
import com.api.medicando.main.db.repositories.QuestoesTopicosRepository;
import com.api.medicando.main.db.tables.Alternativa;
import com.api.medicando.main.db.tables.Questao;
import com.api.medicando.main.db.tables.QuestaoAlternativa;
import com.api.medicando.main.db.tables.QuestaoTopico;
import com.api.medicando.main.exceptions.UnsupportedMathOperationException;


@RestController
public class QuestoesController {
    // @RequestParam(value = "name", defaultValue = "world") String name

    @Autowired
    private QuestoesRepository questoesRepository;

    @Autowired
    private QuestoesTopicosRepository questoesTopicosRepository;

    @Autowired
    private QuestoesAlternativasRepository questoesAlternativasRepository;

    @Autowired
    private AlternativaRepository alternativaRepository;
    
    // private Logger logger = Logger.getLogger(QuestoesController.class.getName());

    @RequestMapping(
        value = "questoes/novas",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Questao> getQuestoesNovas(){
        List<Questao> questoesNovas = questoesRepository.findBySituacao('N');
        if(questoesNovas.isEmpty()){
            throw new UnsupportedMathOperationException("Nenhuma ocorrencia encontrada");
        }
        return questoesNovas;
    }

    @RequestMapping(
        value = "questoes/cadastrar",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> createQuestoes(@RequestBody QuestaoRequest body){
        try {

            if(!apenasUmCorreto(body.getAlternativas())){
                throw new UnsupportedMathOperationException("Nenhuma ou mais de uma alternativa correta");
            }
    
            Questao questao = questoesRepository.save(
                new Questao(body.getEnunciado(), body.getDificuldade(), body.getModulo())
            );
    
            if(questao.getId() <= 0){
                throw new UnsupportedMathOperationException("Ooops. problemas para cadastrar essa questão, valide os campos");
            }
    
            for(Integer idTopico: body.getTopicos()){
                QuestaoTopico questaoTopico = questoesTopicosRepository.save(
                    new QuestaoTopico(questao.getId(), idTopico)
                );

                if(questaoTopico.getIdQuestao() <= 0){
                    throw new UnsupportedMathOperationException("Ooops. problemas ao cadastrar topicos");
                    //roolback para tabela questao
                }
            }

            for(Alternativa item: body.getAlternativas()){
                Alternativa alternativa = alternativaRepository.save(
                    new Alternativa(item.getCorreta(), item.getTexto(), item.getCorrecao())
                );

                if(alternativa.getId() <= 0){
                    throw new UnsupportedMathOperationException("Ooops. problemas ao cadastrar as alternativas");
                    //roolback para tabela alternativa (caso uma ja tenha sido salva)
                    //roolback para tabela questao topicos
                    //roolback para tabela questao
                }
                
                QuestaoAlternativa questaoAlternativa = questoesAlternativasRepository.save(
                    new QuestaoAlternativa(questao.getId(), alternativa.getId())
                );

                if(questaoAlternativa.getIdQuestao() <= 0){
                    throw new UnsupportedMathOperationException("Ooops. problemas ao cadastrar as alternativas");
                    //roolback para tabela questao alternativas (caso uma ja tenha sido salva)
                    //roolback para tabela alternativa
                    //roolback para tabela questao topicos
                    //roolback para tabela questao
                }
            }
    
        } catch (UnsupportedMathOperationException e){
            throw new UnsupportedMathOperationException(e.getMessage());
        }
        catch (Exception e) {
            //criar um tipo para erro não esperado
            throw new UnsupportedMathOperationException("Ooops. Estamos com problemas");
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    private boolean apenasUmCorreto(List<Alternativa> alternativas) {
        int contadorCorretos = 0;
        for (Alternativa alternativa : alternativas) {
            if (alternativa.isCorreta()) {
                contadorCorretos++;
                if (contadorCorretos > 1) {
                    return false;
                }
            }
        }
        return contadorCorretos == 1;
    }
}
