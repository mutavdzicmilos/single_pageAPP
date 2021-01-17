/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Milos
 */
@Entity
@Table(name = "drzava")
@NamedQueries({
    @NamedQuery(name = "Drzava.findAll", query = "SELECT d FROM Drzava d")})
public class Drzava implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sifraDrzave")
    private Integer sifraDrzave;
    @Column(name = "naziv")
    private String naziv;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @JoinColumn(name = "sifraDrzave", referencedColumnName = "sifraDrzave")
    private List<Grad> gradList;

    public Drzava() {
    }

    public Drzava(Integer sifraDrzave) {
        this.sifraDrzave = sifraDrzave;
    }

    public Drzava(Integer sifraDrzave, String naziv) {
        this.sifraDrzave = sifraDrzave;
        this.naziv = naziv;
    }

    public Integer getSifraDrzave() {
        return sifraDrzave;
    }

    public void setSifraDrzave(Integer sifraDrzave) {
        this.sifraDrzave = sifraDrzave;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Grad> getGradList() {
        return gradList;
    }

    public void setGradList(List<Grad> gradList) {
        this.gradList = gradList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraDrzave != null ? sifraDrzave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drzava)) {
            return false;
        }
        Drzava other = (Drzava) object;
        if ((this.sifraDrzave == null && other.sifraDrzave != null) || (this.sifraDrzave != null && !this.sifraDrzave.equals(other.sifraDrzave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.is.fpis.entity.Drzava[ sifraDrzave=" + sifraDrzave + " ]";
    }

}
