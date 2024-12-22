


document.addEventListener('DOMContentLoaded', () => {
    document.querySelectorAll('.delete-btn').forEach(button => {
        button.addEventListener('click', function(event) {
            event.preventDefault(); // Prevenir la acción por defecto
            const alumnoId = this.getAttribute('data-id'); // Obtener el ID desde el atributo data-id
            
            if (confirm('¿Estás seguro de que deseas eliminar este alumno?')) {

                // hacemos una peticion DELETE al endpoint 
                // para eliminar al alumno
                fetch('/alumno/delete/' + alumnoId, {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Error al eliminar el alumno del sistema');
                    }
                    return response.text();
                })
                .then(data => {
                    alert('Alumno eliminado correctamente');

                    // se hace un reload de la pagina
                    window.location.reload(); 
                })
                // manejo de errores
                .catch(error => console.error('Error:', error));
            }
        });
    });
});
