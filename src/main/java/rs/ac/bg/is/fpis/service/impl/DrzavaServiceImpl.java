/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import rs.ac.bg.is.fpis.domain.Drzava;
import rs.ac.bg.is.fpis.service.DrzavaService;

/**
 *
 * @author Milos
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
public class DrzavaServiceImpl implements DrzavaService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Drzava> getAll() {
        /* List<Drzava> drzave = new ArrayList<Drzava>();
        try {
           
            String query = "SELECT * FROM drzava ORDER BY naziv";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
              
                Integer drzavaID = rs.getInt("sifraDrzave");
                String name = rs.getString("naziv");
              // Drzava drzava= new Drzava(drzavaID, name);
        //    drzave.add(drzava);
              
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return drzave;*/

        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        }
        String query = "select d from Drzava d order by d.naziv";
        return entityManager.createNamedQuery("Drzava.findAll").getResultList();
        //return entityManager.createQuery("from drzava", Drzava.class).getResultList();

    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Drzava getOne(int id) {
        /* try {
           
            String query = "SELECT * FROM drzava  where sifradrzave= "+id;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
               
                String name = rs.getString("naziv");
                
               
           return new Drzava(1, "1", null);
              
            }
                rs.close();
            statement.close();
           

        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }

        return null;*/
        return entityManager.find(Drzava.class, id);
    }

}
