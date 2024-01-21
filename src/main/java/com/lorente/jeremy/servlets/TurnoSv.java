package com.lorente.jeremy.servlets;

import com.lorente.jeremy.logica.Controladora;
import com.lorente.jeremy.logica.Turno;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Este servlet se encarga de gestionar las operaciones relacionadas con los
 * turnos. Permite la consulta y creación de turnos mediante solicitudes HTTP
 * GET y POST respectivamente.
 */
@WebServlet("/TurnoSv")
public class TurnoSv extends HttpServlet {

    private Controladora control = new Controladora();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        List<Turno> turnos = control.traerTurnos();

        LocalDate fechaInicio = LocalDate.parse(request.getParameter("fechaInicio"));
        LocalDate fechaFin = LocalDate.parse(request.getParameter("fechaFin"));

        List<Turno> turnosEntre = turnos.stream()
                .filter(turno -> turno.getFecha().isAfter(fechaInicio) && turno.getFecha().isBefore(fechaFin))
                .collect(Collectors.toList());
        request.setAttribute("turnos", turnosEntre);
        request.getRequestDispatcher("turno.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String gestionTipoStr = request.getParameter("gestionTipo");
        Long gestionId = Long.parseLong(gestionTipoStr);
        String dniPersona = request.getParameter("dniPersona");

        Turno turno = new Turno();

        turno.setPersona(control.traerPersonaId(dniPersona));
        turno.setGestion(control.traerGestionId(gestionId));
        turno.setFecha(LocalDate.parse(request.getParameter("fecha")));
        turno.setDescripcion(request.getParameter("descripcion"));
        turno.setEstado("En espera");

        control.crearTurno(turno);
        response.sendRedirect("turno.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
