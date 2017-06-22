/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import database.PessoaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Modelo;
import model.Pessoa;
import spark.Request;
import spark.Response;
import spark.Session;

/**
 *
 * @author iapereira
 */
public class ListCommand extends Command {

    public ListCommand(Request request, Response response) {
        super(request, response);
        map.put("name", "Seja bem vindo!!!");
        
        Session sessao = request.session(true);
        sessao.attribute("variavel1", "Meu primeiro valor de sessao");
        
        
        
        ArrayList<Pessoa> pessoas;
        try {
            pessoas = new PessoaDAO().select();
            if (pessoas.size()> 0) { 
                map.put("pessoas", pessoas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
