/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Romain Fouchier
 */
@Entity
@XmlRootElement
public class Admission implements Serializable {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;*/
    
    @Id
    private int iep;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Patient myPatient;

    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Acte> myActes;
    
    public Admission(int iep, Patient myPatient){
        this.iep = iep;
        this.myPatient = myPatient;
        this.myActes = new ArrayList();
    }
    
    public Admission(){
        
    }
    
    public int getIep() {
        return iep;
    }

    public void setIep(int iep) {
        this.iep = iep;
    }

    public Patient getMyPatient() {
        return myPatient;
    }

    public void setMyPatient(Patient myPatient) {
        this.myPatient = myPatient;
    }

    public List<Acte> getMyActes() {
        return myActes;
    }

    public void setMyActes(List<Acte> myActes) {
        this.myActes = myActes;
    }
    
    @Override
    public String toString(){
        return "" + this.iep;
    }
}
