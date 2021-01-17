/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Milos
 */
@Entity
@Table(name = "spediter")
public class Spediter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sifraSpeditera")
    private Integer sifraSpeditera;
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "email")
    private String email;
    @Column(name = "fax")
    private String fax;
    @Column(name = "brojTelefona")
    private String brojTelefona;
    @Column(name = "ulicaIBroj")
    private String ulicaIBroj;
    @JoinColumn(name = "postanskiBroj", referencedColumnName = "postanskiBroj")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Grad grad;

    public Spediter() {
    }

    public Spediter(Integer sifraSpeditera, String naziv, String email, String fax, String brojTelefona, String ulicaIBroj, Grad grad) {
        this.sifraSpeditera = sifraSpeditera;
        this.naziv = naziv;
        this.email = email;
        this.fax = fax;
        this.brojTelefona = brojTelefona;
        this.ulicaIBroj = ulicaIBroj;
        this.grad = grad;
    }

    public Spediter(Integer sifraSpeditera) {
        this.sifraSpeditera = sifraSpeditera;
    }

    public Integer getSifraSpeditera() {
        return sifraSpeditera;
    }

    public void setSifraSpeditera(Integer sifraSpeditera) {
        this.sifraSpeditera = sifraSpeditera;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraSpeditera != null ? sifraSpeditera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spediter)) {
            return false;
        }
        Spediter other = (Spediter) object;
        if ((this.sifraSpeditera == null && other.sifraSpeditera != null) || (this.sifraSpeditera != null && !this.sifraSpeditera.equals(other.sifraSpeditera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Spediter{" + "sifraSpeditera=" + sifraSpeditera + ", naziv=" + naziv + ", email=" + email + ", fax=" + fax + ", brojTelefona=" + brojTelefona + ", ulicaIBroj=" + ulicaIBroj + ", grad=" + grad + '}';
    }

   
    public String getUlicaIBroj() {
        return ulicaIBroj;
    }

    public void setUlicaIBroj(String ulicaIBroj) {
        this.ulicaIBroj = ulicaIBroj;
    }

}
