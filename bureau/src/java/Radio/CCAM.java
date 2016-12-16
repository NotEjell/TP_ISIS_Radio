/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author Romain Fouchier
 */
public class CCAM {
    @Id
    private String id;
    
    @Column
    private String libelle;
    
    @Column
    private int tarif;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }
    
}
