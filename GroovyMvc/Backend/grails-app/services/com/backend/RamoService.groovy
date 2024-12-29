package com.backend

import grails.gorm.transactions.Transactional

@Transactional
class RamoService {

    def findById(Integer id){
        Ramo ramo = Ramo.get(id)
        if(!ramo){
            throw new RuntimeException("No existe el ramo")
        }
        return ramo
    }

    def findAll(){
        try{
            def ramos = Ramo.list()
            return ramos    
        }catch(Exception e){
            throw new Exception("no existen regitros en la base de datos")
        }        
    }


    def createRamo(Map params){
        Ramo ramo = new Ramo(params)
        if(!ramo.save(flush: true)){
            throw new Exception("Ha ocurrido un error al crear el ramo, intenta de nuevo")
        }
        return ramo
    }

    def deleteRamoById(Integer id){
        Ramo ramo = findById(id)
        if(!ramo){
            throw new RuntimeException("Ramo no encontrado")
        }
        return ramo.delete(flush: true)
    }

    def updateRamo(Integer id, Map params){
        Ramo ramo = findById(id)
        if(!ramo){
            throw new RuntimeException("Alumno no encontrado")
        }
        try{
            ramo.properties = params

            if(!ramo.save(flush: true)){
                throw new RuntimeException("Error al actualizar los datos del alumno: ${alumno.errors}")
            }

            return ramo

        } catch (Exception e) {
            throw new RuntimeException("Ha ocurrido un error al actualizar los datos: $e.message")
        }
    }
}