package com.backend

import grails.gorm.transactions.Transactional

@Transactional
class AlumnoRamoService {

    def findAll(){
        try{
            AlumnoRamo inscritos = AlumnoRamo.list()
            return inscritos
        }catch(e){
            throw new RuntimeException("Ha ocurrido un error al listar los alumnos inscritos" + e.message)
        }
    }

    
}
