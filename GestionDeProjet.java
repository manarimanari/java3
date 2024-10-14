/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;

/**
 *
 * @author s
 */
public class GestionDeProjet {
  
    public static void main(String[] args) {
        EmployeService employeService = new EmployeService();
         ProjetService projetService = new ProjetService();
         TacheService tacheService = new TacheService();
         EmployeTacheService ets = new EmployeTacheService();
         
         
        employeService.create(new Employe ("dodo","didi","00012345", projetService.findAll()));
        projetService.create(new Projet ("lila", new Date(14,15,6), new Date(12,12,12),employeService.findById(1),tacheService.findAll()));
        tacheService.create(new Tache ("lala", new Date(13,15,6), new Date(12,12,12),employeService.findById(3),tacheService.findAll(),100,projetService.findById(3)));
        ets.create(new  EmployeTache (employeService.findById(2),tacheService.findById(3),new Date(2023,11,02)));
        
        // Test 1 : Afficher les tâches réalisées par un employé
        employeService.afficherTachesRealisees(1); // ID de l'employé à tester

        // Test 2 : Afficher les projets gérés par un employé
        employeService.afficherProjetsGeres(1); // ID de l'employé à tester

        // Test 3 : Afficher les tâches planifiées pour un projet
        projetService.afficherTachesPlanifiees(4); // ID du projet à tester

        // Test 4 : Afficher les tâches réalisées dans un projet
        projetService.afficherTachesRealiseesDansProjet(4); // ID du projet à tester

        // Test 5 : Afficher les tâches dont le prix est supérieur à 1000 DH
        tacheService.afficherTachesParPrixSuperieur(1000);

        // Test 6 : Afficher les tâches réalisées entre deux dates
        tacheService.afficherTachesRealiseesEntreDates(new Date(2023,12,01), new Date(2023,12,31));
    }
}


