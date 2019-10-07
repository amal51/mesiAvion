package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ModeleAvion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    public long idModele;
    @ManyToOne
    @JoinColumn(name = "idConstructeur")
    public Constructeur constructeur;
    @Column(nullable = false, length = 50)
    public String nomAvion;
    @Column(nullable = false, columnDefinition = "bool default true")
    public boolean estActif;
    @Column(nullable = false, columnDefinition = "int default 0")
    public int nombrePlaceAffaire;
    @Column(nullable = false, columnDefinition = "int default 0")
    public int nombrePlaceEco;

    @OneToMany
    public List<Avion> avion;

    public long getIdModele() {
        return idModele;
    }

    public void setIdModele(long idModele) {
        this.idModele = idModele;
    }

    public Constructeur getConstructeur() {
        return constructeur;
    }

    public void setConstructeur(Constructeur constructeur) {
        this.constructeur = constructeur;
    }

    public String getNomAvion() {
        return nomAvion;
    }

    public void setNomAvion(String nomAvion) {
        this.nomAvion = nomAvion;
    }

    public boolean isEstActif() {
        return estActif;
    }

    public void setEstActif(boolean estActif) {
        this.estActif = estActif;
    }

    public int getNombrePlaceAffaire() {
        return nombrePlaceAffaire;
    }

    public void setNombrePlaceAffaire(int nombrePlaceAffaire) {
        this.nombrePlaceAffaire = nombrePlaceAffaire;
    }

    public int getNombrePlaceEco() {
        return nombrePlaceEco;
    }

    public void setNombrePlaceEco(int nombrePlaceEco) {
        this.nombrePlaceEco = nombrePlaceEco;
    }

    public List<Avion> getAvion() {
        return avion;
    }

    public void setAvion(List<Avion> avion) {
        this.avion = avion;
    }
}
