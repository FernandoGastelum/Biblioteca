/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Bibliotecario;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author caarl
 */
public class BibliotecarioDAO {
    private EntityManager em = JPAUtil.getEntityManager();

    public void registrar(Bibliotecario bibliotecario) {
        em.getTransaction().begin();
        em.persist(bibliotecario);
        em.getTransaction().commit();
    }

    public Bibliotecario autenticar(String email, String contrasena) {
        TypedQuery<Bibliotecario> query = em.createQuery("SELECT b FROM Bibliotecario b WHERE b.email = :email AND b.contrasena = :contrasena", Bibliotecario.class);
        query.setParameter("email", email);
        query.setParameter("contrasena", contrasena);
        return query.getResultStream().findFirst().orElse(null);
    }
}