<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IMC pacientes</title>
</head>
<body>
	<header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue;">
                <div>
                    <a href="#" class="navbar-brand"> Indice de Masa Corporal Pacientes</a>
                </div>

                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/listar" class="nav-link">Pacientes</a></li>
                </ul>
            </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        <c:if test="${paciente != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${paciente == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${paciente != null}">
                                    Editar Paciente
                                </c:if>
                                <c:if test="${paciente == null}">
                                    Añadir nuevo Paciente
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${paciente != null}">
                            <input type="hidden" name="id" value="<c:out value='${paciente.id}' />" />
                        </c:if>
						<fieldset class="form-group">
                            <label>Cedula</label> <input type="text" value="<c:out value='${paciente.documento}' />" class="form-control" name="nombre" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Nombre</label> <input type="text" value="<c:out value='${paciente.nombre}' />" class="form-control" name="nombre" required="required">
                        </fieldset>
                        
						<fieldset class="form-group">
                            <label>Apellido</label> <input type="text" value="<c:out value='${paciente.apellido}' />" class="form-control" name="nombre" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Email</label> <input type="text" value="<c:out value='${paciente.email}' />" class="form-control" name="email">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Genero</label> <input type="text" value="<c:out value='${paciente.genero}' />" class="form-control" name="pais">
                        </fieldset>
						
						<fieldset class="form-group">
                            <label>Fecha Nacimiento</label> <input type="text" value="<c:out value='${paciente.fechaNacimiento}' />" class="form-control" name="pais">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Telefono</label> <input type="text" value="<c:out value='${paciente.telefono}' />" class="form-control" name="pais">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Direccion</label> <input type="text" value="<c:out value='${paciente.direccion}' />" class="form-control" name="pais">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Peso</label> <input type="text" value="<c:out value='${paciente.peso}' />" class="form-control" name="pais">
                        </fieldset>
                                 
                        <fieldset class="form-group">
                            <label>Estatura</label> <input type="text" value="<c:out value='${paciente.estatura}' />" class="form-control" name="pais">
                        </fieldset>
                        
                        <button type="submit" class="btn btn-success">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
</body>
</html>