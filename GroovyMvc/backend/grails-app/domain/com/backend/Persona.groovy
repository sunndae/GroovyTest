package com.backend



/* En groovy on grails, tenemos los DOMAIN, mas conocidos como los modelos en el MVC
   Esta clase es la define la estructura de de los datos con los que va a trabajar nuestra
   aplicación.

   Una clase en groovy on grails debe tener:

   1. Propiedades: los datos que se deben mantener
   2. Constraints: Son las restricciones para validar los datos antes de ser almacenados en la BDD
   3. Relaciones: Las tipicas relaciones en base de datos
*/

/* Como crear una clase desde el CMD: grails create-domain-class com.backend.NombreClase */
class Persona {

    Integer id
    String nombre
    String apellido
    String carrera
    Integer edad
    boolean titulado

    static constraints = {
        nombre nullable: false, blank: false
        apellido nullable: false, blank: false
        carrera nullable: true
        edad nullable: false, min: 18
        titulado nullable: false
    }

    static mapping = {
        table 'persona' // Esto asegura que la tabla se llame 'persona' en la base de datos
    }
}