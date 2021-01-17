/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import rs.ac.bg.is.fpis.domain.Grad;
import rs.ac.bg.is.fpis.service.GradService;

/**
 *
 * @author Milos
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
public class GradServiceImpl implements GradService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Grad> getAll() {
        /* List<Grad> gradovi = new ArrayList<Grad>();
        try {
           
            String query = "SELECT * FROM GRAD ORDER BY naziv";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("postanskiBroj");
                Integer drzavaID = rs.getInt("sifraDrzave");
                String name = rs.getString("naziv");
               Grad grad= new Grad();
               grad.setDrzavaID(drzavaID);
               grad.setNazivGrada(name);
               grad.setPostanskiBroj(id);
            gradovi.add(grad);
              
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return gradovi;
         */ if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        }

        String query = "select g from Grad g";
        return entityManager.createQuery(query, Grad.class).getResultList();

    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Grad> getAllDrzava(int drzavaID) {
        /* List<Grad> gradovi = new ArrayList<Grad>();
        try {
           
            String query = "SELECT * FROM GRAD  where sifradrzave= "+drzavaID+" ORDER BY naziv";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("postanskiBroj");
                String name = rs.getString("naziv");
               Grad grad= new Grad();
               grad.setDrzavaID(drzavaID);
               grad.setNazivGrada(name);
               grad.setPostanskiBroj(id);
            gradovi.add(grad);
              
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return gradovi;
         */
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        }

        String query = "select g from Grad g where g.drzava=" + drzavaID;
        return entityManager.createQuery(query, Grad.class).getResultList();

    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Grad getOne(int postanskiBroj) {
        /*    Grad grad= new Grad();
        try {
           
            String query = "SELECT * FROM GRAD  where postanskibroj= "+postanskiBroj;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Integer drzavaID = rs.getInt("sifraDrzave");
                String name = rs.getString("naziv");
              
               grad.setDrzavaID(drzavaID);
               grad.setNazivGrada(name);
               grad.setPostanskiBroj(postanskiBroj);
           return grad;
              
            }
                rs.close();
            statement.close();
           

        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }

        return null;
         */
        return entityManager.find(Grad.class, postanskiBroj);
    }

}
