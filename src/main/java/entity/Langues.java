package entity;

import javax.persistence.*;

@Entity
public class Langues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, name = "idLangue")
    public long idLangue;
    @Column(nullable = false, length = 50)
    public String nomLangue;

    public long getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(long idLangue) {
        this.idLangue = idLangue;
    }

    public String getNomLangue() {
        return nomLangue;
    }

    public void setNomLangue(String nomLangue) {
        this.nomLangue = nomLangue;
    }
}
