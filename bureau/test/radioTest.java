/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Radio.*;
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
    
    @Test
    public void clean() {
        Services serv = new Services(DatabaseUtils.fact());
        serv.deleteAllActes();
        serv.deleteAllAdmission();
        serv.deleteAllImages();
        serv.deleteAllModalite();
        serv.deleteAllPatient();
        serv.deleteAllUF();
    }
    
    @Test
    public void testActe(){
        clean();
        Services serv = new Services(DatabaseUtils.fact());
        //Creation des modalites utiles aux actes
        //??
        Acte act1 = serv.creerActe(new Acte());
        assertNotNull(act1);
    }
}

