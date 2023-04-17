<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IMC pacientes</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<header>
	<nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue;">
			<div>
				<a href="#" class="navbar-brand"> Indice de Masa Corporal de los Pacientes</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listar" class="nav-link" >Pacientes</a></li>
			</ul>
		</nav>
	</header>
	<br/>
	<div class="row">
		<div class="container">
			<h3 class="text-center">Listado de Pacientes</h3>
			<hr>
			<div class="container text-left">
			
				<a href="<%=request.getContextPath()%>/nuevo" class="btn btn-success">Agregar Nuevo Paciente</a>
				
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
					<th>ID</th>
					<th>Cedula</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Genero</th>
					<th>Fecha Nacimiento</th>
					<th>Telefono</th>
					<th>Direccion</th>
					<th>Peso</th>
					<th>Estatura</th>
					<th>IMC</th>
					<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<!-- for (Todo todo:todos) {-->
					<c:forEach var="paciente" items="${listPacientes}">
						<tr>
							<td>
							<c:out value="${paciente.id}"/>
							</td>
							<td>
							<c:out value="${paciente.documento}"></c:out>
							</td>
							<td>
							<c:out value="${paciente.nombre}"></c:out>
							</td>
							<td>
							<c:out value="${paciente.apellido}"></c:out>
							</td>
							<td>
							<c:out value="${paciente.email}"></c:out>
							</td>
							<td>
							<c:out value="${paciente.genero}"></c:out>
							</td>
							<td>
							<c:out value="${paciente.fechanacimiento}"></c:out>
							</td>
							<td>
							<c:out value="${paciente.telefono}"></c:out>
							</td>
							<td>
							<c:out value="${paciente.direccion}"></c:out>
							</td>
							<td>
							<c:out value="${paciente.peso}"></c:out>
							</td>
							<td>
							<c:out value="${paciente.estatura}"></c:out>
							</td>
							<td>
							<c:out value="${paciente.imc}"></c:out>
							</td>
							<td> <a href="edit?id=<c:out value='${paciente.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value= '${paciente.id }' />">Eliminar</a> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>