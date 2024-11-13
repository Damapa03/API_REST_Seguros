package com.example.unsecuredseguros.service

import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.repository.SeguroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.Optional

@Service
class SeguroService {

    @Autowired
    private lateinit var seguroRepository: SeguroRepository

    fun getAll(): List<Seguro> {
        return seguroRepository.findAll()
    }
    fun getByID(id: Int): Seguro? {
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

    }

    fun put(id: Int, seguro: Seguro) {

    }

    fun checkDNI(dni:String){
        val DNILetter = listOf("T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K")
        val nums = dni.substring(0,8)
        val letter = dni.substring(8).uppercase()


        val num = nums.toInt()/23
        if(DNILetter[num].equals(letter)){

        }

    }
    fun checkName(name:String){
        if(name != null){

        }
    }
    fun checkLastName(lastName:String){
        if(lastName != null){}
    }
    fun checkAge(age:Int){
       /* if(age > 0 && age < 18){

        }else if (age)*/
    }
    fun checkSex(sex:String){

    }
    fun checkChilds(childs:String){

    }
    fun checkCasado(casado:String){

    }
    fun checkEmbarazada(embaraza:Boolean, sex: String){
        if (embaraza){
            if (checkSex(sex) != null){
                if (sex.lowercase() != "mujer"){

                }
            }
        }
    }
}