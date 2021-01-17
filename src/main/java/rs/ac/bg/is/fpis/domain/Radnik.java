/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import rs.ac.bg.is.fpis.domain.Cenovnik;

/**
 *
 * @author Milos
 */
@Entity
@Table(name = "radnik")
public class Radnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "sifraradnika", length = 10)
    private String sifraradnika;
    @Column(name = "imePrezime")
    private String imePrezime;
    @Column(name = "email")
    private String email;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @JoinColumn(name = "sifraradnika", referencedColumnName = "sifraradnika")
    @JsonIgnore
    private List<Cenovnik> cenovnici;

    public Radnik() {
    }

    public Radnik(String sifraradnika) {
        this.sifraradnika = sifraradnika;
    }

    public String getSifraradnika() {
        return sifraradnika;
    }

    public void setSifraradnika(String sifraradnika) {
        this.sifraradnika = sifraradnika;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Cenovnik> getCenovnici() {
        return cenovnici;
    }

    public void setCenovnici(List<Cenovnik> cenovnici) {
        this.cenovnici = cenovnici;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraradnika != null ? sifraradnika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Radnik)) {
            return false;
        }
        Radnik other = (Radnik) object;
        if ((this.sifraradnika == null && other.sifraradnika != null) || (this.sifraradnika != null && !this.sifraradnika.equals(other.sifraradnika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.is.fpis.entity.Radnik[ sifraradnika=" + sifraradnika + " ]";
    }

}
