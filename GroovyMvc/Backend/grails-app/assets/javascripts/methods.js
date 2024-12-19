function deleteAlumno(id){
    if(confirm("¿Estás seguro de eliminar este alumno?")){
        window.location.href = 'persona/delete' + id;
    }
}