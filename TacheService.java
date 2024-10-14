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

import java.util.Date;
import ma.projet.dao.IDao;
import java.util.List;
import ma.projet.classes.Tache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.util.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author a
 */
public class TacheService implements IDao<Tache> {

    @Override
    public boolean create(Tache o) {
        Session session ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
       
    }

    

    

    @Override
    public Tache findById(int id) {
        Session session ;
        Tache e  ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Tache) session.get(Tache.class, id);
            session.getTransaction().commit();
            return e;
        }

    @Override
    public List<Tache> findAll() {
        Session session ;
        List<Tache>  taches ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            taches = session.createQuery("from Tache").list();
            session.getTransaction().commit();
            return taches;
        
    }
public List<Tache> afficherTachesParPrixSuperieur(double prixmin) {
    Session session ;
    List<Tache> taches = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Exécuter la requête nommée pour récupérer les tâches dont le prix est supérieur à 1000 DH
        Query query = session.getNamedQuery(" FROM Tache T WHERE where T.prix > :prixMin ");
                
                          query.setParameter("prix", prixmin);
                        List results = query.list();

        session.getTransaction().commit();

        
    
    return taches;  // Retourner la liste des tâches trouvées
}
public List<Tache> afficherTachesRealiseesEntreDates(Date dateDebut, Date dateFin) {
    Session session ;
    List<Tache> taches = null;
    
    
        // Ouverture de la session
        session = HibernateUtil.getSessionFactory().openSession(); 
        session.beginTransaction();

        // Requête SQL pour récupérer les tâches réalisées entre deux dates
        String hql = " FROM Tache T WHERE T.date_fin_reelle BETWEEN :dateDebut AND :dateFin";

        // Exécution de la requête
       Query query = session.createSQLQuery(hql);
                              
                            query.setParameter("dateDebut", dateDebut);
                            query.setParameter("dateFin", dateFin).list();
                             List results = query.list();
        
        // Validation de la transaction
        session.getTransaction().commit();
   

    return taches;
}

}   

 

