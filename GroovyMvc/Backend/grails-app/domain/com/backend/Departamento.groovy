package com.backend

class Departamento {

    String name
    Integer phoneNumber

    
    static constraints = {
        name nullable: false
        phoneNumber nullable: false
    }

    static mapping = {
        table: 'departamento'
        version: false
    }
}