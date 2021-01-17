/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Milos
 */
@Entity
@Table(name = "stavkacenovnika")
@NamedQueries({
    @NamedQuery(name = "Stavkacenovnika.findAll", query = "SELECT s FROM Stavkacenovnika s")})
 @IdClass(ChildID.class)
public class Stavkacenovnika implements Serializable {

    private static final long serialVersionUID = 1L;
 /*  @Id
    @JoinColumn(name = "sifracenovnika", referencedColumnName = "sifracenovnika")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Cenovnik cenovnik;*/
    @Id
    private Integer  sifracenovnika;
    @Id
    @GeneratedValue
    private int rb;
    private String vrednost;
    @Column(name = "vrednostBezPdv")
    private String vrednostBezPdv;
    @Transient
    private int status;
    @ManyToOne(optional = false)
    @JoinColumn(name = "sifraproizvoda")
    private Proizvod proizvod;

    public Stavkacenovnika() {
    }

    @Override
    public String toString() {
        return "Stavkacenovnika{" + "rb=" + rb + ", vrednost=" + vrednost + ", vrednostBezPdv=" + vrednostBezPdv + ", status=" + status + ", proizvod=" + proizvod + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        //    hash = 31 * hash + Objects.hashCode(this.cenovnik);
        hash = 31 * hash + this.rb;
        hash = 31 * hash + Objects.hashCode(this.vrednost);
        hash = 31 * hash + Objects.hashCode(this.vrednostBezPdv);
        hash = 31 * hash + Objects.hashCode(this.status);
        hash = 31 * hash + Objects.hashCode(this.proizvod);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stavkacenovnika other = (Stavkacenovnika) obj;
        if (this.rb != other.rb) {
            return false;
        }
        if (!Objects.equals(this.vrednost, other.vrednost)) {
            return false;
        }
        if (!Objects.equals(this.vrednostBezPdv, other.vrednostBezPdv)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }

        if (!Objects.equals(this.proizvod, other.proizvod)) {
            return false;
        }
        return true;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getVrednost() {
        return vrednost;
    }

    public void setVrednost(String vrednost) {
        this.vrednost = vrednost;
    }

    public String getVrednostBezPdv() {
        return vrednostBezPdv;
    }

    public void setVrednostBezPdv(String vrednostBezPdv) {
        this.vrednostBezPdv = vrednostBezPdv;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }
/*
    public void setCenovnik(Cenovnik cenovnik) {
        this.cenovnik = cenovnik;
    }
*/
    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    /*public Cenovnik getCenovnik() {
        return cenovnik;
    }*/

    public Integer getSifracenovnika() {
        return sifracenovnika;
    }

    public void setSifracenovnika(Integer sifracenovnika) {
        this.sifracenovnika = sifracenovnika;
    }

}
