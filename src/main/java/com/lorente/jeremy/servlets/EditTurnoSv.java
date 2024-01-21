package com.lorente.jeremy.servlets;

import com.lorente.jeremy.logica.Controladora;
import com.lorente.jeremy.logica.Turno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet que gestiona la edicion de un turno. Permite tanto la obtencion de
 * informacion de un turno para su edicion como la actualizacion de los datos en
 * la base de datos.
 */
@WebServlet("/EditTurnoSv")
public class EditTurnoSv extends HttpServlet {

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

        if (request.getParameter("turnoId") != null && !request.getParameter("turnoId").isEmpty()) {
            Long turnoId = Long.parseLong(request.getParameter("turnoId"));

            Turno turno = control.traerTurnoId(turnoId);

            request.setAttribute("turno", turno);
            request.getRequestDispatcher("editarTurno.jsp").forward(request, response);
        }

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

        String descripcion = request.getParameter("descripcion").toString();
        String estado = request.getParameter("estado");
        Long turnoId = Long.parseLong(request.getParameter("turnoId"));

        System.out.println(turnoId);

        Turno turno = control.traerTurnoId(turnoId);
        if (turno != null) {
            turno.setDescripcion(descripcion);
            turno.setEstado(estado);
            control.editarTurno(turno);
        }

        request.getRequestDispatcher("turno.jsp").forward(request, response);

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
