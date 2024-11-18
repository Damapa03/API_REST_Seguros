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
    fun getSeguros(): List<AsistenciaMedica> {
    }
    @GetMapping("/{id}")
    fun getById(
        @PathVariable("id") id: String
    ): AsistenciaMedica {
    }
    @PostMapping
    fun post(@RequestBody asistenciaMedica : AsistenciaMedica){
    }

    @PutMapping("/{id}")
    fun putById(
        @PathVariable("id") id: Int,
        @RequestBody asistenciaMedica: AsistenciaMedica
    ){
    }

    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable("id") id: Int
    ){
    }
}