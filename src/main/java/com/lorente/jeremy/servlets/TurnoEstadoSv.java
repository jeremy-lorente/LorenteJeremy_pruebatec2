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
 * turnos y su estado. Permite la consulta de turnos en un rango de fechas y con
 * un estado específico mediante solicitudes HTTP GET.
 */
@WebServlet("/TurnoEstadoSv")
public class TurnoEstadoSv extends HttpServlet {

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
        String estado = request.getParameter("estado");
        List<Turno> turnosEntre = turnos.stream()
                .filter(turno
                        -> turno.getFecha().isAfter(fechaInicio)
                && turno.getFecha().isBefore(fechaFin)
                && estado.equals(turno.getEstado()))
                .collect(Collectors.toList());
        request.setAttribute("turnosEstado", turnosEntre);
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
