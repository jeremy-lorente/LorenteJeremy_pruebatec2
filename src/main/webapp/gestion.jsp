<%@page import="com.lorente.jeremy.logica.Gestion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion</title>
        <link rel="stylesheet" type="text/css" href="./css/estilo.css">
    </head>
    <body>
        <nav>  
            <a href="index.jsp">Inicio</a>
            <a href="gestion.jsp">Gestiones</a>
            <a href="turno.jsp">Turnos</a>
        </nav>

        <div class="registrar-gestion">
            <h2>Registrar Gestion</h2>
            <form action="GestionSv" method="POST">
                <label for="nombreGestion">Nombre de la gestion</label>
                <input type="text" name="nombreGestion" required>
                <br>
                <input type="submit" value="Registrar gestion">

            </form>
        </div>

        <div class="ver-gestiones">
            <h2> Tabla de gestiones </h2>
            <form action="GestionSv" method="GET">
                <button type="submit">Mostrar gestiones</button>                
            </form>
            <br>
            <% if (request.getAttribute("gestiones") != null) {%>
            <table border ="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                    </tr>
                </thead>  
                <tbody>
                    <% for (Gestion gestion : (List<Gestion>) request.getAttribute("gestiones")) {%>
                    <tr>
                        <td><%= gestion.getId()%></td>
                        <td><%= gestion.getNombre()%></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
            <% }%>
        </div>
    </body>
</html>
