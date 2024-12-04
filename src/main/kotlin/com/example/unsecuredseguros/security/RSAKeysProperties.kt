package com.example.unsecuredseguros.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import java.security.PrivateKey
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey


@EnableConfigurationProperties
data class RSAKeysProperties(
    var publicKey : RSAPublicKey,
    var privateKey: RSAPrivateKey
)


