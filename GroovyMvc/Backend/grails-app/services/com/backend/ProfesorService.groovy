package com.backend

import grails.gorm.transactions.Transactional

@Transactional
class ProfesorService {

   def finById(Integer id){
        Profesor profesor = Profesor.get(id)
        return profesor
   }

   def findAll(){
     try{
        def profesor = Profesor.list()
        return profesor
     }catch(Exception e){
        throw new Exception ("Ha ocurrido un error al traer los registros de la base de datos" + e)
     }
   } 

    def createProfesor(Map params){
        Profesor nuevoProfesor = new Profesor(params)
        try {
            nuevoProfesor.save(flush: true)
            return nuevoProfesor
        }catch(Exception e){
            throw new Exception ("Ha ocurrido un error al crear al profesor" + e)
        }
    }

    def deleteProfesorById(Integer id){
        Profesor profesor = Profesor.findById(id)
        try{
            if(!profesor){
                throw new Exception ("No hay registro de este profesor en la base de datos") 
            }else{
                return profesor.delete(flush: true)
            }
        }catch(Exception e){
            throw new Exception("Ha ocurrido un error al intentar eliminar al profesor" + e)
        }
    }


    def updateProfesor(Integer id, Map params){
        Profesor profesor = findById(id)
        if(!profesor){
            throw new RuntimeException("Alumno no encontrado")
        }
        try{
            profesor.properties = params

            if(!profesor.save(flush: true)){
                throw new RuntimeException("Error al actualizar los datos del alumno: ${alumno.errors}")
            }

            return profesor

        } catch (Exception e) {
            throw new RuntimeException("Ha ocurrido un error al actualizar los datos: $e.message")
        }
    }
}