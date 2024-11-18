package com.example.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="campanhas")
public class Campanha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String solicitante;
    private String descricao;
    private double meta;
    public Campanha() {
    }

    
   public Campanha(String solicitante, String descricao, double meta) {
    this.solicitante = solicitante;
    this.descricao = descricao;
    this.meta = meta;
    }
    public Long getId() {
        return id;
    }
 public void setId(Long id) {
        this.id = id;
    }
    public String getSolicitante() {
        return solicitante;
    }
    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getMeta() {
        return meta;
    }
    public void setMeta(double meta) {
        this.meta = meta;
    }
}
