package entity;

import javax.persistence.*;

@Entity
public class Avion {
    @Id
    @Column(nullable = false, length = 10, name = "ARN")
    public String ARN;
    @ManyToOne
    @JoinColumn(name = "idModele")
    public ModeleAvion modeleAvion;
    @Column(nullable = false, columnDefinition = "bool default true")
    public boolean estEnMaintenance;
    @Column(nullable = false, columnDefinition = "bool default true")
    public boolean estActif;

    public String getARN() {
        return ARN;
    }

    public void setARN(String ARN) {
        this.ARN = ARN;
    }

    public entity.ModeleAvion getModeleAvion() {
        return modeleAvion;
    }

    public void setModeleAvion(entity.ModeleAvion modeleAvion) {
        this.modeleAvion = modeleAvion;
    }

    public boolean isEstEnMaintenance() {
        return estEnMaintenance;
    }

    public void setEstEnMaintenance(boolean estEnMaintenance) {
        this.estEnMaintenance = estEnMaintenance;
    }

    public boolean isEstActif() {
        return estActif;
    }

    public void setEstActif(boolean estActif) {
        this.estActif = estActif;
    }
}
