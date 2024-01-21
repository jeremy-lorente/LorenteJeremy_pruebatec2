
<%@page import="com.lorente.jeremy.logica.Turno"%>
<%@page import="com.lorente.jeremy.logica.Persona"%>
<%@page import="com.lorente.jeremy.logica.Gestion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.lorente.jeremy.logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Turnos</title>
        <link rel="stylesheet" type="text/css" href="./css/estilo.css">

    </head>
    <body>
        <nav>  
            <a href="index.jsp">Inicio</a>
            <a href="gestion.jsp">Gestiones</a>
            <a href="turno.jsp">Turnos</a>
        </nav>


        <div class="registrar-persona">
            <h2>Registrar Persona</h2>
            <form action="PersonaSv" method="POST">
                <label for="dni">Dni de la persona</label>
                <input type="text" name="dni" required>
                <br>
                <label for="nombre">Nombre de la persona</label>
                <input type="text" name="nombre" required>
                <br>
                <label for="apellido">Apellido de la persona</label>
                <input type="text" name="apellido" required>
                <br>
                <input type="submit" value="Registrar persona">

            </form>
        </div>
        <br>


        <div class="eliminar-persona">
            <h2>Eliminar persona:</h2>
            <form action="ElimPersoSv" method="POST">
                <label for="elimPerso">Persona a Eliminar:</label>
                <select name="elimPerso" id="elimPerso">
                    <%
                        Controladora controladora = new Controladora();
                        List<Persona> personas = controladora.traerPersonas();
                        for (Persona persona : personas) {
                    %>

                    <option value="<%= persona.getDni()%>"><%= persona.getDni()%></option>
                    <%
                        }
                    %>  
                </select>

                <input type="submit" value="Eliminar persona">
            </form>
        </div>


    </body>
</html>
