/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.classes.Employe;
import ma.projet.classes.Tache;
import ma.projet.classes.EmployeTache;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;

/**
 *
 * @author s
 */
public class ManyToManyCompositeKey {
   public static void main(String[] args) {
       TacheService ts = new TacheService();
        EmployeService es = new EmployeService();
        EmployeTacheService ets = new EmployeTacheService();
        ProjetService ps=new ProjetService();
        ts.create(new Tache("lala", new Date(13,15,6), new Date(12,12,12),es.findById(3),ts.findAll(),100,ps.findById(3)));
        ts.create(new Tache("lolo", new Date(14,15,6), new Date(12,12,12),es.findById(1),ts.findAll(),200,ps.findById(6)));

        es.create(new Employe("lalo", "luna","02345678", ps.findAll()));
        es.create(new Employe("lili","asha","05345678",ps.findAll()));
        
       EmployeTache et = new EmployeTache (es.findById(1), ts.findById(1),new Date(10,12,19));
        et.setPk(new EmployeTachePK(1,2,new Date(10,12,19)));
        ets.create(et);
         
}}
