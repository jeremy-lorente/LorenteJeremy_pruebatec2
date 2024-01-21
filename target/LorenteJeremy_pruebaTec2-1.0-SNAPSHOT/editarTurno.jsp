

<%@page import="com.lorente.jeremy.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Turno</title>
        <link rel="stylesheet" type="text/css" href="./css/estilo.css">
    </head>
    <body>
        <div>
            <h2>Editar Turno</h2>
            <% Turno turno = (Turno) request.getAttribute("turno");
            %>
            <form action="EditTurnoSv" method="POST">
                <label for="descripcion">Descripcion de la gestion</label>
                <textarea name="descripcion"><%= turno.getDescripcion()%></textarea>
                <br>
                <label for="estado">Estado de la solicitud</label>
                <select id="estado" name="estado">
                    <option value="En espera">En espera</option>
                    <option value="Ya atendido" >Ya atendido</option>    
                </select>
                <br>
                <input type="hidden" name="turnoId" value="<%= turno.getId()%>">
                <input type="submit" value="Modificar turno">
                <form action="turno.jsp" method="GET">
                    <input type="submit" value="Cancelar">
                </form>
            </form>
        </div>

    </body>
</html>
