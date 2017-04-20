/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Romain Fouchier
 */
@Entity
public class Patient implements Serializable {
    @Id
    private int ipp;
    
    @Column
    private String nom;

    public Patient(int myIpp, String myNom){
        this.setIpp(myIpp);
        this.setNom(myNom);
    }
    
    public Patient(){}
    
    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getIpp() {
        return ipp;
    }

    public void setIpp(int ipp) {
        this.ipp = ipp;
    }
    
    @Override
    public String toString(){
        return "" + this.ipp;
    }
}
