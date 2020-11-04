package example.sbproject;

import java.util.List;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;

@RestController
@RequestMapping(value="alocacao")
public class AlocacaoService {

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<List<AlocacaoBean>> get(){

        final String query = "SELECT * FROM Alocacao";
        List<AlocacaoBean> alunoList = new ArrayList<AlocacaoBean>();
        Connection con = null;
        final Statement stmt;
        final ResultSet rs;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Frameworks?useSSL=false","root","passwd");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                int idTrabalho = rs.getInt(2);
                String username = rs.getString(3);
                AlocacaoBean aux = new AlocacaoBean(id, idTrabalho, username);
                alunoList.add(aux);
            }
            return new ResponseEntity<List<AlocacaoBean>>(alunoList, HttpStatus.OK);
        }

        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<AlocacaoBean>>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{idTrabalho}/{username}", method = RequestMethod.PUT)
    public ResponseEntity<AlocacaoBean> put(@PathVariable int idTrabalho, @PathVariable String username){
        final String query = "INSERT INTO Alocacao (idTrabalho, username) VALUES("+idTrabalho+", '"+username+"')";
        Connection con = null;
        final Statement stmt;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Frameworks?useSSL=false","root","passwd");
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            return new ResponseEntity<AlocacaoBean>(HttpStatus.OK);
        }

        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<AlocacaoBean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
