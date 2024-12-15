package com.backend

/*

En grails a diferencia de springboot las URLS se definen en esta clase

En este caso, el controlador es "ApplicationController", la acción es "index", y la URL es "/"

Por lo que los metodos que creamos en el service, debemos definir su url para poder probar estos
metodos posteriormente en postman o en la vista que creemos posteriormente.

*/
// todo: implementar los path de alumno
class UrlMappings {
    static mappings = {

        // http://localhost:8080/alumno
        group "/alumno", {
            "/findAll"(controller: "alumno", action: "findAll", method: "GET")
            // GET /alumno/findAll - Lista todos los alumnos

            "/$id"(controller: "alumno", action: "findById", method: "GET")
            // GET /alumno/1 - Obtiene un alumno por ID

            "/create"(controller: "alumno", action: "createAlumno", method: "POST")
            // POST /alumno/create - Crea un nuevo alumno

            "/update/$id"(controller: "alumno", action: "updateAlumno", method: "PUT")
            // PUT /alumno/update/1 - Actualiza un alumno existente

            "/delete/$id"(controller: "alumno", action: "deleteAlumnoById", method: "DELETE")
            // DELETE /alumno/delete/1 - Elimina un alumno por ID
        }

        // Rutas dinámicas
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        // Rutas de vistas predeterminadas
        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
