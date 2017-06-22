/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author iapereira
 */
public class Conexao {

    private String host;
    private String dbname;
    private String user;
    private String port;
    private String password;

    public Conexao() {
        this.host = "localhost";
        this.port = "5432";
        this.user = "postgres";
        this.password = "ricardo";
        this.dbname = "revenda";
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://" + this.host + ":" + this.port + "/" + this.dbname;
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, this.user, this.password);
    }

}
