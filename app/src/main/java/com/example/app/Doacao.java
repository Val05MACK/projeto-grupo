package com.example.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="novasDoacoes")
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDoador;
    private double valor;

    @ManyToOne
    @JoinColumn(name = "campanha_id")
    private Campanha campanha;

    public Doacao(){}
    public Doacao(String nomeDoador, double valor, Campanha campanha) {
        this.nomeDoador = nomeDoador;
        this.valor = valor;
        this.campanha = campanha;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoador() {
        return nomeDoador;
    }

    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }
}
