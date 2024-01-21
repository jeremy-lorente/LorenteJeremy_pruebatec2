package com.lorente.jeremy.logica;

import com.lorente.jeremy.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 * Clase Controladora representa una interfaz que hace uso del controlador que
 * permite manejar las operaciones CRUD con las entidades Gestion, Persona y
 * Turno en la base de datos.
 *
 */
public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearPersona(Persona persona) {
        controlPersis.crearPersona(persona);
    }

    public void crearTurno(Turno turno) {
        controlPersis.crearTurno(turno);
    }

    public void crearGestion(Gestion gestion) {
        controlPersis.crearGestion(gestion);
    }

    public void eliminarPersona(String dni) {
        controlPersis.eliminarPersona(dni);
    }

    public void eliminarTurno(Long id) {
        controlPersis.eliminarTurno(id);
    }

    public void eliminarGesiton(Long id) {
        controlPersis.eliminarGestion(id);
    }

    public void editarPersona(Persona persona) {
        controlPersis.editarPersona(persona);
    }

    public void editarTurno(Turno turno) {
        controlPersis.editarTurno(turno);
    }

    public void editarGestion(Gestion gestion) {
        controlPersis.editarGestion(gestion);
    }

    public List<Persona> traerPersonas() {
        return controlPersis.traerPersonas();
    }

    public List<Turno> traerTurnos() {
        return controlPersis.traerTurnos();
    }

    public Turno traerTurnoId(Long id) {
        return controlPersis.traerTurnoId(id);
    }

    public List<Turno> traerTurnosDePersona(String dni) {
        return controlPersis.traerTurnosDePersona(dni);
    }

    public List<Gestion> traerGestiones() {
        return controlPersis.traerGestiones();
    }

    public Gestion traerGestionId(Long id) {
        return controlPersis.traerGestionId(id);
    }

    public Persona traerPersonaId(String id) {
        return controlPersis.traerPersonaId(id);
    }
}
