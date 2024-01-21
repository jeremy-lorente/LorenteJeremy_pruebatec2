<%@page import="com.lorente.jeremy.logica.Turno"%>
<%@page import="com.lorente.jeremy.logica.Controladora"%>
<%@page import="com.lorente.jeremy.logica.Gestion"%>
<%@page import="com.lorente.jeremy.logica.Persona"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Turno</title>
        <link rel="stylesheet" type="text/css" href="./css/estilo.css">
    </head>
    <body>
        <nav>  
            <a href="index.jsp">Inicio</a>
            <a href="gestion.jsp">Gestiones</a>
            <a href="turno.jsp">Turnos</a>
        </nav>

        <div class="registrar-turno">
            <h2>Registrar turno</h2>
            <form action="TurnoSv" method="POST">
                <label for="dniPersona">Selecciona el dni de la persona:</label>
                <select name="dniPersona" id="dniPersona">
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
                <br>
                <label for="gestionTipo">Seleccion el tipo de gestion:</label>
                <select name="gestionTipo" id="gestionTipo">
                    <%
                        List<Gestion> gestiones = controladora.traerGestiones();

                        for (Gestion gestion : gestiones) {
                    %>
                    <option value="<%= gestion.getId()%>"><%= gestion.getNombre()%></option>
                    <%
                        }
                    %>            
                </select>
                <br>
                <label for="fecha">Fecha de la solicitud:</label>
                <input type="date" name="fecha" required>
                <br>

                <label for="descripcion">Descripcion de la gestion</label>
                <textarea name="descripcion"></textarea>
                <br>
                <br>
                <input type="submit" value="Registrar turno">

            </form>
        </div>
        <br>
        <div class="ver-turnos">    
            <form action="TurnoSv" method="GET">
                <h2>Buscar turnos por fecha</h2>
                <label for="fechaInicio">Fecha de inicio:</label>
                <input type="date" name="fechaInicio" required>
                <label for="fechaFin">Fecha de fin:</label>
                <input type="date" name="fechaFin" required>             
                <button type="submit">Mostrar</button>                
            </form>

            <br>
            <% if (request.getAttribute("turnos") != null) {%>
            <table border ="1">
                <thead>
                    <tr>
                        <th>Id Turno</th>
                        <th>Id Persona</th>
                        <th>Nombre Persona </th>
                        <th>Apellido Persona</th>
                        <th>Fecha</th>
                        <th>Gestion</th>
                        <th>Descripcion</th>
                        <th>Estado<th>
                    </tr>
                </thead>  
                <tbody>
                    <% for (Turno turno : (List<Turno>) request.getAttribute("turnos")) {%>
                    <tr>
                        <td><%= turno.getId()%></td>
                        <td><%= turno.getPersona().getDni()%></td>
                        <td><%= turno.getPersona().getNombre()%></td>
                        <td><%= turno.getPersona().getApellido()%></td>
                        <td><%= turno.getFecha()%></td>
                        <td><%= turno.getGestion().getNombre()%></td>
                        <td><%= turno.getDescripcion()%></td>
                        <td><%= turno.getEstado()%></td>
                        <td>
                            <form action="EditTurnoSv" method="GET">
                                <input type="hidden" name="turnoId" value="<%= turno.getId()%>">
                                <input type="submit" value="Editar">
                            </form>
                            <form class="eliminar-form" action="ElimTurnoSv" method="POST">
                                <input type="hidden" name="turnoId" value="<%= turno.getId()%>">
                                <input type="submit" value="Eliminar">
                            </form>
                        </td>
                    </tr>
                    <% }%>

                </tbody>
            </table>
            <% }%>
        </div>

        <div class="ver-turnos-estado">    
            <form action="TurnoEstadoSv" method="GET">
                <h2>Buscar turnos por fecha y estado</h2>
                <label for="fechaInicio">Fecha de inicio:</label>
                <input type="date" name="fechaInicio" required>
                <label for="fechaFin">Fecha de fin:</label>
                <input type="date" name="fechaFin" required>      
                <select id="estado" name="estado">
                    <option value="En espera">En espera</option>
                    <option value="Ya atendido" >Ya atendido</option>    
                </select>

                <button type="submit">Mostrar</button>                
            </form>

            <br>
            <% if (request.getAttribute("turnosEstado") != null) {%>
            <table border ="1">
                <thead>
                    <tr>
                        <th>Id Turno</th>
                        <th>Id Persona</th>
                        <th>Nombre Persona </th>
                        <th>Apellido Persona</th>
                        <th>Fecha</th>
                        <th>Gestion</th>
                        <th>Descripcion</th>
                        <th>Estado<th>
                    </tr>
                </thead>  
                <tbody>
                    <% for (Turno turno : (List<Turno>) request.getAttribute("turnosEstado")) {%>
                    <tr>
                        <td><%= turno.getId()%></td>
                        <td><%= turno.getPersona().getDni()%></td>
                        <td><%= turno.getPersona().getNombre()%></td>
                        <td><%= turno.getPersona().getApellido()%></td>
                        <td><%= turno.getFecha()%></td>
                        <td><%= turno.getGestion().getNombre()%></td>
                        <td><%= turno.getDescripcion()%></td>
                        <td><%= turno.getEstado()%></td>
                        <td>
                            <form action="EditTurnoSv" method="GET">
                                <input type="hidden" name="turnoId" value="<%= turno.getId()%>">
                                <input type="submit" value="Editar">
                            </form>
                            <form class="eliminar-form" action="ElimTurnoSv" method="POST">
                                <input type="hidden" name="turnoId" value="<%= turno.getId()%>">
                                <input type="submit" value="Eliminar">
                            </form>
                        </td>
                    </tr>
                    <% }%>

                </tbody>
            </table>
            <% }%>
        </div>


    </body>
</html>
