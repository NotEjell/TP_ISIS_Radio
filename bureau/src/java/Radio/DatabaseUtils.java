/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Romain Fouchier
 */
public class DatabaseUtils {
    private static EntityManagerFactory fact = null;

    static public EntityManagerFactory fact() {
         if (fact == null) fact = Persistence.createEntityManagerFactory("radioPU");
         return fact; 
   }
}
