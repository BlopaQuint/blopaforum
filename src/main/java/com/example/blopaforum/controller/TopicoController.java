package com.example.blopaforum.controller;

import com.example.blopaforum.domain.topico.DadosAtualizacaoTopico;
import com.example.blopaforum.domain.topico.DadosCriarTopico;
import com.example.blopaforum.domain.topico.DadosDetalheTopico;
import com.example.blopaforum.repository.TopicoRepository;
import com.example.blopaforum.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;
    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid DadosCriarTopico dados, UriComponentsBuilder uriBuilder) {

        var topicoDetalhado = topicoService.criar(dados);

        var uri = uriBuilder.path("topicos/{id}")
                .buildAndExpand(topicoDetalhado.id()).toUri();

        return ResponseEntity.created(uri).body(topicoDetalhado);


    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalheTopico>> listarTopicos(@PageableDefault(size = 10, sort = {"dataDeCriacao"}) Pageable paginacao) {

        var page = topicoService.listarTopicos(paginacao);
        return ResponseEntity.ok(page);

    }


    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id) {

        var topico = topicoService.detalharTopico(id);
        return ResponseEntity.ok(topico);

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTopico(@RequestBody @Valid DadosAtualizacaoTopico dados) {

        var topico = topicoService.atualizarTopico(dados);
        return ResponseEntity.ok(topico);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirTopico(@PathVariable Long id) {

        topicoService.excluirTopico(id);
        return ResponseEntity.noContent().build();

    }

}