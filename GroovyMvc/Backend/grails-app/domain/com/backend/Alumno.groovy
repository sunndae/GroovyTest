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
class Alumno {

    Integer id;
    String name;
    String lastName;
    String degree;
    Integer age;
    boolean graduate;

    /* son los nombres de las columnas
       que van mapeados a la base de datos
       y con las reglas definidas       */
    static constraints = {
        name nullable: false, blank: false
        lastName nullable: false, blank: false
        degree nullable: false
        age nullablle: false, min: 18
        graduate nullable: true
    }

    static mapping = {
        tablle: "Alumno"
    }
}