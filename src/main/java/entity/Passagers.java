package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Passagers {
    @Id
    @Column(nullable = false)
    public String numeroCNI;
    @Column(nullable = false, length = 100)
    public String nomPassager;
    @Column(nullable = false, length = 100)
    public String prenomPassager;
    @Column(nullable = false, length = 255)
    public String emailPassager;
    @Column(nullable = false, length = 1)
    public char genrePassager;
    @Column(nullable = false, length = 15)
    public String numeroTelephonePassager;
    @Column(length = 255)
    public String motDePassePassager;
    @Column(nullable = false)
    public Date dateNaissancePassager;
    @Column(nullable = false, columnDefinition = "bool default true") // Valeur par défaut Vrai
    public Boolean estActif;

    public String getNumeroCNI() {
        return numeroCNI;
    }

    public void setNumeroCNI(String numeroCNI) {
        this.numeroCNI = numeroCNI;
    }

    public String getNomPassager() {
        return nomPassager;
    }

    public void setNomPassager(String nomPassager) {
        this.nomPassager = nomPassager;
    }

    public String getPrenomPassager() {
        return prenomPassager;
    }

    public void setPrenomPassager(String prenomPassager) {
        this.prenomPassager = prenomPassager;
    }

    public String getEmailPassager() {
        return emailPassager;
    }

    public void setEmailPassager(String emailPassager) {
        this.emailPassager = emailPassager;
    }

    public char getGenrePassager() {
        return genrePassager;
    }

    public void setGenrePassager(char genrePassager) {
        this.genrePassager = genrePassager;
    }

    public String getNumeroTelephonePassager() {
        return numeroTelephonePassager;
    }

    public void setNumeroTelephonePassager(String numeroTelephonePassager) {
        this.numeroTelephonePassager = numeroTelephonePassager;
    }

    public String getMotDePassePassager() {
        return motDePassePassager;
    }

    public void setMotDePassePassager(String motDePassePassager) {
        this.motDePassePassager = motDePassePassager;
    }

    public Date getDateNaissancePassager() {
        return dateNaissancePassager;
    }

    public void setDateNaissancePassager(Date dateNaissancePassager) {
        this.dateNaissancePassager = dateNaissancePassager;
    }

    public Boolean getEstActif() {
        return estActif;
    }

    public void setEstActif(Boolean estActif) {
        this.estActif = estActif;
    }
}
