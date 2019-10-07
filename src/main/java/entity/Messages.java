package entity;

import javax.persistence.*;

@Entity
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    public long idMessage;
    @ManyToOne
    @JoinColumn(name = "idLangue")
    public Langues idLangue;
    public String message;

    public long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(long idMessage) {
        this.idMessage = idMessage;
    }

    public Langues getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(Langues idLangue) {
        this.idLangue = idLangue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
