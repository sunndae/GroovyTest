package com.backend


//TODO: finish this class 
class Profesor {
    
    String name
    String lastname
    String academicDegree
    Boolean headsDepartment

    // esto es como se aplica las relaciones definidas en el MER
    // [InstaciaDeClase: Clase]
    static hasMany = [ramos: Ramo]                  // => si imparte clases de un ramo
    static hasOne = [departamento: Departamento]    // => si trabaja como profesor en el departamento
    static hasOne = [headsDepartment: Departamento] // => si es director de departamento


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
