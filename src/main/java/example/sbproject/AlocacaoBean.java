package example.sbproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Alocacao")
public class AlocacaoBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int idTrabalho;

    private String username;


    public AlocacaoBean() {
    }

    public AlocacaoBean(int id, int idTrabalho, String username) {
        this.id = id;
        this.idTrabalho = idTrabalho;
        this.username = username;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTrabalho() {
        return this.idTrabalho;
    }

    public void setIdTrabalho(int idTrabalho) {
        this.idTrabalho = idTrabalho;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AlocacaoBean id(int id) {
        this.id = id;
        return this;
    }

    public AlocacaoBean idTrabalho(int idTrabalho) {
        this.idTrabalho = idTrabalho;
        return this;
    }

    public AlocacaoBean username(String username) {
        this.username = username;
        return this;
    }

}
