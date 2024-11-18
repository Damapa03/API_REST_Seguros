package com.example.unsecuredseguros.model

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@Entity
@Table(name="asistencias_medicas")
data class AsistenciaMedica(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idAsistenciaMedica: Int,
    @ManyToOne(cascade = [(CascadeType.MERGE)])
    @Column(name = "id_seguro", nullable = false)
    val seguro: Seguro, // Relación con Seguro
    @Column(name="breve_descripcion",nullable = false)
    val breveDescripcion: String,
    @Column(nullable = false)
    val lugar: String,
    @Column(nullable = false)
    val explicacion: String,
    @Column(nullable = false, length = 100)
    val tipoAsistencia: String,
    @Column(nullable = false)
    val fecha: LocalDate,
    @Column(nullable = false)
    val hora: LocalTime,
    @Column(nullable = false)
    val importe: Double
) {
}