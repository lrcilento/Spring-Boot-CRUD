package example.sbproject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Aluno")
public class AlunoBean {

    @Id
    private String nome;

    public AlunoBean() {
    }

    public AlunoBean(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
