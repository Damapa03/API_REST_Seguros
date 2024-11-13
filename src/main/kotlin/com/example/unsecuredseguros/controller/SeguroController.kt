package com.example.unsecuredseguros.controller

import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.service.SeguroService
import org.springframework.beans.factory.annotation.Autowired
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
        @PathVariable("id") id: Int
    ): Seguro? {
        return seguroService.getByID(id)
    }
    @PostMapping
    fun post(seguro : Seguro){
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