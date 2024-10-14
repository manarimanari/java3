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


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity

public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;

    
    private String nom;

    
   
    private String prenom;

    private String telephon;
@OneToMany
        (mappedBy = "employe",fetch = FetchType.LAZY)
private List<Projet>projets;
    // Constructeurs, getters et setters

    public Employe () {}

    public Employe (String nom, String prenom, String telephon,List<Projet>projets ) {
        this.nom=nom;
        
        this.prenom =prenom;
       this.telephon = telephon;
   this.projets=projets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom ) {
        this.nom = nom ;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom ) {
        this.prenom = prenom ;
    }
    public String getTelephon() {
        return telephon;
    }

    public void setTelephon(String telephon ) {
        this.telephon = telephon ;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
    
}

  



