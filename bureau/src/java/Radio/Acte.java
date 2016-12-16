/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Romain Fouchier
 */
@Entity
@XmlRootElement
public class Acte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column
    private UF myUF;
        
    @Column
    private Patient myPatient;
    
    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    List<Modalite> myMateriels;
    
    @Column
    private Date myDate;
    
    @Column
    private CCAM myCCAM;
    
    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    List<Image> myImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UF getMyUF() {
        return myUF;
    }

    public void setMyUF(UF myUF) {
        this.myUF = myUF;
    }

    public Patient getMyPatient() {
        return myPatient;
    }

    public void setMyPatient(Patient myPatient) {
        this.myPatient = myPatient;
    }

    public List<Modalite> getMyMateriels() {
        return myMateriels;
    }

    public void setMyMateriels(List<Modalite> myMateriels) {
        this.myMateriels = myMateriels;
    }

    public Date getMyDate() {
        return myDate;
    }

    public void setMyDate(Date myDate) {
        this.myDate = myDate;
    }

    public CCAM getMyCCAM() {
        return myCCAM;
    }

    public void setMyCCAM(CCAM MyCCAM) {
        this.myCCAM = MyCCAM;
    }

    public List<Image> getMyImage() {
        return myImage;
    }

    public void setMyImage(List<Image> myImage) {
        this.myImage = myImage;
    }

    @Override
    public String toString(){
        return this.id + " - " + this.myCCAM.getLibelle();
    }
}