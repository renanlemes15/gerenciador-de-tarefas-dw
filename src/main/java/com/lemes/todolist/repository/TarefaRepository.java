package com.lemes.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lemes.todolist.model.Tarefa;
import java.util.List;


public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    
    public List<Tarefa> findByDescricao(String descricao);
    
    public List<Tarefa> findByConcluida(boolean concluida);
}
