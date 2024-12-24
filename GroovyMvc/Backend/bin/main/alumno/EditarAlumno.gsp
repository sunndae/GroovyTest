<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Editar Alumno</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>



<div class = "container">
    <g:form controller="alumno" action="updateAlumno" method="PUT" class = 'parametros'>
        <g:hiddenField name="_method" value="PUT" />

        <label for="name">Nombre:</label>
        <g:textField name="name" value="${alumno.name}" class="form-control" />

        <label for="lastName">Apellido:</label>
        <g:textField name="lastName" value="${alumno.lastName}" class="form-control" />

        <label for="degree">Carrera:</label>
        <g:textField name="degree" value="${alumno.degree}" class="form-control" />

        <label for="department">Departamento:</label>
        <g:textField name="department" value="${alumno.department}" class="form-control" />

        <label for="age">Edad:</label>
        <g:textField name="age" value="${alumno.age}" class="form-control" />

        <label for="graduate">Titulado:</label>
        <g:select name="graduate" from="[true, false]" value="${alumno.graduate}" class="form-control" />

        <g:submitButton name="updateAlumno" value="Guardar Cambios" class="btn btn-primary" />
    </g:form>
</div>
</body>
</html>
