package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Requete {
    private Connection c;
    private Statement stmt;
    
    public Requete() {
        this.c = null;
        this.stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            this.c = DriverManager.getConnection("jdbc:sqlite:bdd.db");
            this.stmt = this.c.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Requete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet select(String query) {
        ResultSet result = null;
        try {
            result = this.stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Requete.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public void request(String query) {
        try {
            this.stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Requete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeDB() {
        try {
            this.stmt.close();
            this.c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Requete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}