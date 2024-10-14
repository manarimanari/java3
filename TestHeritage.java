/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;

/**
 *
 * @author s
 */
public class TestHeritage {
   public static void main(String[] args) {
         TacheService tacheService = new TacheService();
         ProjetService projetService = new ProjetService();
         EmployeService es=new EmployeService();
        
         TacheService ts =new TacheService();
         
         tacheService.create(new Tache("lolo", new Date (2023,10,12),new Date (2023,10,24),es.findById(2),ts.findAll(),1300,projetService.findById(5)));
         
         
         for(Projet p : projetService.findAll())
             System.out.println(p.getId()+" "+p.getNom()+""+p.getDateDebut()+""+p.getDateFin()+""+es.findById(2)+""+ts.findAll());
    }
            
            
    
} 

