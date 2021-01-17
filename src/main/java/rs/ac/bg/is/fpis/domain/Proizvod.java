/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Milos
 */
@Entity
@Table(name = "proizvod")
public class Proizvod implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    @Column(name = "sifraproizvoda",length=10)
    private String sifraproizvoda;
    @Column(name = "model")
    private String model;
    

    public Proizvod() {
    }

    public Proizvod(String sifraproizvoda) {
        this.sifraproizvoda = sifraproizvoda;
    }

    public String getSifraproizvoda() {
        return sifraproizvoda;
    }

    public void setSifraproizvoda(String sifraproizvoda) {
        this.sifraproizvoda = sifraproizvoda;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraproizvoda != null ? sifraproizvoda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proizvod)) {
            return false;
        }
        Proizvod other = (Proizvod) object;
        if ((this.sifraproizvoda == null && other.sifraproizvoda != null) || (this.sifraproizvoda != null && !this.sifraproizvoda.equals(other.sifraproizvoda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.is.fpis.entity.Proizvod[ sifraproizvoda=" + sifraproizvoda + " ]";
    }
    
}
