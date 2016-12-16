/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

import java.util.ArrayList;
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
    
    public Acte creerActe(Acte myActe) {
	em.getTransaction( ).begin( );
        em.persist(myActe);
        em.getTransaction().commit();
        return myActe;
    }
    
    public Modalite creerModalite(Modalite myModalite) {
	em.getTransaction( ).begin( );
        em.persist(myModalite);
        em.getTransaction().commit();
        return myModalite;
    }
    
    public Image creerImage(Image myImage) {
	em.getTransaction( ).begin( );
        em.persist(myImage);
        em.getTransaction().commit();
        return myImage;
    }
    
    public Admission getAdmissionById(int id) {
       
	Admission myAdmission = em.find( Admission.class, id );
      
        return myAdmission;
    }
    
    public List<Acte> getActesByIEP(int iep) {
       
	Admission myAdmission = em.find( Admission.class, iep );
      
        return myAdmission.getMyActes();
    }
    
    public List<Image> getImagesByIPP(int ipp) {

        List<Acte> myActes = new ArrayList<>();
        List<Image> myImages = new ArrayList<>();
        
	Patient myPatient = em.find( Patient.class, ipp );
        
        TypedQuery<Admission> query = em.createQuery("SELECT a FROM Admission a Where myPatient = :patient", Admission.class).setParameter("patient", myPatient);
        
        List<Admission> myAdmissions = query.getResultList();       
        
        myAdmissions.forEach(admission -> admission.getMyActes().forEach(acte -> myActes.add(acte)));
        
        myActes.forEach(acte -> acte.getMyImages().forEach(image -> myImages.add(image)));
        return myImages;
    }
    
    public void ajouterImageActe(Acte myActe, String chemin){
        Image myImage = new Image();
        myImage.setPath(chemin);
        
        myActe.getMyImages().add(creerImage(myImage));
    }
}
