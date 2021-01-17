/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.service;

import java.util.List;
import rs.ac.bg.is.fpis.domain.Cenovnik;

/**
 *
 * @author Milos
 */
public interface CenovnikService {
     public Cenovnik getOne(int id);
    public List<Cenovnik> getAll();
    public Cenovnik saveCenovnik(Cenovnik cenovnik);
    public Cenovnik updateCenovnik(Cenovnik cenovnik);
    public void deleteCenovnik(String cenovnik);
}
