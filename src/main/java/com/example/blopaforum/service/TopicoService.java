package com.example.blopaforum.service;

import com.example.blopaforum.domain.topico.DadosAtualizacaoTopico;
import com.example.blopaforum.domain.topico.DadosCriarTopico;
import com.example.blopaforum.domain.topico.DadosDetalheTopico;
import com.example.blopaforum.domain.topico.Topico;
import com.example.blopaforum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public DadosDetalheTopico criar(DadosCriarTopico dados) {

        var topico = new Topico(dados);
        repository.save(topico);

        return new DadosDetalheTopico(topico);


    }

    public Page<DadosDetalheTopico> listarTopicos(Pageable paginacao) {

        return repository.findAll(paginacao)
                .map(DadosDetalheTopico::new);

    }

    public DadosDetalheTopico detalharTopico(Long id) {

        Topico topico = repository.getReferenceById(id);
        return new DadosDetalheTopico(topico);

    }

    public DadosDetalheTopico atualizarTopico(DadosAtualizacaoTopico dados) {

        Topico topico = repository.getReferenceById(dados.id());
        topico.atualizarTopico(dados);
        repository.save(topico);

        return new DadosDetalheTopico(topico);

    }

    public void excluirTopico(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID inválido");
        }
        repository.deleteById(id);
    }
}