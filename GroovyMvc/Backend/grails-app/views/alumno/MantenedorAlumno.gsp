<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin Groovy</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'StyleMantenedor.css')}"/>

    <!--Link Boxicons.com-->
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel ="stylesheet"/>


</head>
<body>

    <!-- Inicio sidebar-->
    <div class = "sidebar">
        <div class = "top">
            <div class ="logo">

            <!--- La i es para mostrar un texto con un estilo en cursiva--->
            <i class = "bx bxl-codepen"></i>
            <span>UTFSM</span>

            </div>
            <i class= "bx bx-menu" id ="btn"></i>
        </div>
        <div class ="user">
            <img src="${resource(dir: 'images', file: 'cat.jpg')}" alt = "me" class ="user-img"/>
            <div>
                <p class = "bold">Juan M.</p>
                <p>Admin</p>
            </div>
        </div>
        <!-- Un ul en html es una lista desordenada-->
        <ul>

            <!-- CRUD ALumnos -->
            <li>
                <a href="#">
                    <i class='bx bxs-user-account'></i>
                    <span class ="nav-item">Alumnos</span>
                </a>
                <span class = "tooltip">Listado Alumnos</span>
            </li>


            <!-- CRUD Profesores -->
            <li>
                <a href="#">
                    <i class='bx bxs-user-rectangle'></i>
                    <span class ="nav-item">Profesores</span>
                </a>
                <span class = "tooltip">Listado Profesores</span>
            </li>


            <!-- CRUD Ramo (micronegocio) -->
            <li>
                <a href="#">
                    <i class='bx bxs-food-menu'></i>
                    <span class ="nav-item">Ramo</span>
                </a>
                <span class = "tooltip">Listado Ramos</span>
            </li>

                        <!-- CRUD Ramo (micronegocio) -->
            <li>
                <a href="#">
                    <i class='bx bx-log-out'></i>
                    <span class ="nav-item">Cerrar Sesion</span>
                </a>
                <span class = "tooltip">Cerrar Sesion</span>
            </li>

        </ul>
    </div>


       <!--        Espacio para crear un nuevo alumno     -->
    <div class ="main-content">
        <div class ="container">  
            <h1 class = 'header2'>Mantenedor Alumnos</h1>

 

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
                    <g:select name="graduate" from="[true, false]" value="¿Titulado?" class="form-control"/>
                </div>
                <div class="buttons" style="margin-top: 10px;">
                    <g:submitButton name="createAlumno" value="Guardar" class="btn btn-primary"/>
                </div>
            </g:form>

        </div>


        <!--        tabla principal para el CRUD    -->
        <div class = 'container mt-4'>
            <table class = 'table'>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Carrera</th>
                        <th>Acciones</th>
                    </tr>
                </thead>

                <tbody>
                <g:each in="${alumnos}" var="alumno">
                    <tr>
                        <td>${alumno.name}</td>
                        <td>${alumno.lastName}</td>
                        <td>${alumno.degree}</td>
                        <td>
                            <g:link controller="alumno" action="editForm" params="[id: alumno.id]" class="btn btn-warning">Editar</g:link>
                            <button type="button" class="btn btn-danger delete-btn" data-id="${alumno.id}">Eliminar</button>
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>

            </div>
    </div>


    <script src="${resource(dir: 'assets/javascripts', file: 'methods.js')}" type="text/javascript"></script>
    <script src="${resource(dir: 'assets/javascripts', file: 'Buttons.js')}" type="text/javascript"></script>

</body>
</html>