package com.example.blopaforum.domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosCriarTopico(
        @NotBlank(message = "O título é obrigatório.")
        String titulo,
        @NotBlank(message = "A mensagem é obrigatória.")
        String mensagem,

        LocalDateTime dataDeCriacao,

        EstadoDoTopico estadoDoTopico,
        @NotBlank(message = "O autor é obrigatório")
        String autor,
        @NotBlank(message = "O curso é obrigatório")
        String curso) {}
