/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ma.projet.dao.IDao;
import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import org.hibernate.Session;
import ma.projet.util.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author a
 */
public class EmployeService implements IDao<Employe> {

    @Override
    public boolean create(Employe o) {
        Session session ;
       
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        
    }

    

    @Override
    public Employe findById(int id) {
        Session session ;
        Employe e  ;
        
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Employe) session.get(Employe.class, id);
            session.getTransaction().commit();
            return e;
       
    }

    @Override
    public List<Employe> findAll() {
        Session session ;
        List<Employe>  employes ;
        
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            employes = session.createQuery("from Employe").list();
            session.getTransaction().commit();
            return employes;
        
    }
public List<Tache> afficherTachesRealisees(int employeId) {
    Session session ;
    List<Tache> taches=null ;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Requête SQL native pour sélectionner les tâches liées à un employé
       Query query = session.createSQLQuery("FROM Tache t WHERE t.employe_id = :employeId");
                       query .setParameter("employeId", employeId);  // Liaison du paramètre employeId
                        List results= query.list();

        session.getTransaction().commit();  // Valider la transaction
    
    
    return taches;  // Retourner la liste des tâches
}

    
public List<Projet> afficherProjetsGeres(int employeId) {
    Session session ;
    List<Projet> projets=null ;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Requête SQL native pour sélectionner les projets gérés par un employé
        Query query = session.createSQLQuery(" FROM Projet P WHERE P.employe_id = :employeId");
                         query.setParameter("employeId", employeId);  // Liaison du paramètre employeId
                        List results = query.list();

        session.getTransaction().commit();  // Valider la transaction
   
    return projets;  // Retourner la liste des projets
}

}   

   

