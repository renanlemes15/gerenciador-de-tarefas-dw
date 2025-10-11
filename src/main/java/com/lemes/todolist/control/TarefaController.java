package com.lemes.todolist.control;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lemes.todolist.model.Tarefa;
import com.lemes.todolist.repository.TarefaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class TarefaController {

    @Autowired
    TarefaRepository rep;


    @PostMapping("/")
    public ResponseEntity<Tarefa> createTarefa(@Valid @RequestBody Tarefa tarefa) {
        try {
            Tarefa novaTarefa = new Tarefa(tarefa.getDescricao(), tarefa.getPrioridade());

            novaTarefa.setConcluida(false);

            rep.save(novaTarefa);

            return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Tarefa>> getAllTarefas(@RequestParam(required = false) String descricao) {
        try {
            List<Tarefa> tarefas = new ArrayList<Tarefa>();
            if (descricao == null || descricao.trim().isEmpty()) {
                rep.findAll().forEach(tarefas::add);
            } else {
                rep.findByDescricaoContainingIgnoreCase(descricao).forEach(tarefas::add);
            }

            if (tarefas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tarefas, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getTarefaById(@PathVariable("id") Long id) {
        Optional<Tarefa> tar = rep.findById(id);

        if (tar.isPresent()) {
            return new ResponseEntity<>(tar.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> updateTarefa(@Valid @RequestBody Tarefa tarefa, @PathVariable("id") Long id) {
        Optional<Tarefa> tar = rep.findById(id);

        if (tar.isPresent()) {
            Tarefa atualizaTarefa = tar.get();

            atualizaTarefa.setDescricao(tarefa.getDescricao());
            atualizaTarefa.setPrioridade(tarefa.getPrioridade());
            atualizaTarefa.setConcluida(tarefa.isConcluida());

            return new ResponseEntity<>(rep.save(atualizaTarefa), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Tarefa> deleteTarefa(@PathVariable("id") Long id) {
        try{
            rep.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<Tarefa> concluirTarefa(@PathVariable Long id) {
        Optional<Tarefa> tar = rep.findById(id);

        if (tar.isPresent()) {
            Tarefa concluiTarefa = tar.get();
            concluiTarefa.setConcluida(true);
            return new ResponseEntity<>(rep.save(concluiTarefa), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<Tarefa>> getAllPendentes() {
        try{
            List<Tarefa> tarefas = new ArrayList<Tarefa>();

            rep.findByConcluida(false).forEach(tarefas::add);

            if(tarefas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(tarefas, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
    


