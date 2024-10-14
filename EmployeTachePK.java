/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;

/**
 *
 * @author s
 */
@Embeddable
public class EmployeTachePK implements Serializable{
    private int employe;
    private int tache;
   private Date dateDebutReele;
    
    public  EmployeTachePK (){}

    public EmployeTachePK(int employe, int tache, Date dateDebutReele) {
        this.employe = employe;
        this.tache = tache;
        this.dateDebutReele = dateDebutReele;
    }

    public int getEmploye() {
        return employe;
    }

    public void setEmploye(int employe) {
        this.employe = employe;
    }

    public int getTache() {
        return tache;
    }

    public void setTache(int tache) {
        this.tache = tache;
    }

    public Date getDateDebutReele() {
        return dateDebutReele;
    }

    public void setDateDebutReele(Date dateDebutReele) {
        this.dateDebutReele = dateDebutReele;
    }
    
}
