/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import command.Command;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ForcaArmada;

/**
 *
 * @author iapereira
 */
public class ListarCommand implements Command {

    public ListarCommand() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("vetForcaArmada", ForcaArmada.listar());
             RequestDispatcher rd = request.getRequestDispatcher("./listar.jsp");
            rd.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListarCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(ListarCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }
    
}
