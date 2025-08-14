package com.example.blopaforum.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.blopaforum.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private static final String ISSUER = "API BlopaForum";

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }

    public String gerarToken(Usuario usuario) {

        try{
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create().withIssuer(ISSUER)
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("Erro ao gerar token jwt", ex);
        }

    }

    public String getSubject(String tokenJWT) {

        try {
            var algoritimo = Algorithm.HMAC256(secret);
            return JWT.require(algoritimo).withIssuer(ISSUER)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTCreationException ex) {
            throw new RuntimeException("O Token JWT está inválido ou expirado.");
        }

    }

}
