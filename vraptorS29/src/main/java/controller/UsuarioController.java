package controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import database.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.inject.Inject;
import model.Usuario;

@Controller
public class UsuarioController {
    @Inject
    private Result result;
    @Inject
    private UsuarioDAO dao;
    
    @Get
    @Path("/usuario/excluir/{id}")
    public void excluir(int id) throws ClassNotFoundException, SQLException{
        dao.excluir(id);
        result.redirectTo(this).listar();
    }
    
   
    public ArrayList<Usuario> listar() throws ClassNotFoundException, SQLException{
        return dao.listar();
    }
    
    @Get
    @Path("/usuario/tela_adicionar")
    public void tela_adicionar(){
        
    }
    
    @Get
    @Path("/usuario/tela_alterar/{id}")
    public Usuario tela_alterar(int id) throws ClassNotFoundException, SQLException{
        //result.include("carro", dao.obter(id));
        return dao.obter(id);
    }
    
    @Post
    @Path("/usuario/alterar")
    public void alterar(Usuario usuario) throws ClassNotFoundException, SQLException{
        System.out.println("============================");
        System.out.println("============================");
        System.out.println(usuario.getId());        
        System.out.println(usuario.getLogin());
        System.out.println("============================");
        System.out.println("============================");
        
        dao.alterar(usuario);
        result.redirectTo(this).listar();
    }
    
    @Post
    @Path("/usuario/adicionar")
    public void adicionar(Usuario usuario) throws ClassNotFoundException, SQLException{
        dao.inserir(usuario);
        result.redirectTo(this).listar();
    }
    
}
