package com.example.unsecuredseguros.model

import jakarta.persistence.*
import org.hibernate.annotations.Check
import java.util.Date

@Entity
@Table(name="seguros")
data class Seguro(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idSeguro: Int,
    @Column(nullable = false, length = 10)
    val nif: String,
    @Column(nullable = false, length = 100)
    val nombre: String,
    @Column(nullable = false, length = 100)
    val ape1: String,
    @Column(length = 100)
    val ape2: String?,
    @Column(name = "edad",nullable = false)
    @Check(constraints = "edad > 0")
    val edad: Int,
    @Column(name = "num_hijos",nullable = false)
    @Check(constraints = "num_hijos > 0")
    val numHijos: Int,
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    val fechaCreacion: Date,
    @Column(nullable = false, length = 10)
    val sexo: String,
    @Column(nullable = false)
    val casado: Boolean,
    @Column(nullable = false)
    val embarazada: Boolean
) {

}