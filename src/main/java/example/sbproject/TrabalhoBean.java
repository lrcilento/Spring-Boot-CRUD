package example.sbproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Trabalho")

public class TrabalhoBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;

    private int percentual;

    public TrabalhoBean() {
    }

    public TrabalhoBean(int id, String nome, int percentual) {
        this.id = id;
        this.nome = nome;
        this.percentual = percentual;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPercentual() {
        return this.percentual;
    }

    public void setPercentual(int percentual) {
        this.percentual = percentual;
    }

    public TrabalhoBean id(int id) {
        this.id = id;
        return this;
    }

    public TrabalhoBean nome(String nome) {
        this.nome = nome;
        return this;
    }

    public TrabalhoBean percentual(int percentual) {
        this.percentual = percentual;
        return this;
    }

}