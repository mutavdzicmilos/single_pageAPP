/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.LazyCollection;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Milos
 */
@Entity
@Table(name = "cenovnik")
public class Cenovnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sifracenovnika")
    private Integer sifracenovnika;
    @Column(name = "datum")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datum;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "sifracenovnika")
    private List<Stavkacenovnika> stavke;
    @JoinColumn(name = "sifraradnika", referencedColumnName = "sifraradnika")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Radnik radnik;
    @JoinColumn(name = "sifraDrzave", referencedColumnName = "sifraDrzave")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Drzava drzava;

    public Cenovnik() {
    }

    public Cenovnik(int sifracenovnika) {
        this.sifracenovnika = sifracenovnika;
    }

    public int getSifracenovnika() {
        return sifracenovnika;
    }

    public void setSifracenovnika(int sifracenovnika) {
        this.sifracenovnika = sifracenovnika;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cenovnik)) {
            return false;
        }
        Cenovnik other = (Cenovnik) object;
        return true;
    }

    @Override
    public String toString() {
        return "Cenovnik{" + "sifracenovnika=" + sifracenovnika + ", datum=" + datum + ", stavke=" + stavke + ", radnik=" + radnik + ", drzava=" + drzava + '}';
    }

    public List<Stavkacenovnika> getStavke() {
        return stavke;
    }

    public void setStavke(List<Stavkacenovnika> stavke) {
        this.stavke = stavke;
        if (stavke != null) {
            for (Stavkacenovnika st : stavke) {
                st.setSifracenovnika(this.sifracenovnika);
            }
        }
    }

}
