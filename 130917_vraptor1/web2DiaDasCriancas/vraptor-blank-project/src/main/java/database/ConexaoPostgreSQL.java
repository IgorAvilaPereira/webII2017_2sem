/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jboss.weld.environment.servlet.util.Reflections;

/**
 *
 * @author iapereira
 */
public class ConexaoPostgreSQL {
    private String host;
    private String port;
    private String dbname;
    private String password;
    private String user;
    
    public ConexaoPostgreSQL(){
        this.host = "localhost";
        this.port = "5432";
        this.dbname = "sexta";
        this.password = "postgres";
        this.user = "postgres";        
    }
    
    public Connection getConexao() throws SQLException{
        String url = "jdbc:postgresql://"+this.host+":"+this.port+"/"+this.dbname;
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("----------------------------");
            System.out.println("xabum...");
            System.out.println("-----------------------------");
            Logger.getLogger(ConexaoPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
