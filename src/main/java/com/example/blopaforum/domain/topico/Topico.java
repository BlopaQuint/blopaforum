package com.example.blopaforum.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String titulo;

    private String mensagem;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_do_topico")
    private EstadoDoTopico estadoDoTopico;

    private String autor;

    private String curso;

    public Topico(DadosCriarTopico dados) {

        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.dataDeCriacao = LocalDateTime.now();
        this.estadoDoTopico = EstadoDoTopico.NAO_RESPONDIDO;

    }

    public void atualizarTopico(@Valid DadosAtualizacaoTopico dados) {

        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }

    }


}