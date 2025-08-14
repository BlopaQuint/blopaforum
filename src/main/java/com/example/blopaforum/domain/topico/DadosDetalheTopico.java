package com.example.blopaforum.domain.topico;

import java.time.LocalDateTime;

public record DadosDetalheTopico(Long id, String titulo, String mensagem, LocalDateTime dataDeCriacao, EstadoDoTopico estadoDoTopico, String autor, String curso) {

    public DadosDetalheTopico(Topico topico) {

        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataDeCriacao(), topico.getEstadoDoTopico(), topico.getAutor(), topico.getCurso());
    }
}