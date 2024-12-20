package com.backend

import grails.gorm.transactions.Transactional

@Transactional
class AlumnoService {

    def findById(Integer id){
        Alumno alumno = Alumno.get(id)
        if(!alumno){
            throw new RuntimeException("Alumno no encontrado")
        }
        return alumno
    }

    /*
    Al usar el clase.list() el ORM de grails va a
    traerme todos los objetos de tipo alumno que tengo
    en la base de datos en una lista.

    esto es lo mimsmo que si hiciera en java un

    List<Alumno> alumnos = Alumno.findAll()

    */
    def findAll() {
        try {
            def alumnos = Alumno.list()
            println "alumnos en la bdd $alumnos"
            return alumnos
        } catch (Exception e) {
            throw new RuntimeException("Error al recuperar la lista de alumnos: ${e.message}")
        }
    }

    /*  Map params: sirve para representar los datos
        que van a ser asignados a un modelo enviados
        como JSON.
        {
          "name": "Juan",
          "age": 20,
          "graduate": true
        }
                                                  */
    def createAlumno(Map params) {
        Alumno alumno = new Alumno(params)
        if (!alumno.save(flush: true)) {
            throw new RuntimeException("Error al crear el alumno: ${alumno.errors}")
        }
        return alumno
    }

    def deleteAlumnoById(Integer id){
        Alumno alumno = findById(id)
        if(!alumno){
            throw new RuntimeException("Alumno no encontrado")  // -> si el alumno no existe, lanza una excepción
        }
        return alumno.delete(flush : true)
    }


    @Transactional
    def updateAlumno(Integer id, Map params){
        Alumno alumno = findById(id)
        if(!alumno){
            throw new RuntimeException("Alumno no encontrado")
        }
        try{
            alumno.properties = params
            //alumno.properties = params.findAll { key, value -> alumno.hasProperty(key) && value }

            println "parametros recibidos del controller: ${alumno.properties}"
            
            
            // Validar los datos recibidos antes de guardar
            if (!alumno.validate()) {
                println "Errores de validación: ${alumno.errors.allErrors}"
                throw new RuntimeException("Errores de validación: ${alumno.errors.allErrors}")
            }

            
            alumno.markDirty() // Marca el objeto como modificado
            if(!alumno.save(flush: true)){
            println "Errores de validación: ${alumno.errors.allErrors}"
                throw new RuntimeException("Error al actualizar los datos del alumno: ${alumno.errors}")
            }

            println "los datos se actualizaron: ${alumno.properties}"
            return alumno

        } catch (Exception e) {
            println("error en el service")
            throw new RuntimeException("Ha ocurrido un error al actualizar los datos: $e.message")
        }
    }

    def getDegree() {
        def degrees = Alumno.get(degree)
        return degrees

    }





}

