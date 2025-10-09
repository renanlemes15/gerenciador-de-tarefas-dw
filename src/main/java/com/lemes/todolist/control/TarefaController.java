package com.lemes.todolist.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.lemes.todolist.repository.TarefaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TarefaController {
    
    @Autowired
    TarefaRepository rep;

    @PostMapping("/")
    public ResponseEntity(@RequestParam String param) {
        return new String();
    }
    
}
