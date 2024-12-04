package com.example.unsecuredseguros.controller

import com.example.unsecuredseguros.exception.ValidationException
import com.example.unsecuredseguros.model.AsistenciaMedica
import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.service.AsistenciaMedicaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/asistencia_medica")
class AsistenciaMedicaController {

    @Autowired
    private lateinit var asistenciaMedicaService: AsistenciaMedicaService

    @GetMapping
    fun getAsistencias(): List<AsistenciaMedica> {
        return asistenciaMedicaService.getAll()
    }
    @GetMapping("/{id}")
    fun getById(
        @PathVariable("id") id: Int
    ): AsistenciaMedica? {
        return asistenciaMedicaService.getById(id)
    }
    @PostMapping
    fun post(@RequestBody asistenciaMedica : AsistenciaMedica): ResponseEntity<Any> {
        return asistenciaMedicaService.post(asistenciaMedica)
    }

    @PutMapping("/{id}")
    fun putById(
        @PathVariable("id") id: Int,
        @RequestBody asistenciaMedica: AsistenciaMedica
    ): ResponseEntity<AsistenciaMedica> {
        return asistenciaMedicaService.put(id,asistenciaMedica)
    }

    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable("id") id: Int
    ): ResponseEntity<Any> {
        return asistenciaMedicaService.delete(id)
    }
}