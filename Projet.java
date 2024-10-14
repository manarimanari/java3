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
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;

   
    private String nom;

   
    private Date dateDebut ;
   
    private Date dateFin;

    // Constructeurs, getters et setters
@ManyToOne
private Employe employe;
@OneToMany
        (mappedBy = "projet",fetch = FetchType.LAZY)
private List<Tache> taches;
    public Projet() {}

    public Projet(String nom, Date dateDebut, Date dateFin,Employe employe,List<Tache>taches ) {
        this.nom=nom;
        this.dateDebut= dateDebut;
        this.dateFin =dateFin;
       this.employe=employe;
       this.taches=taches;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
public String getNom() {
        return nom ;
    }

    public void setNom(String nom) {
        this.nom= nom;
    }
   
public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut ) {
        this.dateDebut = dateDebut;
    }
    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin ) {
        this.dateFin = dateFin;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }
    
    
}
