package example.sbproject;

import java.util.List;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;

@RestController
@RequestMapping(value="trabalho")
public class TrabalhoService {

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<List<TrabalhoBean>> get(){

        final String query = "SELECT * FROM Trabalho";
        List<TrabalhoBean> trabalhoList = new ArrayList<TrabalhoBean>();
        Connection con = null;
        final Statement stmt;
        final ResultSet rs;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Frameworks?useSSL=false","root","passwd");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                int percentual = rs.getInt(3);
                TrabalhoBean aux = new TrabalhoBean(id, nome, percentual);
                trabalhoList.add(aux);
            }
            return new ResponseEntity<List<TrabalhoBean>>(trabalhoList, HttpStatus.OK);
        }

        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<TrabalhoBean>>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<TrabalhoBean> post(@RequestBody TrabalhoBean aux){
        final String query = "INSERT INTO Trabalho (nome, percentual) VALUES('"+aux.getNome()+"', 0)";
        Connection con = null;
        final Statement stmt;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Frameworks?useSSL=false","root","passwd");
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            return new ResponseEntity<TrabalhoBean>(HttpStatus.OK);
        }

        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<TrabalhoBean>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/percentual/{vid}/{vpercentual}", method = RequestMethod.PUT)
    public ResponseEntity<TrabalhoBean> put(@PathVariable int vid, @PathVariable int vpercentual){
        final String query = "UPDATE Trabalho SET percentual = "+vpercentual+" WHERE id = "+vid;
        Connection con = null;
        final Statement stmt;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Frameworks?useSSL=false","root","passwd");
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            return new ResponseEntity<TrabalhoBean>(HttpStatus.OK);
        }

        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<TrabalhoBean>(HttpStatus.NOT_FOUND);
        }
    }
}
