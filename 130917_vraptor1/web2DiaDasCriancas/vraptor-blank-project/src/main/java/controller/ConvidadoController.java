/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import database.ConvidadoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import model.Convidado;

/**
 *
 * @author iapereira
 */
@Controller
public class ConvidadoController {
   
    @Inject
    private Result result;
    
    @Inject
    private ConvidadoDAO convidadoDAO;
    
    
    @Path("/")
    public List<Convidado> listar() throws SQLException{
        
        List<Convidado> vetConvidado = new ArrayList();
        //vetConvidado.add(new Convidado("Ederson", "hellokitty"));
        
        vetConvidado = convidadoDAO.listar();
        return vetConvidado;
        //return new ConvidadoDAO().listar();
    }
    
    
    @Get
    @Path("/convidado/excluir/{convidado.id}")
    public void excluir(Convidado convidado) throws SQLException{
        boolean resultado = convidadoDAO.excluir(convidado.getId());        
        result.redirectTo(ConvidadoController.class).listar();        
    }
    
    public void tela_adicionar(){
        
    }
    
    @Post
    public void adicionar(Convidado convidado) throws SQLException{
        boolean resultado = convidadoDAO.adicionar(convidado);        
        result.include("mensagem", ((resultado == true) ? "<script> alert('foi'); </script>" : "deu xabum"));
        result.redirectTo(ConvidadoController.class).listar();
    }
    
    @Post
    public void editar(Convidado convidado) throws SQLException{
        convidadoDAO.editar(convidado);
        result.redirectTo(ConvidadoController.class).listar();
    }   
    
    
    @Get
    @Path("/convidado/tela_editar/{convidado.id}")
    public Convidado tela_editar(Convidado convidado) throws SQLException{
        return convidadoDAO.obter(convidado.getId());
    }
    
    
}
