
package com.lorente.jeremy.persistencia;

import com.lorente.jeremy.logica.Gestion;
import com.lorente.jeremy.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jeremy
 */
public class GestionJpaController implements Serializable {

    public GestionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public GestionJpaController() {
      emf = Persistence.createEntityManagerFactory("turnerojspPU");
    }

    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gestion gestion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(gestion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gestion gestion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            gestion = em.merge(gestion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = gestion.getId();
                if (findGestion(id) == null) {
                    throw new NonexistentEntityException("The gestion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gestion gestion;
            try {
                gestion = em.getReference(Gestion.class, id);
                gestion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gestion with id " + id + " no longer exists.", enfe);
            }
            em.remove(gestion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gestion> findGestionEntities() {
        return findGestionEntities(true, -1, -1);
    }

    public List<Gestion> findGestionEntities(int maxResults, int firstResult) {
        return findGestionEntities(false, maxResults, firstResult);
    }

    private List<Gestion> findGestionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gestion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Gestion findGestion(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gestion.class, id);
        } finally {
            em.close();
        }
    }

    public int getGestionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gestion> rt = cq.from(Gestion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
