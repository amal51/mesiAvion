package entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Vol {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false, updatable = false)
    public long idVol;
    @Column(nullable = false, length = 100)
    public String villeDepartVol;
    @Column(nullable = false, length = 100)
    public String villeArriveeVol;
    @Column(nullable = false, columnDefinition = "bool default true")
    public Boolean estActif;

    public long getIdVol() {
        return idVol;
    }

    public void setIdVol(long idVol) {
        this.idVol = idVol;
    }

    public String getVilleDepartVol() {
        return villeDepartVol;
    }

    public void setVilleDepartVol(String villeDepartVol) {
        this.villeDepartVol = villeDepartVol;
    }

    public String getVilleArriveeVol() {
        return villeArriveeVol;
    }

    public void setVilleArriveeVol(String villeArriveeVol) {
        this.villeArriveeVol = villeArriveeVol;
    }

    public Boolean getEstActif() {
        return estActif;
    }

    public void setEstActif(Boolean estActif) {
        this.estActif = estActif;
    }
}
