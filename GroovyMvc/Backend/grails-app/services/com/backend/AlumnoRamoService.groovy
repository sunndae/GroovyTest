package com.backend

import grails.gorm.transactions.Transactional

@Transactional
class AlumnoRamoService {

    def findAll(){
        try{
            AlumnoRamo inscritos = AlumnoRamo.list()
            return inscritos
        }catch(e){
            throw new RuntimeException("Ha ocurrido un error al listar los alumnos inscritos" + e.message)
        }
    }


    // aqui hacemos una consulta SQL nativa
    // por que la tabla notas no existe en las clases de dominio
    def calcularPromedio(Integer idAlumno){
        try{
            String SQL_Query = """
                SELECT 
                    ROUND(SUM(
                n.valor_nota * n.ponderacion))
                FROM notas as n
                WHERE n.id_alumno_ramo = :idAlumno
             """

            // aqui obtenemos la instancia de ejecucion
            // de hibernate para la query que queremos ejecutar
            def session = AlumnoRamo.withSession { it }

            // asi se ejecuta una consulta SQL nativa
            // en grails cuando no esta la clase de dominio
            def query = session.createSQLQuery(SQL_Query)
            query.setParameter("idAlumno", idAlumno)

            // de esta manera se obtiene el resultado
            def promedio = query.uniqueResult()

            return promedio ?: 0.0
        }catch(Exception e){
            throw new RuntimeException ("Ha ocurrido un error al calcular el promedio del estudiante" + e)
        }
    }


    def listarAlumnosPorRamo(String nombreRamo){

        try{
            String query = """
                SELECT a.name, a.last_name, ar.semestre, r.name, ar.promediofinal, ar.estado_alumno
                FROM alumno AS a
                WHERE r.name = :nombreRamo
            
            """
            return AlumnoRamo.executeQuery(query,[nombreRamo: nombreRamo])
        }catch(Exception e){
            throw new RuntimeException("Ha ocurrido un error al quere listar este curso,
            Intente nuevamente" + e)
        }
    } 
}
