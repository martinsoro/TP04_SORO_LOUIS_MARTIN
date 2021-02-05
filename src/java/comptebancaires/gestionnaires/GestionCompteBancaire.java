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

/**
 *
 * @author louis-martin
 */
@Stateless
public class GestionCompteBancaire {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    
    public CompteBancaire creeCompte(String nom, String prenom, String numcompte, double balance) {
        CompteBancaire c = new CompteBancaire(nom, prenom, numcompte , balance);
        em.persist(c);
        return c;
    }
    
    public Collection<CompteBancaire> getAllCompte() {
        // Exécution d'une requête équivalente à un select *
        Query q = em.createQuery("select c from Utilisateur c");
        return q.getResultList();
    }
    
}
