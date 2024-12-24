package com.backend


//TODO: finish this class 
class Profesor {
    
    String name
    String lastname
    String academicDegree   
    Boolean headsDepartment

    // esto es como se aplica las relaciones definidas en el MER
    // [InstaciaDeClase: Clase]
    static hasMany = [courses: Course]


    // reglas para la base de datos
    static constraints = {
        name nullable : false
        lastname nullable: false
        academicDegree nullable: false
        headsDepartment nullable: false
    }

    static mapping = {
        table: "Profesor"
        version: false
    }
}
