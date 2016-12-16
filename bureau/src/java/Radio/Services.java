/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Romain Fouchier
 */
public class Services {

    EntityManagerFactory fact;
    EntityManager em;

    public Services(EntityManagerFactory fact) {
        this.fact = fact;
        this.em = fact.createEntityManager();
    }
    
    public void creerActe(Acte myActe) {
	em.getTransaction( ).begin( );
        em.persist(myActe);
        em.getTransaction().commit();
    }
    
    public void creerModalite(Modalite myModalite) {
	em.getTransaction( ).begin( );
        em.persist(myModalite);
        em.getTransaction().commit();
    }
    
    public Admission getAdmissionById(int id) {
       
	Admission myAdmission = em.find( Admission.class, id );
      
        return myAdmission;
    }
    
}
