/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.service;

import java.util.List;
import rs.ac.bg.is.fpis.domain.Drzava;

/**
 *
 * @author Milos
 */
public interface DrzavaService {
    public List<Drzava> getAll();
  public Drzava getOne(int id);
}
