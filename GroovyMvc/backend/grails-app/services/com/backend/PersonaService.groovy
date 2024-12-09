package com.backend

import groovy.transform.CompileStatic

/* En groovy on grails, tenemos los Services, esta clase en donde se encapsula la logica de negocio
   de la aplicación que estamos desarrollando. Esta capa es esencial para poder realizar operaciones
   que necessitate de una logica compleja o tareas muy repetitivas que no van en la logica de presentación
   (Front-end) o a la persistent de datos en la BDD

    Cosas comunes en el service

    1. Transacciones: Asegurarse de que las operaciones de base de datos sean atómicas
       y se manejen correctamente las excepciones.

    2. Operaciones de negocio: Procesos que requieren varios pasos y manipulaciones de
       datos antes de llegar a una conclusión o resultado.


    3. Interacción entre varios dominios: Coordinar tareas que involucran múltiples objetos de dominio.

*/



/*Como crear un service desde el CMD: grails create-service com.backend.NombreDelService*/
@CompileStatic
class PersonaService {

    def doSomething() {

    }
}