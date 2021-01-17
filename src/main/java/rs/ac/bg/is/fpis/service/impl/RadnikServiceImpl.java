/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.is.fpis.domain.Radnik;
import rs.ac.bg.is.fpis.service.RadnikService;

/**
 *
 * @author Milos
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
public class RadnikServiceImpl implements RadnikService {
 @PersistenceContext
    EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Radnik getOne(String sifra) {
       /* Radnik r = new Radnik();
        try {

            String query = "SELECT * FROM radnik  where sifraradnika like '" + sifra + "'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                r.setSifraRadnika(sifra);

                String name = rs.getString("imePrezime");
                r.setImePrezime(name);
                String email = rs.getString("email");
                r.setEmail(email);
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return r;*/
       return entityManager.find(Radnik.class, sifra);
    }

}
