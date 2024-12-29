package com.backend

import groovy.transform.CompileStatic

import grails.gorm.transactions.Transactional

//@CompileStatic
@Transactional
class DepartamentoService {

    def findByid(Integer id){
        Departamento departamento = Departamento.get(id)
        if(!Departamento){
            throw new RuntimeException("Departamento no encontrado")
        }
        else{
            return departamento
        }
    }


    def findAll(){
        try{
            Departamento departamento = Departamento.list()
            return departamento
        }catch(Exception e){
            throw new RuntimeException("Error al obtener los departamentos de la base de datos" + e)
        }
    }

    def createDepartamento(Map params){
        Departamento nuevoDepartamento = new Departamento(params)
        try{
            nuevoDepartamento.save(flush: true)
            return nuevoDepartamento
        }catch(Exception e){
            throw new RuntimeException("Ha ocurrido un error al crear un departamento" + e)
        }
    }
    
    def deleteDepartamentoById(Integer id){
        Departamento departamento = Departamento.get(id)
        if(!Departamento){
            throw new RuntimeException("El departamento no existe en la base de datos")
        } else{
            return departamento.delete(flush:true)}
    }

    //@Transactional
    def updateDepartamento(Integer id, Map params){
        Departamento departamentoActualizar = Departamento.get(id)
        if(!departamentoActualizar){
            throw new RuntimeException("El departamento no existe en la base de datos")
        }
        try{
            departamentoActualizar.properties = params

            if(!departamentoActualizar.save(flush:true)){
                throw new RuntimeException("Ha ocurrido un error al actualizar el departamento")
            }
            return departamentoActualizar
        }catch(Exception e){
            throw new RuntimeException("Ha ocurrido un error al actualizar el departamento" + e)
        }
    }


    def asignarDirector(Integer id){

        Profesor candidato = Profesor.findByid(id)

        if(candidato.get(academicDegree).contains("PhD")){
           candidato.set(headsDepartment) = true
           return candidato
        }else{
            throw new RuntimeException("El candidato a director no tiene el grado de PhD")
        }
    }

}