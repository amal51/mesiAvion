package entity;

import javax.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "idReservation")
    public long idReservation;
    @ManyToOne
    @JoinColumn(name = "idPassager")
    public Passagers idPassager;
    @ManyToOne
    @JoinColumn(name = "idDetailsVols")
    public DetailsVols idDetailsVols;
    @Column(nullable = false, length = 1)
    public char classe;
    @Column(nullable = false, columnDefinition = "bool default true")
    public boolean estActif;

    public long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(long idReservation) {
        this.idReservation = idReservation;
    }

    public Passagers getIdPassager() {
        return idPassager;
    }

    public void setIdPassager(Passagers idPassager) {
        this.idPassager = idPassager;
    }

    public DetailsVols getIdDetailsVols() {
        return idDetailsVols;
    }

    public void setIdDetailsVols(DetailsVols idDetailsVols) {
        this.idDetailsVols = idDetailsVols;
    }

    public char getClasse() {
        return classe;
    }

    public void setClasse(char classe) {
        this.classe = classe;
    }

    public boolean isEstActif() {
        return estActif;
    }

    public void setEstActif(boolean estActif) {
        this.estActif = estActif;
    }
}
