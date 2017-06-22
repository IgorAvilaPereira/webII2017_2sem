package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import model.Usuario;

@RequestScoped
public class UsuarioDAO {

    public void inserir(Usuario usuario) throws ClassNotFoundException, SQLException {
        try (Connection connection = new Conexao().getConnection()) {
            String sql = "INSERT INTO usuarios (login, senha) values (?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Ops....");
        }
    }

    public void excluir(int id) throws ClassNotFoundException, SQLException {
        Connection connection = new Conexao().getConnection();
        String sql = "DELETE FROM usuarios WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public ArrayList<Usuario> listar() throws ClassNotFoundException, SQLException, SQLException {
        ArrayList<Usuario> listUser = new ArrayList();
        Connection connection = new Conexao().getConnection();
        String sql = "SELECT * FROM usuarios";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setId(rs.getInt("id"));
            listUser.add(usuario);
        }
        preparedStatement.close();
        connection.close();
        return listUser;
    }

    public Usuario obter(int id) throws ClassNotFoundException, SQLException {
        Usuario usuario = new Usuario();
        try (Connection connection = new Conexao().getConnection()) {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    usuario.setLogin(rs.getString("login"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setId(rs.getInt("id"));
                }
            }
        }
        return usuario;
    }

    public void alterar(Usuario usuario) {
        try (Connection connection = new Conexao().getConnection()) {
            String sql = "UPDATE usuarios SET login = ?, senha = ? WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setInt(3, usuario.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Ops....");
        }
    }

}