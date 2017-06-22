package init;

import command.DeleteMultipleCommand;
import command.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import static spark.Spark.*;
import spark.SparkBase;
import spark.TemplateViewRoute;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * *
 * Classe que determina as rotas
 *
 * @author iapereira
 */
public class Main {

    public static void main(String[] args) {

        staticFileLocation("/html");
        
        //port(80);

        // teste ajax
        //get("/testeajax/:parametro", (req, res) -> "Hello World " + req.params(":parametro"));
        
        get("/testeajax/:parametro", (req, res) -> new FazAlgumaCoisaAjax(req, res).getResposta());
        
        /*
        before((request, response) -> {
            boolean authenticated = false;
            if (!authenticated) {
                halt(401, "You are not welcome here");
            }
        });*/

      
        // delete
        get("/delete/:id", new TemplateViewRoute() {
            @Override
            public ModelAndView handle(Request request, Response response) {
                return new ModelAndView(new DeleteCommand(request, response), "");
            }
        }, new MustacheTemplateEngine());

        post("/delete_multiple", new TemplateViewRoute() {
            @Override
            public ModelAndView handle(Request request, Response response) {
                try {
                    return new ModelAndView(new DeleteMultipleCommand(request, response).getMap(), "message.html");
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        }, new MustacheTemplateEngine());

        // tela inserir      
        get("/screen_insert", new TemplateViewRoute() {
            @Override
            public ModelAndView handle(Request request, Response response) {
                return new ModelAndView(new Command(request, response), "screen_insert.html");
            }
        }, new MustacheTemplateEngine());

        post("/insert/", new TemplateViewRoute() {
            @Override
            public ModelAndView handle(Request request, Response response) {
                return new ModelAndView(new InsertCommand(request, response).getMap(), "message.html");
            }
        }, new MustacheTemplateEngine());

        // update
        get("/screen_update/:id", new TemplateViewRoute() {
            @Override
            public ModelAndView handle(Request request, Response response) {
                return new ModelAndView(new ScreenUpdateCommand(request, response).getMap(), "screen_update.html");
            }
        }, new MustacheTemplateEngine());

        post("/update/", new TemplateViewRoute() {
            @Override
            public ModelAndView handle(Request request, Response response) {
                return new ModelAndView(new UpdateCommand(request, response).getMap(), "message.html");
            }
        }, new MustacheTemplateEngine());
        
          // index
        get("/", new TemplateViewRoute() {
            @Override
            public ModelAndView handle(Request request, Response response) {
                return new ModelAndView(new ListCommand(request, response).getMap(), "index.html");
            }
        }, new MustacheTemplateEngine());


    }
}
