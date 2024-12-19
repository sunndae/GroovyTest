<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin Groovy</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'StyleMantenedor.css')}"/>

</head>
    <div class ="container mt-4">
        <h1 class ="header">Mantenedor de alumnos</h1>
    </div>
<body>

    <h2 class = 'header2'>Ingresar un nuevo alumno al sistema</h2>
    <div class = "container mt-4">
    <div class="background"></div>
        <div class ="mb-3">
            <g:form controller="alumno" action="createAlumno" method="POST" class="form-inline">
                <div class="input-group m-1">
                    <g:textField name="name" placeholder="Ingrese el Nombre" class="form-control" maxlength="50"/>
                </div>
                <div class="input-group m-1">
                    <g:textField name="lastName" placeholder="Ingrese el apellido" class="form-control" maxlength="50"/>
                </div>
                <div class="input-group m-1">
                    <g:textField name="degree" placeholder="Ingrese la carrera" class="form-control" maxlength="50"/>
                </div>
                <div class="input-group m-1">
                    <g:textField name="department" placeholder="Ingrese el dpto de la carrera" class="form-control" maxlength="50"/>
                </div>
                <div class="input-group m-1">
                    <g:textField name="age" placeholder="Ingrese su edad" class="form-control" maxlength="50"/>
                </div>
                <div class="input-group m-1">
                    <g:select name="graduate" from="[true, false]" value="false" class="form-control"/>
                </div>
                <div class="buttons" style="margin-top: 10px;">
                    <g:submitButton name="createAlumno" value="Guardar" class="btn btn-primary"/>
                </div>
            </g:form>

        </div>

        <div class = 'container mt-4'>
            <table class = 'table'>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Carrera</th>
                        <th>Departamento</th>
                        <th>Acciones</th>
                    </tr>
                </thead>

                <tbody>
                <g:each in="${alumnos}" var="alumno">
                    <tr>
                        <td>${alumno.name}</td>
                        <td>${alumno.lastName}</td>
                        <td>${alumno.degree}</td>
                        <td>${alumno.department}</td>
                        <td>
                            <g:link controller="alumno" action="editForm" params="[id: alumno.id]" class="btn btn-warning">Editar</g:link>
                            <button type="button" class="btn btn-danger" onclick="deleteAlumno(${alumno.id});">Eliminar</button>
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>



</body>
</html>