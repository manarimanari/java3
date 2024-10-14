/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author s
 */





@Entity
public class Tache extends Projet {

    
    private double prix;
@ManyToOne
private Projet projet;
    
    // Constructeurs, getters et setters

    public Tache() {}

     public Tache(String nom, Date dateDebut, Date dateFin,Employe employe,List<Tache>taches,double prix, Projet projet ) {
        super("lala", new Date(13,15,6), new Date(12,12,12),employe,taches);
        this.prix=prix;
        this.projet=projet;
       
    }

    
    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    
  

   
}
