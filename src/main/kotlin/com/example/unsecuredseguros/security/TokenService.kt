package com.example.unsecuredseguros.security

import com.nimbusds.jwt.JWTClaimsSet
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

@Service
class TokenService {

    private lateinit var jwtEncoder: JwtEncoder
    fun generarToken(authentication: Authentication): String{

        val roles: String = authentication
            .authorities
            .map { it.authority}
            .joinToString(separator = " ")

        val payload: JWTClaimsSet = JWTClaimsSet.Builder()
            .issuer("self")
            .issueTime(Date())
            .expirationTime(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
            .subject(authentication.name)
            .claim("roles", roles)
            .build()
        if (payload == null) throw RuntimeException("Error al generar el token")
        return jwtEncoder.encode(JwtEncoderParameters.from(payload)).getTokenValue()
    }
}