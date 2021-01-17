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
import rs.ac.bg.is.fpis.domain.Spediter;
import rs.ac.bg.is.fpis.service.SpediterService;

/**
 *
 * @author Milos
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
public class SpediterServiceImpl implements SpediterService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    public Spediter getOne(int id) {
        /* try {

            String query = "SELECT * FROM spediter  where sifraspeditera= " + id;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Integer postanskiBroj = rs.getInt("postanskiBroj");
                String brojTelefona = rs.getString("brojTelefona");
                String email = rs.getString("email");
                String fax = rs.getString("fax");
                String naziv = rs.getString("naziv");
                Spediter spediter = new Spediter();
                spediter.setGradid(postanskiBroj);
                spediter.setEmail(email);
                spediter.setFax(fax);
                spediter.setBrojTelefona(brojTelefona);
                spediter.setSifraSpeditera(id);
                spediter.setNaziv(naziv);
                return spediter;

            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return null;*/
        return entityManager.find(Spediter.class, id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Spediter> getAll() {
        /*   List<Spediter> spediteri = new ArrayList<Spediter>();
        try {

            String query = "SELECT * FROM spediter ";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("sifraSpeditera");
                Integer postanskiBroj = rs.getInt("postanskiBroj");
                String brojTelefona = rs.getString("brojTelefona");
                String email = rs.getString("email");
                String naziv = rs.getString("naziv");
                String fax = rs.getString("fax");
                Spediter spediter = new Spediter();
                spediter.setGradid(postanskiBroj);
                spediter.setEmail(email);
                spediter.setFax(fax);
                spediter.setBrojTelefona(brojTelefona);
                spediter.setSifraSpeditera(id);
                spediter.setNaziv(naziv);
                spediteri.add(spediter);

            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return spediteri;*/
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        }

        String query = "select s from Spediter s";
        return entityManager.createQuery(query, Spediter.class).getResultList();

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Spediter saveSpediter(Spediter spediter) {
        /*
        if (spediter == null) {
            return null;
        }
        try {

            String query = "insert into spediter(postanskiBroj,naziv,email,fax,brojTelefona) values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, spediter.getGradid());
            preparedStatement.setString(2, spediter.getNaziv());
            preparedStatement.setString(3, spediter.getEmail());
            preparedStatement.setString(4, spediter.getFax());
            preparedStatement.setString(5, spediter.getBrojTelefona());

            int count = preparedStatement.executeUpdate();

            if (count > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    spediter.setSifraSpeditera(rs.getInt(1));

                } else {
                    connection.rollback();
                    return null;
                }

                connection.commit();
                preparedStatement.close();
                return spediter;

            } else {
                connection.rollback();

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return null;*/
        return entityManager.merge(spediter);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Spediter updateSpediter(Spediter spediter) {
        /*    if (spediter == null) {
            return null;
        }
        try {

            String query = "update spediter set postanskiBroj=?,naziv=?,email=?,fax=?,brojTelefona=? where sifraspeditera=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, spediter.getGradid());
            preparedStatement.setString(2, spediter.getNaziv());
            preparedStatement.setString(3, spediter.getEmail());
            preparedStatement.setString(4, spediter.getFax());
            preparedStatement.setString(5, spediter.getBrojTelefona());
            preparedStatement.setInt(6, spediter.getSifraSpeditera());
            int count = preparedStatement.executeUpdate();

            if (count < 0) {
                connection.rollback();
                return null;
            }

            connection.commit();
            preparedStatement.close();
            return spediter;

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        return null;*/
        return entityManager.merge(spediter);

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteSpediter(int spediter) {

        /* try {

            String query = "delete from spediter where sifraspeditera=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, spediter);

            int count = preparedStatement.executeUpdate();

            if (count < 0) {
                connection.rollback();
                return;
            }

            connection.commit();
            preparedStatement.close();
            return;

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
         */
        
        entityManager.remove(getOne(spediter));
    }

}
