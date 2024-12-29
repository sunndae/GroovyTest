package com.backend

class Ramo {

    String name
    Integer aprobationGrade

    static belongsTo = [profesor: Profesor, departamento: Departamento]
    static hasMany   = [alumnos : AlumnoRamo]
    
    static constraints = {
        name nullable: false
        aprobationGrade nullable: false        
    
    }

    static mapping = {
        table:"Ramo"
        version:false
        id column : 'id'

    }
    
}