/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

/**
 *
 * @author s
 */

/**
 *
 * @author s
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ma.projet.dao.IDao;
import java.util.List;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.util.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author a
 */
public class ProjetService implements IDao<Projet> {

    @Override
    public boolean create(Projet o) {
        Session session ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        
    }

   
    @Override
    public Projet findById(int id) {
        Session session ;
        Projet e  ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Projet) session.get(Projet.class, id);
            session.getTransaction().commit();
            return e;
        
    }

    @Override
    public List<Projet> findAll() {
        Session session ;
        List<Projet>  projetsservices ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            projetsservices = session.createQuery("from Projet").list();
            session.getTransaction().commit();
            return projetsservices;
        
    }
public List<Tache> afficherTachesPlanifiees(int projetId) {
    Session session ;
    List<Tache> taches = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Requête SQL native pour sélectionner les tâches liées à un projet
        Query query = session.createSQLQuery("FROM Tache T WHERE T.projet_id = :projetId");
                        query.setParameter("projetId", projetId);  // Liaison du paramètre
                       List results = query.list();

        session.getTransaction().commit();  // Valider la transaction
    
    return taches;  // Retourner la liste des tâches
}
public List<Tache> afficherTachesRealiseesDansProjet(int projetId) {
    Session session ;
    Projet projet = null;
    List<Tache> taches = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Requête SQL pour récupérer le projet
        Query query =  session.createSQLQuery("SELECT * FROM Projet WHERE id = :projetId");
                               query .setParameter("projetId", projetId);
                                 List results = query .list();

        // Requête SQL pour récupérer les tâches réalisées associées au projet
      Query query1 = session.createSQLQuery("FROM Tache T WHERE T.projet_id = :projetId AND statut = 'réalisée'");
                        query1 .setParameter("projetId", projetId);
                      List results1 = query .list();

        session.getTransaction().commit();

        // Vérification si le projet est trouvé et affichage des informations du projet
        if (projet != null) {
            System.out.println("Projet : " + projet.getId());
            System.out.println("Nom : " + projet.getNom());
            System.out.println("Date début : " + projet.getDateDebut());
        }

        // Vérification et affichage des tâches réalisées
        if (taches != null && !taches.isEmpty()) {
            System.out.println("Liste des tâches réalisées :");
            System.out.println("Num\tNom\t\tDate Début Réelle\tDate Fin Réelle");
            for (Tache tache : taches) {
                System.out.println(tache.getId() + "\t" + tache.getNom() + "\t" +
                                   tache.getDateDebut() + "\t" +
                                   tache.getDateFin());
            }
        } else {
            System.out.println("Aucune tâche réalisée pour ce projet.");
        }
    

    return taches;  // Retourner la liste des tâches réalisées
}

}   



