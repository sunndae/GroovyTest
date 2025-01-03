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

    def calcularPromedio(Integer idAlumno){

        String query = """
            SELECT
            ROUND(SUM(
                n.valor_nota * n.ponderacion))
            FROM notas as n
            WHERE n.id_alumno_ramo = :idAlumno       
        """ 

        def promedio = AlumnoRamo.executeQuery(query, [idAlumno: idAlumno])

        return promedio ?: 0.0

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
