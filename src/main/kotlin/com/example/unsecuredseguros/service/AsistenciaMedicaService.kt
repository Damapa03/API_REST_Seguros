package com.example.unsecuredseguros.service

import com.example.unsecuredseguros.model.AsistenciaMedica
import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.repository.AsistenciaMedicaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime

@Service
class AsistenciaMedicaService {

    @Autowired
    private lateinit var asistenciaMedicaRepository: AsistenciaMedicaRepository

    fun getAll(): List<AsistenciaMedica> {
        return asistenciaMedicaRepository.findAll()
    }

    fun getById(id: Int): AsistenciaMedica? {
        var idL: Long = 0
        try {
            idL = id.toLong()
        }catch (ex:Exception){

        }
        return asistenciaMedicaRepository.findByIdOrNull(idL)
    }

    fun post(asistenciaMedica: AsistenciaMedica): ResponseEntity<Any>{

        return ResponseEntity(asistenciaMedicaRepository.save(asistenciaMedica), HttpStatus.CREATED)
    }

    fun put(id: Int, asistenciaMedica: AsistenciaMedica): ResponseEntity<AsistenciaMedica> {
        return ResponseEntity(asistenciaMedicaRepository.save(asistenciaMedica), HttpStatus.OK)
    }

    fun delete(id: Int): ResponseEntity<Any> {
        var idL: Long = 0
        try {
            idL = id.toLong()
        }catch (ex:Exception){

        }
        return ResponseEntity(asistenciaMedicaRepository.deleteById(idL), HttpStatus.OK)
    }
    fun breveDescripcion(descripcion: String): ResponseEntity<Any> {
        if (descripcion.isNullOrEmpty()) {
            return ResponseEntity("El campo breveDescripcion no puede estar vacío.", HttpStatus.BAD_REQUEST)
        }else {
            return ResponseEntity(null, HttpStatus.OK)
        }


    }

    fun lugar(lugar: String): ResponseEntity<Any> {
        if (lugar.isNullOrEmpty()) {
            return ResponseEntity("El campo lugar no puede estar vacío.", HttpStatus.BAD_REQUEST)
        }else {
            return ResponseEntity(null, HttpStatus.OK)
        }
    }

    fun explicacion(explicacion: String): ResponseEntity<Any> {
        if (explicacion.isNullOrEmpty()) {
            return ResponseEntity("El campo explicacion no puede estar vacío.", HttpStatus.BAD_REQUEST)
        }else {
            return ResponseEntity(null, HttpStatus.OK)
        }
    }

    fun tipoAsistencia(tipo: String): ResponseEntity<Any> {
        if (tipo.isNullOrBlank()) {
            return ResponseEntity("El campo tipoAsistencia no puede ser nulo.", HttpStatus.BAD_REQUEST)
        }else {
            return ResponseEntity(null, HttpStatus.OK)
        }
    }

    fun fechaHora(fecha: LocalDate, hora: LocalTime): ResponseEntity<Any> {
        if (fecha == null && hora == null) {
            return ResponseEntity("El campo {fecha/hora} no puede ser nulo.", HttpStatus.BAD_REQUEST)
        }else {
            return ResponseEntity(null, HttpStatus.OK)
        }
    }

    fun importe(importe: Double): ResponseEntity<Any> {
        if (importe < 0) {
            return ResponseEntity("El campo importe debe ser mayor que 0.", HttpStatus.BAD_REQUEST)
        }else {
            return ResponseEntity(null, HttpStatus.OK)
        }
    }
}