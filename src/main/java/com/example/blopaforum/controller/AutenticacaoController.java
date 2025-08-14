package com.example.blopaforum.controller;

import com.example.blopaforum.domain.usuario.DadosUsuarioAutenticacao;
import com.example.blopaforum.domain.usuario.Usuario;
import com.example.blopaforum.infra.security.DadosTokenJWT;
import com.example.blopaforum.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity logar(@RequestBody @Valid DadosUsuarioAutenticacao dados) {

        var tokenAutenticacao = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autenticacao = manager.authenticate(tokenAutenticacao);
        var tokenJWT = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

    }

}
