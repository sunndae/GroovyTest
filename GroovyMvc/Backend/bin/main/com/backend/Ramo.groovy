package com.backend

class Ramo {

    String name
    Integer aprobationGrade

    // belongsTo en el GORM es para definir que profesor
    // es el dueño de la relación con Course
    // esto sirve para cuando despues en el service quiera
    // asignar un Profesor a un Course
    static belongsTo = [profesor: Profesor]
    
    static constraints = {
        name nullable: false
        aprobationGrade nullable: false        
    
    }

    static mapping = {
        table:"Ramo"
        version:false

    }
    
}