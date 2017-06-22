/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.HashMap;
import spark.Request;
import spark.Response;

/**
 *
 * @author iapereira
 */
public class FazAlgumaCoisaAjax extends Command {

    private String resposta;
    private String respostaXML;
    
    public FazAlgumaCoisaAjax(Request request, Response response) {
        super(request, response);

        // faz alguma coisa
        
        this.resposta = "Hello World " + request.params(":parametro");
        
    }

    public String getResposta() {
        return this.resposta;
    }
    
    public String getRespostaXML(){
        return this.respostaXML;
    }

}
