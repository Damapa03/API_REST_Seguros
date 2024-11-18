package com.example.unsecuredseguros.service

import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.repository.SeguroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class SeguroService {

    @Autowired
    private lateinit var seguroRepository: SeguroRepository

    fun getAll(): List<Seguro> {
        return seguroRepository.findAll()
    }
    fun getByID(id: String): Seguro? {
        var idl: Long = 0
        try {
            idl = id.toLong()
        }catch (e:Exception){
            return null
        }
        return seguroRepository.findByIdOrNull(idl)
    }

    fun delete(id: Int) {
        var idl: Long = 0
        try {
            idl = id.toLong()
        }catch (e:Exception){
        }
        return seguroRepository.deleteById(idl)
    }

    fun post(seguro: Seguro) {
//        if (checkIfNull(seguro.nombre)||checkIfNull(seguro.ape1)||checkIfNull(seguro.sexo)){
//            if (checkDNI(seguro.nif)){
//                if (checkAge(seguro.edad)){
//                    if (checkChilds(seguro.numHijos)){
//                        if (checkCasado(seguro.casado, seguro.numHijos)){
//                            if (checkEmbarazada(seguro.embarazada, seguro.sexo)){
//                                seguroRepository.save(seguro)
//                            }
//                        }
//                    }
//                }
//            }
//        }
        seguroRepository.save(seguro)

    }

    fun put(id: Int, seguro: Seguro) {
        val seguroBorrar = seguroRepository.findByIdOrNull(id.toLong())
        if (seguroBorrar != null) {
            seguroRepository.delete(seguroBorrar)
            seguroRepository.save(seguro)
        }
    }

    fun checkDNI(dni:String): Boolean{
        val regex = "^\\d{8}[A-Za-z]\$"
        val DNILetter = listOf("T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K")
        val nums = dni.substring(0,8)
        val letter = dni.substring(8).uppercase()
        val num = nums.toInt()/23

        if(regex.toRegex().matches(dni.trim())){
            if (DNILetter[num].equals(letter)) {
                return true
            }else return false
        }else return false
    }
    fun checkIfNull(item:String): Boolean {
        return !item.isNullOrBlank()
    }
    fun checkAge(age:Int): Boolean {
       /* if(age > 0 && age < 18){

        }else if (age)*/
        return true
    }
    fun checkChilds(childs:Int): Boolean {
        return true

    }
    fun checkCasado(casado: Boolean, hijos:Int): Boolean {
        return true

    }
    fun checkEmbarazada(embaraza:Boolean, sex: String): Boolean {
        if (embaraza){
            if (checkIfNull(sex) != null){
                if (sex.lowercase() != "mujer"){

                }
            }
        }
        return true

    }
}