/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import ma.projet.classes.EmployeTache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ma.projet.util.HibernateUtil;

/**
 *
 * @author a
 */
public class EmployeTacheService implements IDao<EmployeTache> {

    @Override
    public boolean create(EmployeTache o) {
        Session session ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        
    }

    
    

    @Override
    public EmployeTache findById(int id) {
        Session session ;
        EmployeTache e  ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (EmployeTache) session.get(EmployeTache.class, id);
            session.getTransaction().commit();
            return e;
        
    }

    @Override
    public List<EmployeTache> findAll() {
        Session session ;
        List<EmployeTache>  employestaches ;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            employestaches = session.createQuery("from EmployeTache").list();
            session.getTransaction().commit();
            return employestaches;
        

}   }

   

