package com.example.aula.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Tab_Jogador")

public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "Sexo é obrigatório.")
    private String Sexo;

    @NotBlank(message = "Idade é obrigatória.")
    private String idade;

    @NotBlank(message = "Posição é obrigatória.")
    private String posicao;

    @NotNull(message = "Altura é obrigatória.")
    private Double altura;

    @NotNull(message = "Peso é obrigatório.")
    private Double peso;

    @NotBlank(message = "Numero da Camisa é obrigatório.")
    private String numero;

    public Jogador() {
    }


    public Jogador(Long id, String nome, String sexo, String idade, String posicao, Double altura, Double peso, String numero) {
        this.id = id;
        this.nome = nome;
        Sexo = sexo;
        this.idade = idade;
        this.posicao = posicao;
        this.altura = altura;
        this.peso = peso;
        this.numero = numero;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nome é obrigatório.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Sexo é obrigatório.") String getSexo() {
        return Sexo;
    }

    public void setSexo(@NotBlank(message = "Sexo é obrigatório.") String sexo) {
        Sexo = sexo;
    }

    public @NotBlank(message = "Idade é obrigatória.") String getIdade() {
        return idade;
    }

    public void setIdade(@NotBlank(message = "Idade é obrigatória.") String idade) {
        this.idade = idade;
    }

    public @NotBlank(message = "Posição é obrigatória.") String getPosicao() {
        return posicao;
    }

    public void setPosicao(@NotBlank(message = "Posição é obrigatória.") String posicao) {
        this.posicao = posicao;
    }

    public @NotNull(message = "Altura é obrigatória.") Double getAltura() {
        return altura;
    }

    public void setAltura(@NotNull(message = "Altura é obrigatória.") Double altura) {
        this.altura = altura;
    }

    public @NotNull(message = "Peso é obrigatório.") Double getPeso() {
        return peso;
    }

    public void setPeso(@NotNull(message = "Peso é obrigatório.") Double peso) {
        this.peso = peso;
    }

    public @NotBlank(message = "Numero da Camisa é obrigatório.") String getNumero() {
        return numero;
    }

    public void setNumero(@NotBlank(message = "Numero da Camisa é obrigatório.") String numero) {
        this.numero = numero;
    }
}