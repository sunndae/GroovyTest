package com.backend

/*
    El controller sera el que maneje
    las peticiones HTTP y las respuestas.

*/

// como crear un controller por consola: grails create-controller com.paquete.nombreController
class AlumnoController {

    // Inyección del servicio
    AlumnoService alumnoService

    // Página principal (Index)
    def index() {
        render(view: "MantenedorAlumno") // Renderiza la vista "MantenedorAlumno.gsp"
    }



    // Mostrar todos los alumnos
    def findAll() {
        try {
            def listaAlumnos = alumnoService.findAll()
            render(view: "MantenedorAlumno", model: [alumnos: listaAlumnos]) // -> renderiza la vista list.gsp y pasa todos los alumnos para mostrar sus atributos
        } catch (Exception e) {
            flash.message = "Error al obtener la lista de alumnos: ${e.message}" // ->  envia mensajes temporales entre el controller y la vista
            redirect(action: "index")
        }
    }

    // Mostrar un alumno específico
    def findById(Integer id) {
        try {
            def alumno = alumnoService.findById(id)
            render(view: "MantenedorAlumno", model: [alumno: alumno]) // -> renderiza una vista show.gsp y pasa un solo objeto a la vista y esta muestra los atributos del alumno
        } catch (Exception e) {
            flash.message = "El alumno no existe: ${e.message}"
            redirect(action: "findAll") // -> redirecciona al metodo findAll declarado en el service
        }
    }

    // crear un alumno
    def createAlumno() {
        println "Parámetros recibidos: ${params}"
        try {
            alumnoService.createAlumno(params)
            flash.message = "Alumno creado exitosamente"
            redirect(action: "findAll")
        } catch (Exception e) {
            flash.message = "Error al crear el alumno: ${e.message}"
            render(view: "MantenedorAlumno")
        }
    }

    // Formulario para actualizar un alumno
    def editForm(Integer id) {
        try {
            def alumno = alumnoService.findById(id)
            render(view: "EditarAlumno", model: [alumno: alumno])
        } catch (Exception e) {
            flash.message = "El alumno no existe: ${e.message}"
            redirect(action: "findAll")
        }
    }

    // Actualizar un alumno
    def updateAlumno(Integer id) {
        try {
            alumnoService.updateAlumno(id, params)
            flash.message = "Alumno actualizado correctamente"
            redirect(action: "findAll")
        } catch (Exception e) {
            flash.message = "Error al actualizar el alumno: ${e.message}"
            redirect(action: "editForm", params: [id: id])
        }
    }

    // Eliminar un alumno
    def deleteAlumnoById(Integer id) {
        try {
            alumnoService.deleteAlumnoById(id)
            flash.message = "Alumno eliminado correctamente"
            redirect(action: "findAll")
        } catch (Exception e) {
            flash.message = "Error al eliminar el alumno: ${e.message}"
            redirect(action: "findAll")
        }
    }

    def comboboxForm() {
        def degrees = alumnoService.getDegree()
        render(view: "MantenedorAlumno", model: [degrees: degrees])
    }




}