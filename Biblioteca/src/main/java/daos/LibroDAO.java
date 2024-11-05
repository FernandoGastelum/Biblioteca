/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Libro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author caarl
 */
public class LibroDAO {
 private EntityManager em = JPAUtil.getEntityManager();

    public void agregar(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    public void actualizar(Libro libro) {
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }

    public Libro buscarPorId(Long id) {
        return em.find(Libro.class, id);
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo", Libro.class);
        query.setParameter("titulo", "%" + titulo + "%");
        return query.getResultList();
    }

    public List<Libro> listarTodos() {
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l", Libro.class);
        return query.getResultList();
    }

    public void eliminar(Long id) {
        Libro libro = buscarPorId(id);
        if (libro != null) {
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
        }
    }
}
