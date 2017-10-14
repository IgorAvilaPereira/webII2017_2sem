/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import model.Convidado;

/**
 *
 * @author iapereira
 */

@RequestScoped
public class ConvidadoDAO {
    
    public ArrayList<Convidado> listar() throws SQLException{
        ArrayList<Convidado> vetConvidado = new ArrayList();
        String sql = "select * from convidado;";
        Connection connection = new ConexaoPostgreSQL().getConexao();
        PreparedStatement sqlPreparedStatement = connection.prepareStatement(sql);
        ResultSet rs = sqlPreparedStatement.executeQuery();
        while (rs.next()){
            Convidado convidado = new Convidado();
            convidado.setId(rs.getInt("id"));
            convidado.setFantasia(rs.getString("fantasia"));
            convidado.setNome(rs.getString("nome"));
            vetConvidado.add(convidado);
        }
        sqlPreparedStatement.close();
        connection.close();        
        return vetConvidado;
    }

    public boolean excluir(int id) throws SQLException {
        String sql =  "DELETE FROM convidado WHERE id = ?";
        Connection connection = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int resultado = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return resultado == 1;       
    }

    public boolean adicionar(Convidado convidado) throws SQLException {
        
        String sql =  "INSERT INTO convidado (nome, fantasia) VALUES (?,?);";
        Connection connection = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, convidado.getNome());
        preparedStatement.setString(2, convidado.getFantasia());
        int resultado = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return resultado == 1; 
    }

    public Convidado obter(int id) throws SQLException {        
        String sql = "select * from convidado WHERE id = ?;";
        Connection connection = new ConexaoPostgreSQL().getConexao();
        PreparedStatement sqlPreparedStatement = connection.prepareStatement(sql);
        sqlPreparedStatement.setInt(1, id);
        ResultSet rs = sqlPreparedStatement.executeQuery();
        Convidado convidado = new Convidado();
        if(rs.next()){
            convidado.setId(rs.getInt("id"));
            convidado.setFantasia(rs.getString("fantasia"));
            convidado.setNome(rs.getString("nome"));
        }
        sqlPreparedStatement.close();
        connection.close();        
        return convidado;
    }

    public boolean editar(Convidado convidado) throws SQLException {       
        String sql =  "UPDATE convidado SET nome = ?, fantasia = ? WHERE id = ?;";
        Connection connection = new ConexaoPostgreSQL().getConexao();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, convidado.getNome());
        preparedStatement.setString(2, convidado.getFantasia());
        preparedStatement.setInt(3, convidado.getId());
        int resultado = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return resultado == 1; 
    }
}
