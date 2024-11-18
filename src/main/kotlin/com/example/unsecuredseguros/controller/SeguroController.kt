package com.example.unsecuredseguros.controller

import com.example.unsecuredseguros.exception.ValidationException
import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.service.SeguroService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/seguros")
class SeguroController {

    @Autowired
    private lateinit var seguroService: SeguroService

    @GetMapping
    fun getSeguros(): List<Seguro> {
        return seguroService.getAll()
    }
    @GetMapping("/{id}")
    fun getById(
        @PathVariable("id") id: String
    ): ResponseEntity<Seguro> {
        if (id.isBlank()){
            throw ValidationException("El id no puede estar vacío")
        }
        val s = seguroService.getByID(id)
        return ResponseEntity(s, HttpStatus.OK)
    }
    @PostMapping
    fun post(@RequestBody seguro : Seguro){
        return seguroService.post(seguro)
    }

    @PutMapping("/{id}")
    fun putById(
        @PathVariable("id") id: Int,
        @RequestBody seguro: Seguro
    ){
        return seguroService.put(id, seguro)
    }

    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable("id") id: Int
    ){
        return seguroService.delete(id)
    }
}