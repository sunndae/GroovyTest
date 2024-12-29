package com.backend

class Departamento {

    String name
    Integer phoneNumber

    static hasOne  =  [director : Profesor] // Un departamento tiene un unico director 1:1
    static hasMany =  [ramo: Ramo, alumno: Alumno, profesor: Profesor]   //  Un departamento imparte muchos ramos y tiene muchos alumnos
 
    static constraints = {
        name nullable: false
        phoneNumber nullable: false
    }

    static mapping = {
        table: 'departamento'
        version: false
        id column: 'id'
    }
}