/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.service;

import java.util.List;
import rs.ac.bg.is.fpis.domain.Spediter;

/**
 *
 * @author Milos
 */
public interface SpediterService {
    public Spediter getOne(int id);
    public List<Spediter> getAll();
    public Spediter saveSpediter(Spediter spediter);
    public Spediter updateSpediter(Spediter spediter);
    public void deleteSpediter(int spediter);
}
