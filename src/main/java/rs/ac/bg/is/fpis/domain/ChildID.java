/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Milos
 */

public class ChildID implements Serializable {
    Integer sifracenovnika;
    Integer rb;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.sifracenovnika);
        hash = 53 * hash + Objects.hashCode(this.rb);
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
        final ChildID other = (ChildID) obj;
        if (!Objects.equals(this.sifracenovnika, other.sifracenovnika)) {
            return false;
        }
        if (!Objects.equals(this.rb, other.rb)) {
            return false;
        }
        return true;
    }
    
}

