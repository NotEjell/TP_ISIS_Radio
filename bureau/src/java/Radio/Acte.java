/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

import java.io.Serializable;
import java.sql.Date;
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
public class Acte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UF myUF;
        
    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Modalite> myMateriels;
    
    @Column
    private Date myDate;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CCAM myCCAM;
    
    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Image> myImages;
    
    @Column
    private int isSent = 0;

    public Acte(){
        this.myMateriels = new ArrayList();
        this.myImages = new ArrayList();
    }
    
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

    public List<Image> getMyImages() {
        return myImages;
    }

    public void setMyImages(List<Image> myImages) {
        this.myImages = myImages;
    }

    public void addImage(Image image){
        this.myImages.add(image);
    }
    
    @Override
    public String toString(){
        return this.id + " - " + this.myCCAM.getLibelle();
    }
}
