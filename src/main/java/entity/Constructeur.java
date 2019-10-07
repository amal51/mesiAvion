package entity;

import javax.persistence.*;

@Entity
public class Constructeur {
    @Id //Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    @Column(updatable = false, nullable = false, name = "idConstructeur") // Pas modifiable, non null
    public long idConstructeur;
    @Column(nullable = false, length = 50)
    public String nomConstructeur;
    @Column(nullable = false, columnDefinition = "bool default true") // Valeur par défaut Vrai
    public boolean estActif;

    public long getIdConstructeur() {
        return idConstructeur;
    }

    public void setIdConstructeur(long idConstructeur) {
        this.idConstructeur = idConstructeur;
    }

    public String getNomConstructeur() {
        return nomConstructeur;
    }

    public void setNomConstructeur(String nomConstructeur) {
        this.nomConstructeur = nomConstructeur;
    }

    public boolean isEstActif() {
        return estActif;
    }

    public void setEstActif(boolean estActif) {
        this.estActif = estActif;
    }
}
