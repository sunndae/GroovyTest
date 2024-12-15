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
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

    }
}
