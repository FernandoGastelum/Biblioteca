/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author caarl
 */
public class JPAUtil {

    /**
     * @param args the command line arguments
     */
     private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaPU");
    
    
    
     public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
