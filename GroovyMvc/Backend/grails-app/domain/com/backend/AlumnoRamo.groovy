package com.backend

class AlumnoRamo {

    /*
     al usar atributos de tipo Alumo y Ramo
     el ORM va a entender la relacion entre las tablas
     y  va generar de mejor manera las llaves foraneas

    Alumno alumno => relacion entre alumno_ramo y alumno y asi maneja id_alumno mas facil
    Ramo ramo     => relacion entre alumno_ramo y Ramo y asi maneja id_ramo
    */
    Alumno alumno  
    Ramo ramo 

    Float promedioFinal
    String semestre
    String estadoAlumno

    static belongsTo = [ramo: Ramo, alumno: Alumno]


    static constraints = {

        promedioFinal nullable:false
        semestre nullable: false
        estadoAlumno nullable: false
    }

    static mapping = {
        table "alumno_ramo"
        version: false
        id column : 'id'
    }

}
