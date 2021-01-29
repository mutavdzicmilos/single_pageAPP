/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.is.fpis.controller;

import rs.ac.bg.is.fpis.domain.Radnik;
import rs.ac.bg.is.fpis.domain.Drzava;
import rs.ac.bg.is.fpis.domain.Grad;
import rs.ac.bg.is.fpis.domain.Spediter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.is.fpis.domain.*;
import rs.ac.bg.is.fpis.service.*;

/**
 *
 * @author Milos
 */
@RestController
@RequestMapping("/api")
public class Rest {

    DrzavaService drzavaService;
    GradService gradService;
    SpediterService spediterService;
    RadnikService radnikService;
    CenovnikService cenovnikService;
    ProizvodService proizvodService;

    @Autowired
    public Rest(DrzavaService drzavaService, GradService gradService, SpediterService spediterService, RadnikService radnikService, CenovnikService cenovnikService, ProizvodService proizvodService) {
        this.drzavaService = drzavaService;
        this.gradService = gradService;
        this.spediterService = spediterService;
        this.radnikService = radnikService;
        this.cenovnikService = cenovnikService;
        this.proizvodService = proizvodService;
    }

    @GetMapping(value = "/drzave/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Drzava> getAllDrzava() {
       // System.out.println("tu sam");
        return drzavaService.getAll();
    }

    @GetMapping(value = "/drzave/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Drzava getOneDrzava(@PathVariable int id) {
        return drzavaService.getOne(id);
    }

    @GetMapping(value = "/gradovi/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Grad> getAllGradovi() {
        return gradService.getAll();
    }

    @GetMapping(value = "/gradovi/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Grad getOneGrad(@PathVariable int id) {
        return gradService.getOne(id);
    }

    @GetMapping(value = "/gradovi/drzava/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Grad> getAllGradDrzava(@PathVariable int id) {
        return gradService.getAllDrzava(id);
    }

    @GetMapping(value = "/spediteri/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Spediter> getAllSpediter() {
        return spediterService.getAll();
    }

    @GetMapping(value = "/spediteri/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Spediter getOneSpediter(@PathVariable int id) {
        return spediterService.getOne(id);
    }
    
    @PostMapping(value = "/spediteri/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = "application/json")
     public Spediter saveSpediter(@RequestBody Spediter spediter) {
         spediter.setGrad(gradService.getOne(spediter.getGrad().getPostanskiBroj()));
        return spediterService.saveSpediter(spediter);
    }

    @DeleteMapping(value = "/spediteri/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeSpediter(@PathVariable int id) {
        spediterService.deleteSpediter(id);
    }

    @GetMapping(value = "/radnik/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Radnik getOneRadnik(@PathVariable String id) {
        return radnikService.getOne(id);
    }

    @GetMapping(value = "/cenovnik/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Cenovnik> getAllCenovnik() {
        return cenovnikService.getAll();
    }

    @GetMapping(value = "/cenovnik/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cenovnik getOneCenovnik(@PathVariable int id) {
        return cenovnikService.getOne(id);
    }

     @PostMapping(value = "/cenovnik/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = "application/json")
    public Cenovnik saveSpediter(@RequestBody Cenovnik cenovnik) {
        return cenovnikService.saveCenovnik(cenovnik);
    }
     @PostMapping(value = "/cenovnik/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = "application/json")
    public Cenovnik updCenovnik(@RequestBody Cenovnik cenovnik) {
        return cenovnikService.updateCenovnik(cenovnik);
    }

    @DeleteMapping(value = "/cenovnik/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeCenovnik(@PathVariable String id) {
      cenovnikService.deleteCenovnik(id);
    }
    @GetMapping(value = "/proizvod/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Proizvod getOneProizvod(@PathVariable String id) {
        return proizvodService.getOne(id);
    }
}
