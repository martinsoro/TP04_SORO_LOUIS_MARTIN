/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptebancaires.gestionnaires;

import javax.ejb.Stateless;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import comptebancaire.modeles.CompteBancaire;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author louis-martin
 */
@Stateless
public class GestionCompteBancaire {

  /*  public static Collection<CompteBancaire> creeCompte(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   
    
    @PersistenceContext 
    private EntityManager em;
   
    
   /* public CompteBancaire creeCompte(String nom, String prenom, String numcompte, double balance) {
        CompteBancaire c = new CompteBancaire(nom, prenom, numcompte , balance);
        
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("APP");
        em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        System.out.print(c.getFirstName());
        System.out.print(c.getAccountNumber());
        System.out.print(c.getBalance());
        System.out.print(c.getLastName());
        em.persist(c);
        transac.commit();
        em.close();
        emf.close();
        return c;
    }*/
    
    public CompteBancaire creeCompte(String firstName, String lastName, String accountNumber, double balance) {
        CompteBancaire u = new CompteBancaire(firstName, lastName, accountNumber, balance);
        em.persist(u);
        return u;
    }
    
    
    public Collection<CompteBancaire> getAllCompte() {
        // Exécution d'une requête équivalente à un select *
        Query q = em.createQuery("select u from CompteBancaire u");
        return q.getResultList();
    }

  /*  public Collection<CompteBancaire> creeCompte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Collection<CompteBancaire> creeCompte(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
}
