package database;

import model.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CarroDAO {

    public ArrayList<Carro> listar() throws ClassNotFoundException, SQLException, SQLException {
        ArrayList<Carro> vetCarro = new ArrayList();
        Connection connection = new Conexao().getConnection();
        String sql = "SELECT * FROM carros";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Carro carro = new Carro();
            carro.setModelo(rs.getString("modelo"));
            carro.setMarca(rs.getString("marca"));
            carro.setAno(rs.getInt("ano"));
            carro.setValor(rs.getDouble("valor"));
            carro.setImagem(rs.getString("imagem"));
            carro.setId(rs.getInt("id"));
            vetCarro.add(carro);
        }
        preparedStatement.close();
        connection.close();
        return vetCarro;
    }

    public void excluir(int id) throws ClassNotFoundException, SQLException {
        try (Connection connection = new Conexao().getConnection()) {
            String sql = "DELETE FROM carros WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            }
        }
    }

    public void inserir(Carro carro) throws ClassNotFoundException, SQLException {
        try (Connection connection = new Conexao().getConnection()) {
            String sql = "INSERT INTO carros (modelo, marca, ano, valor) values (?,?,?,?) RETURNING id;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, carro.getModelo());
                preparedStatement.setString(2, carro.getMarca());
                preparedStatement.setDouble(3, carro.getAno());
                preparedStatement.setDouble(4, carro.getValor());
                ResultSet rs  = preparedStatement.executeQuery();
                if (rs.next()){
                    carro.setId(rs.getInt("id"));
                }
            }
        } catch (Exception e) {
            System.out.println("Ops....");
        }
        
    }

    public Carro obter(int id) throws ClassNotFoundException, SQLException {
        Carro carro = new Carro();
        try (Connection connection = new Conexao().getConnection()) {
            String sql = "SELECT * FROM carros WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    carro.setModelo(rs.getString("modelo"));
                    carro.setMarca(rs.getString("marca"));
                    carro.setAno(rs.getInt("ano"));
                    carro.setValor(rs.getDouble("valor"));
                    carro.setImagem(rs.getString("imagem"));
                    carro.setId(rs.getInt("id"));
                }
            }
        }
        return carro;
    }

    public void alterar(Carro carro) {
        try (Connection connection = new Conexao().getConnection()) {
            String sql = "UPDATE carros SET modelo = ?, marca = ?, ano = ?, valor = ?, imagem = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carro.getModelo());
            preparedStatement.setString(2, carro.getMarca());
            preparedStatement.setInt(3, carro.getAno());
            preparedStatement.setDouble(4, carro.getValor());
            preparedStatement.setString(5, carro.getImagem());
            preparedStatement.setInt(6, carro.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Ops....");
        }
    }
}