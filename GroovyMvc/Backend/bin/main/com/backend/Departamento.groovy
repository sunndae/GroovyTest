package com.backend

class Departamento {

    String name
    Integer phoneNumber

    static hasMany = [profesor: Profesor]  // trabaja en el departamento
    static hasOne =  [director : Profesor] // Director de departamento

    static constraints = {
        name nullable: false
        phoneNumber nullable: false
    }

    static mapping = {
        table: 'departamento'
        version: false
    }
}