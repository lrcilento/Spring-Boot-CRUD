package example.sbproject;

import java.util.List;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;

@RestController
@RequestMapping(value="aluno")
public class AlunoService {

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<List<AlunoBean>> get(){

        final String query = "SELECT * FROM Aluno";
        List<AlunoBean> alunoList = new ArrayList<AlunoBean>();
        Connection con = null;
        final Statement stmt;
        final ResultSet rs;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Frameworks?useSSL=false","root","passwd");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String nome = rs.getString(1);
                AlunoBean aux = new AlunoBean(nome);
                alunoList.add(aux);
            }
            return new ResponseEntity<List<AlunoBean>>(alunoList, HttpStatus.OK);
        }

        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<AlunoBean>>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<AlunoBean> post(@RequestBody AlunoBean aux){
        final String query = "INSERT INTO Aluno (nome) VALUES('"+aux.getNome()+"')";
        Connection con = null;
        final Statement stmt;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Frameworks?useSSL=false","root","passwd");
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            return new ResponseEntity<AlunoBean>(HttpStatus.OK);
        }

        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<AlunoBean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
