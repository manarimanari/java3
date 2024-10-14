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
package ma.projet.classes;

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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import ma.projet.test.EmployeTachePK;



@Entity
public class EmployeTache {

    @EmbeddedId
    private EmployeTachePK pk;
    @ManyToOne
        @JoinColumn(name = "employe",insertable=false,updatable= false)
private Employe employe;
    @ManyToOne
        @JoinColumn(name = "tache",insertable=false,updatable= false)
private Tache tache;
    private Date dateFinReelle;

    // Constructeurs, getters et setters

    public EmployeTache() {}

    public EmployeTache(Employe employe, Tache tache, Date dateFinReelle) {
        this.employe = employe;
        this.tache = tache;
        this.dateFinReelle = dateFinReelle;
    }

    public EmployeTachePK getPk() {
        return pk;
    }

    public void setPk(EmployeTachePK pk) {
        this.pk = pk;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    
}
   

