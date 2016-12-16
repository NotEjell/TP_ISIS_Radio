/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Romain Fouchier
 */
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iep;   
    
    @Column
    private Patient myPatient;

    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Acte> myActes;
    
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
