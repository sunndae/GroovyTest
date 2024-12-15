package com.backend

import grails.gorm.transactions.Transactional

@Transactional
class AlumnoService {

    def findById(Integer id){
        Alumno alumno = Alumno.get(id)
        return alumno
    }

    /*
    Al usar el clase.list() el ORM de grails va a
    traerme todos los objetos de tipo alumno que tengo
    en la base de datos en una lista.

    esto es lo mimsmo que si hiciera en java un

    List<Alumno> alumnos = Alumno.findAll()

    */
    def findAll(){
        return Alumno.list()
    }

    /*  Map params: sirve para representar los datos
        que van a ser asignados a un modelo enviados
        como JSON.
        {
          "name": "Juan",
          "age": 20,
          "graduate": true
        }                                          */
    def CreateAlumno(Map params){
        Alumno alumno = new Alumno(params) // -> crea un nuevo objeto con los valores mapeados
        return alumno.save(flush: true) // -> el flush sirve para que la operación se vea en la base de datos
    }



    def deleteAlumnoById(Integer id){
        Alumno alumno = findById(id)
        if(!alumno){
            throw new RuntimeException("Alumno no encontrado")  // -> si el alumno no existe, lanza una excepción
        }
        return alumno.delete(flush : true)
    }


    def updateAlumno(Integer id){
        Alumno alumno = findById(id)

        try {
            alumno.setName(alumno.getName())
            alumno.setLastName(alumno.getLastName())
            alumno.setDepartment(alumno.getDepartment())
            alumno.setDegree(alumno.getDegree())
            alumno.setAge(alumno.getAge())
            alumno.setGraduate(alumno.getGraduate())

            return alumno.save(flush: true)
        } catch (Exception e){
            throw new RuntimeException("El reigstro no existe con el id $id $e")
        }
    }

}

