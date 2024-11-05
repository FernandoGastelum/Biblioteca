/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Prestamo;
import java.time.LocalDate;
import javax.persistence.EntityManager;

/**
 *
 * @author caarl
 */
public class PrestamoDAO {
  private EntityManager em = JPAUtil.getEntityManager();

    public void registrarPrestamo(Prestamo prestamo) {
        prestamo.setFechaPrestamo(LocalDate.now());
        prestamo.getLibro().setDisponible(false);
        em.getTransaction().begin();
        em.persist(prestamo);
        em.merge(prestamo.getLibro());
        em.getTransaction().commit();
    }

    public void registrarDevolucion(Long prestamoId) {
        Prestamo prestamo = em.find(Prestamo.class, prestamoId);
        if (prestamo != null) {
            prestamo.setFechaDevolucion(LocalDate.now());
            prestamo.getLibro().setDisponible(true);
            em.getTransaction().begin();
            em.merge(prestamo);
            em.merge(prestamo.getLibro());
            em.getTransaction().commit();
        }
    }

    public Prestamo buscarPorId(Long id) {
        return em.find(Prestamo.class, id);
    }
}
