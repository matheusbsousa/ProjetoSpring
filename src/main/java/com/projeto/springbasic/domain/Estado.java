package com.projeto.springbasic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ESTADO")
public class Estado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ESTADO")
    private Integer id;
    
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @Column(name = "ABREVIACAO")
    private String abreviacao;
    
    public Estado(Integer id, String descricao, String abreviacao) {
        this.id = id;
        this.descricao = descricao;
        this.abreviacao = abreviacao;
    }

    public Estado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }
}
