/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.service.impl;

import java.sql.Array;
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
import rs.ac.bg.is.fpis.domain.Cenovnik;
import rs.ac.bg.is.fpis.domain.Stavkacenovnika;
import rs.ac.bg.is.fpis.service.CenovnikService;

/**
 *
 * @author Milos
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class CenovnikServiceImpl implements CenovnikService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Cenovnik getOne(int id) {
        return entityManager.find(Cenovnik.class, id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Cenovnik> getAll() {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        }

        String query = "select c from Cenovnik c";
        return entityManager.createQuery(query, Cenovnik.class).getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Cenovnik saveCenovnik(Cenovnik cenovnik) { 
    
    List<Stavkacenovnika> copy = new ArrayList<>();
        copy.addAll(cenovnik.getStavke());
        cenovnik.setStavke(new ArrayList<Stavkacenovnika>());
      Cenovnik iks=  entityManager.merge(cenovnik);
        cenovnik.setSifracenovnika(iks.getSifracenovnika());
        cenovnik.setStavke(copy);
      System.out.println(iks+"\n\n\n\n");
       
  
    return entityManager.merge(cenovnik);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Cenovnik updateCenovnik(Cenovnik cenovnik) {
        Cenovnik iks= getOne(cenovnik.getSifracenovnika());
        iks.setDatum(cenovnik.getDatum());
        iks.setDrzava(cenovnik.getDrzava());
        iks.setRadnik(cenovnik.getRadnik());
        return entityManager.merge(cenovnik);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteCenovnik(String cenovnik) {
        String query="delete from StavkaCenovnika where sifracenovnika  LIKE '"+cenovnik+"'";
        String query1="delete from cenovnik where sifracenovnika LIKE '"+cenovnik+"'";
       Query q= entityManager.createNativeQuery(query);
        Query q2=entityManager.createNativeQuery(query1);
        q.executeUpdate();
        q2.executeUpdate();}
        

}
