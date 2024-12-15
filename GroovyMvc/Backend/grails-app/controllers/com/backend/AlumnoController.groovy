package com.backend

import grails.web.Controller


/*
    El controller sera el que maneje
    las peticiones HTTP y las respuestas.

*/

// como crear un controller por consola: grails create-controller com.paquete.nombreController
@Controller
class AlumnoController {
    // Definimos una dependencia a un servicio
    AlumnoService alumnoservice

    def index() {
        render "esto es un controller para Alumno"
    }


    def findAll(){
        render status: 200, json: alumnoservice.findAll()
    }


    def findById(Integer id){
        try {
            render status: 200, json: alumnoservice.findById(id)
        } catch (Exception e){
            render status: 500, text: "Ha ocurrido un error, intente nuevamente. Error: $e"
        }
    }

    def createAlumno(Map params){
        try{
            alumnoservice.save(Alumno)
            render status: 201, text: "Alumno creado exitosamente"
        } catch(Exception e){
            render status: 500, text: "Un error ha ocurrido, Error: $e"
        }

    }

    def deleteAlumnoById(Integer id){
        try {
            alumnoservice.findById(id)
            render status: 200, text: "Alumno eliminado correctamente"
        } catch (Exception e){
            render status: 500, text: "Ha ocurrido un error, intente nuevamente"
        }
    }

    def updateAlumno(Integer id){
        //todo: terminar el update del controller
    }
}
