package com.example.unsecuredseguros.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "usuarios")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column(unique = true)
    var username:String,
    var password:String,
    @Enumerated(EnumType.STRING)
    var roles:Rol? = Rol.USER
) {
}
enum class Rol{
    ADMIN,
    USER
}