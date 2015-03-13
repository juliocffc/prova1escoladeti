/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.restserver.disciplina;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Alunos
 */
@Entity
public class Disciplina implements Serializable{

    @Id
    private long id;
    private String nome;
    private Integer cargaHoraria;
    private Double peso;

    public Disciplina() {
    }

    public Disciplina(long id, String nome, Integer cargaHoraria, Double peso) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.peso = peso;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public Double getPeso() {
        return peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
    
}
