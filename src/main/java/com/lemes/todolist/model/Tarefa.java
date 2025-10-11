package com.lemes.todolist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Tarefa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "A descrição não pode ser vazia ou nula.")
    @Column(nullable = false, length = 100)
    private String descricao;
    
    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean concluida;

    @NotNull(message = "A prioridade não pode ser nula.")
    @Min(value = 1, message = "A prioridade deve ser no mínimo 1.")
    @Max(value = 5, message = "A prioridade deve ser no máximo 5.")
    @Column(nullable = false)    
    private int prioridade;

    public Tarefa(){

    }

    public Tarefa(String descricao, int prioridade){
        this.descricao = descricao;
        this.prioridade = prioridade;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", descricao=" + descricao + ", concluida=" + concluida + ", prioridade="
                + prioridade + "]";
    }


    

}


