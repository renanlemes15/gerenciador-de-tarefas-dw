package com.lemes.todolist.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.lemes.todolist.model.Tarefa;
import com.lemes.todolist.repository.TarefaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TarefaController {
    
    @Autowired
    TarefaRepository rep;

    
    @GetMapping("/")
    public ResponseEntity<List<Tarefa>> getAllTarefas(@RequestParam String param) {
        return new String();
    }
    

    @PostMapping("/")
    public ResponseEntity<Tarefa> createTarefa(@RequestBody Tarefa tar) {
        try {
            Tarefa t = rep.save(new Tarefa(tar.getDescricao(), tar.getPrioridade()));

            return new ResponseEntity<>(t, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);            
        }
        
        
    }
    
}
