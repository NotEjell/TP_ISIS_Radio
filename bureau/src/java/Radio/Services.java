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

    public void close() {
        em.close();
    }

    public void flush() {
        em.getTransaction().begin();
        em.flush();
        em.getTransaction().commit();
    }

    public void clear() {
        em.getTransaction().begin();
        em.clear();
        em.getTransaction().commit();
    }

    public Acte creerActe(Acte myActe) {
        em.getTransaction().begin();
        em.persist(myActe);
        em.getTransaction().commit();
        return myActe;
    }

    public Admission creerAdmission(Admission myAdmission) {
        // this.creerPatient(myAdmission.getMyPatient());
        //test admission présente
        if ((this.getAdmissionByIep(myAdmission.getIep()))==null) {
            em.getTransaction().begin();
            em.persist(myAdmission);
            em.getTransaction().commit();
        }
        else {
            updateAdmission(myAdmission);
        }
        return myAdmission;
    }

    public Modalite creerModalite(Modalite myModalite) {
        em.getTransaction().begin();
        em.persist(myModalite);
        em.getTransaction().commit();
        return myModalite;
    }

    public Image creerImage(Image myImage) {
        em.getTransaction().begin();
        em.persist(myImage);
        em.getTransaction().commit();
        return myImage;
    }

    public Admission getAdmissionByIep(int iep) {

        Admission myAdmission = em.find(Admission.class, iep);

        return myAdmission;
    }

    public List<Acte> getActesByIEP(int iep) {

        Admission myAdmission = em.find(Admission.class, iep);

        return myAdmission.getMyActes();
    }

    public Acte getActeById(int id) {

        return em.find(Acte.class, id);
    }

    public Modalite getModaliteById(int id) {

        return em.find(Modalite.class, id);
    }

    public List<Image> getImagesByIPP(int ipp) {

        List<Acte> myActes = new ArrayList<>();
        List<Image> myImages = new ArrayList<>();

        Patient myPatient = em.find(Patient.class, ipp);

        TypedQuery<Admission> query = em.createQuery("SELECT a FROM Admission a Where Patient = :patient", Admission.class).setParameter("patient", myPatient);

        List<Admission> myAdmissions = query.getResultList();

        myAdmissions.forEach(admission -> admission.getMyActes().forEach(acte -> myActes.add(acte)));

        myActes.forEach(acte -> acte.getMyImages().forEach(image -> myImages.add(image)));
        return myImages;
    }
    
    public List<CCAM> getAllCCAM(){
        TypedQuery<CCAM> query = em.createQuery("SELECT c FROM CCAM c", CCAM.class);
        return query.getResultList();
    }

    public void ajouterImageActe(Acte myActe, String chemin) {
        Image myImage = new Image();
        myImage.setPath(chemin);

        myActe.getMyImages().add(creerImage(myImage));
    }

    public void deleteAllImages() {

        em.getTransaction().begin();
        em.createQuery("DELETE FROM Image").executeUpdate();
        em.getTransaction().commit();
    }

    public void deleteAllActes() {

        em.getTransaction().begin();
        em.createQuery("DELETE FROM Acte").executeUpdate();
        em.getTransaction().commit();
    }

    public void deleteAllAdmission() {

        em.getTransaction().begin();
        em.createQuery("DELETE FROM Admission").executeUpdate();
        em.getTransaction().commit();
    }

    public void deleteAllModalite() {

        em.getTransaction().begin();
        em.createQuery("DELETE FROM Modalite").executeUpdate();
        em.getTransaction().commit();
    }

    public void deleteAllPatient() {

        em.getTransaction().begin();
        em.createQuery("DELETE FROM Patient").executeUpdate();
        em.getTransaction().commit();
    }

    public void deleteAllUF() {

        em.getTransaction().begin();
        em.createQuery("DELETE FROM UF").executeUpdate();
        em.getTransaction().commit();
    }

    public void updateActe(Acte myActe) {
        em.getTransaction().begin();
        em.merge(myActe);
        em.getTransaction().commit();
    }

    public void updateAdmission(Admission myAdmission) {
        em.getTransaction().begin();
        em.merge(myAdmission);
        em.getTransaction().commit();
    }

    public void updateCCAM(CCAM myCCAM) {
        em.getTransaction().begin();
        em.merge(myCCAM);
        em.getTransaction().commit();
    }

    public void updateImage(Image myImage) {
        em.getTransaction().begin();
        em.merge(myImage);
        em.getTransaction().commit();
    }

    public void updateModalite(Modalite myModalite) {
        em.getTransaction().begin();
        em.merge(myModalite);
        em.getTransaction().commit();
    }

    public void updatePatient(Patient myPatient) {
        em.getTransaction().begin();
        em.merge(myPatient);
        em.getTransaction().commit();
    }

    public void updateUF(UF myUF) {
        em.getTransaction().begin();
        em.merge(myUF);
        em.getTransaction().commit();
    }

}
