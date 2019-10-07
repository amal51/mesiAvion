package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DetailsVols {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idDetailsVols;
    @ManyToOne
    @JoinColumn(name = "ARN")
    public Avion ARN;
    @ManyToOne
    @JoinColumn(name = "idVol")
    public Vol idVol;
    @Column(nullable = false)
    public Date dateDepart;
    @Column(nullable = false)
    public Date dateArrivee;
    @Column(nullable = false, columnDefinition = "bool default true")
    public boolean estActif;

    public long getIdDetailsVols() {
        return idDetailsVols;
    }

    public void setIdDetailsVols(long idDetailsVols) {
        this.idDetailsVols = idDetailsVols;
    }

    public Avion getARN() {
        return ARN;
    }

    public void setARN(Avion ARN) {
        this.ARN = ARN;
    }

    public Vol getIdVol() {
        return idVol;
    }

    public void setIdVol(Vol idVol) {
        this.idVol = idVol;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public boolean isEstActif() {
        return estActif;
    }

    public void setEstActif(boolean estActif) {
        this.estActif = estActif;
    }
}
