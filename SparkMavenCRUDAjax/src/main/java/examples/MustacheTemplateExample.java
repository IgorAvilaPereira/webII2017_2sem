package examples;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Modelo;
import model.Pessoa;
import database.PessoaDAO;

import spark.ModelAndView;

import static spark.Spark.get;
import spark.template.mustache.MustacheTemplateEngine;

public class MustacheTemplateExample {

    /*public static void main(String[] args) throws SQLException {
        
        Map map = new HashMap();
        map.put("name", "Sam");
      
        ArrayList<Modelo> modelos = new ArrayList();
        modelos.add(new Modelo("title1", "name1"));
        modelos.add(new Modelo("title2", "name2"));       
        map.put("items", modelos);
        
       ArrayList<Pessoa> pessoas = new PessoaDAO().select();   
       map.put("pessoas", pessoas);
        
               
        get("/mustache", (rq, rs) -> new ModelAndView(map, "mustache.html"), new MustacheTemplateEngine());
    }*/
}
