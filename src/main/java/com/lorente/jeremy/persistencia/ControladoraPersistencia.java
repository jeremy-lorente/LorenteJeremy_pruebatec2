package com.lorente.jeremy.persistencia;

import com.lorente.jeremy.logica.Gestion;
import com.lorente.jeremy.logica.Persona;
import com.lorente.jeremy.logica.Turno;
import com.lorente.jeremy.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase ControladoraPersistencia representa una interfaz que hace uso de los
 * jpaController que permite manejar las operaciones CRUD con las entidades
 * Gestion, Persona y Turno en la base de datos.
 */
public class ControladoraPersistencia {

    PersonaJpaController personaJPA = new PersonaJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();
    GestionJpaController gestionJPA = new GestionJpaController();

    public void crearPersona(Persona persona) {
        try {
            personaJPA.create(persona);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearTurno(Turno turno) {
        turnoJPA.create(turno);
    }

    public void crearGestion(Gestion gestion) {
        gestionJPA.create(gestion);
    }

    public void eliminarPersona(String dni) {
        try {
            personaJPA.destroy(dni);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarTurno(Long id) {
        try {
            turnoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarGestion(Long id) {
        try {
            gestionJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarPersona(Persona persona) {
        try {
            personaJPA.edit(persona);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarTurno(Turno turno) {
        try {
            turnoJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarGestion(Gestion gestion) {

        try {
            gestionJPA.edit(gestion);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Persona> traerPersonas() {
        return personaJPA.findPersonaEntities();
    }

    public List<Turno> traerTurnos() {
        return turnoJPA.findTurnoEntities();
    }

    public Turno traerTurnoId(Long id) {
        return turnoJPA.findTurno(id);
    }

    public List<Turno> traerTurnosDePersona(String dni) {
        return turnoJPA.findTurnosDni(dni);
    }

    public List<Gestion> traerGestiones() {
        return gestionJPA.findGestionEntities();
    }

    public Gestion traerGestionId(Long id) {
        return gestionJPA.findGestion(id);
    }

    public Persona traerPersonaId(String id) {
        return personaJPA.findPersona(id);
    }
}
