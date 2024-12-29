package com.backend


//TODO: finish this class 
class Profesor {
    
    String name
    String lastname
    String academicDegree
    Boolean headsDepartment

    // esto es como se aplica las relaciones definidas en el MER
    // [InstaciaDeClase: Clase]
    static hasMany = [ramos: Ramo]                    // un profesor puede impartir varios ramos
    static belongsTo = [departamento: Departamento]  //  un profesor pertenece a un solo departamento
    static hasOne = [headsDepartment: Departamento] //   Un solo profesor puede ser director del departamento


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
        id column: "id"
    }
}
