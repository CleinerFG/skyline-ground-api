package com.skylineground.core.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.skylineground.modules.identity.user.SystemRole;
import com.skylineground.modules.identity.user.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Component
public class TokenService {

    @Value("${app.security.jwt.secret}")
    private String secret;

    @Value("${app.security.jwt.issuer}")
    private String issuer;

    @Value("${app.security.jwt.expiration-seconds:3600}")
    private long expirationSeconds;

    private Algorithm algorithm;
    private JWTVerifier verifier;

    @PostConstruct // Ensure that the secret and the issuer are not null, because their values not yet initialized.
    public void init() {

        Objects.requireNonNull(secret, "JWT Secret must not be null");
        Objects.requireNonNull(issuer, "JWT Issuer must not be null");

        this.algorithm = Algorithm.HMAC256(secret);
        this.verifier = JWT.require(algorithm)
                .withIssuer(issuer)
                .acceptLeeway(5) // Tolerance in seconds for clock drift between servers.
                .build();
    }

    public String generate(User user) {
        Instant now = Instant.now();
        return JWT.create()
                .withIssuer(issuer)
                .withSubject(user.getExternalId().toString())
                .withClaim("systemRole", user.getSystemRole().name())
                .withIssuedAt(now)
                .withExpiresAt(now.plusSeconds(expirationSeconds))
                .sign(algorithm);
    }

    public Optional<TokenPayload> validate(String token) {
        if (token == null || token.isBlank()) return Optional.empty();

        try {
            DecodedJWT jwt = verifier.verify(token);

            var externalId = UUID.fromString(jwt.getSubject());
            var systemRole = SystemRole.valueOf(jwt.getClaim("systemRole").asString());

            return Optional.of(TokenPayload.builder()
                    .externalId(externalId)
                    .systemRole(systemRole)
                    .build());

        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }
    }
}