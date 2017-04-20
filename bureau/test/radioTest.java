/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Radio.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Romain Fouchier
 */
public class radioTest {
    static EntityManagerFactory fact;
    
    public radioTest(){}
    
    @BeforeClass
    public static void setUpClass() {
         //fact = Persistence.createEntityManagerFactory("bureauPU");
    }
    
    @AfterClass
    public static void tearDownClass() {
        //fact.close();
    }
    
    @Before
    public void setUp() {
       
    }
    
    @After
    public void tearDown() {
    }
    
    /*public void clean(Services serv) {
        //Services serv = new Services(DatabaseUtils.fact());

        serv.deleteAllAdmission();
        serv.deleteAllActes();
        serv.deleteAllImages();
        serv.deleteAllModalite();
        serv.deleteAllPatient();
        serv.deleteAllUF();
    }*/
    
//    @Test
//    public void testActe(){
//        clean();
//        Services serv = new Services(DatabaseUtils.fact());
//        //Creation des modalites utiles aux actes
//        //??
//        Acte act1 = serv.creerActe(new Acte());
//        assertNotNull(act1);
//    }
    @Test
    public void fillDB(){    
        Services serv = new Services(DatabaseUtils.fact());
        //clean(serv);
        //création de l'image
        Image myImage = new Image();
        myImage.setPath("D:\\Romain\\FOAD\\5ème année\\Projet_Interop\\TP_ISIS_Radio\\trunk\\bureau\\Images\\091228-nytt-2.jpg");
        
        //création de l'UF
        UF myUF = new UF();
        myUF.setLibelle("UF1");
        
        //Creation d'un patient
        Patient myPatient = new Patient();
        myPatient.setIpp(555);
        myPatient.setNom("Romain Fouchier");
        
        //Creation d'actes CCAM
        CCAM myCCAM1 = new CCAM("9093061","Radiographie du poignet",30);
        CCAM myCCAM2 = new CCAM("MBQK001","Radiographie du bras",20);
        CCAM myCCAM3 = new CCAM("NCQK001","Radiographie de la jambe",20);
        
        //Creation de modalités
        Modalite myModalite1 = new Modalite();
        Modalite myModalite2 = new Modalite();
        myModalite1.setType("Scanner");
        myModalite2.setType("Radio");
        
        //Creation d'un acte
        Acte myActe = new Acte();
        myActe.setMyUF(myUF);
        myActe.getMyMateriels().add(myModalite1);
        myActe.setMyDate(new Date(2016-1900, 02-01, 02));
        myActe.setMyCCAM(myCCAM1);
        myActe.getMyImages().add(myImage);
 
        //Creation d'une admission
        int myIep = 1234;
        Admission myAdmission = new Admission(myIep, myPatient);
        myAdmission.getMyActes().add(myActe);
        
        //Ecriture en base
        //serv.updateImage(myImage);
        //serv.updateUF(myUF);
        //serv.updatePatient(myPatient);
        //serv.updateCCAM(myCCAM1);
        //serv.updateCCAM(myCCAM2);
        //serv.updateCCAM(myCCAM3);
        //serv.updateModalite(myModalite1);
        //serv.updateModalite(myModalite2);
        //serv.creerActe(myActe);
        serv.creerAdmission(myAdmission);
        
        //Test persistence
        assertNotNull(serv.getAdmissionByIep(myIep));
        
        //Test reecriture même séjour
        serv.creerAdmission(myAdmission);
        
        //Test admission avec données d'admission
        Admission myAdmission2 = new Admission(666, new Patient(123,"Michel Fugain"));
        
        serv.creerAdmission(myAdmission2);
        /*clean(serv);
        serv.clear();
        serv.flush();
        assertNull(serv.getAdmissionById(myId));*/
        //FLUSH pour commencer tests fonctionnalités
        //clean(serv);
        //serv = new Services(DatabaseUtils.fact());
        
        //Test fonctionnalités
        
        
        //2-Créer une modalité d'imagerie
//        assertNull(serv.getModaliteById(myModalite2.getId()));
//        serv.creerModalite(myModalite2);
//        assertNotNull(serv.getModaliteById(myModalite2.getId()));
        
        //3-Rechercher une admission par IEP
        
        //4-Afficher les actes de radiologie d'une admission
        
        //5-Ajouter une image à un acte
        
        //6-Consulter les images d'un patient
        
        //7-Uploader une image sur un acte
    }
    /*
        @Test
        public void testCrerActe(){
        Services serv = new Services(DatabaseUtils.fact());
        clean(serv);
        //création de l'image
        Image myImage = new Image();
        myImage.setPath("D:\\Romain\\FOAD\\5ème année\\Projet_Interop\\TP_ISIS_Radio\\trunk\\bureau\\Images\\091228-nytt-2.jpg");
        
        //création de l'UF
        UF myUF = new UF();
        myUF.setLibelle("UF1");
        
        //Creation d'un patient
        Patient myPatient = new Patient();
        myPatient.setNom("Romain Fouchier");
        
        //Creation d'actes CCAM
        CCAM myCCAM1 = new CCAM("MGQK001","Radiographie du poignet",30);
        CCAM myCCAM2 = new CCAM("MBQK001","Radiographie du bras",20);
        CCAM myCCAM3 = new CCAM("NCQK001","Radiographie de la jambe",20);
        
        //Creation de modalités
        Modalite myModalite1 = new Modalite();
        Modalite myModalite2 = new Modalite();
        myModalite1.setType("Scanner");
        myModalite2.setType("Radio");
        
        //Creation d'un acte
        Acte myActe = new Acte();
        myActe.setMyUF(myUF);
        myActe.getMyMateriels().add(myModalite2);
        myActe.setMyDate(new Date(2016-1900, 02-01, 02));
        myActe.setMyCCAM(myCCAM1);
        myActe.getMyImages().add(myImage);
        
        //1-Créer un acte Radio
        assertNull(serv.getActeById(myActe.getId()));
        serv.creerActe(myActe);
        assertNotNull(serv.getActeById(myActe.getId()));
        
        serv.clear();
        serv.flush();
    }*/
}    

