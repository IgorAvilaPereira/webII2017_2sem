
package command;

import database.PessoaDAO;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pessoa;
import spark.Request;
import spark.Response;

/**
 *
 * @author iapereira
 */
public class ScreenUpdateCommand extends Command {

    public ScreenUpdateCommand(Request request, Response response) {
        super(request, response);
        map.put("valorDaSessao", request.session().attribute("variavel1"));
         Pessoa pessoa;
        try {
            pessoa = new PessoaDAO().selectById(Integer.parseInt(request.params(":id")));
            // PROBLEMA
            map.put("nome", pessoa.getNome());
            map.put("sobrenome", pessoa.getSobrenome());
            map.put("id", pessoa.getId());

        } catch (SQLException ex) {
            Logger.getLogger(ScreenUpdateCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
