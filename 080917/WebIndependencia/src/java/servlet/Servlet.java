/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ForcaArmada;

/**
 *
 * @author iapereira
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("adicionar")){        
            ForcaArmada forcaArmada = new ForcaArmada();
            forcaArmada.setNome(request.getParameter("nome"));
            forcaArmada.setEfetivo(Integer.parseInt(request.getParameter("efetivo")));
            forcaArmada.adicionar();            
            request.setAttribute("mensagem", "Forca Armada Adicionado com id " + forcaArmada.getId());
            RequestDispatcher rd = request.getRequestDispatcher("./pagina_mensagem.jsp");
            rd.forward(request, response);
        } else if (acao.equals("listar")){
            request.setAttribute("vetForcaArmada", ForcaArmada.listar());
            RequestDispatcher rd = request.getRequestDispatcher("./listar.jsp");
            rd.forward(request, response);
        } else if (acao.equals("excluir")){
            ForcaArmada forcaArmada = new ForcaArmada();
            forcaArmada.setId(Integer.parseInt(request.getParameter("id")));
            forcaArmada.excluir();
            //request.setAttribute("mensagem", "Excluido com sucesso?" + forcaArmada.excluir());
            RequestDispatcher rd = request.getRequestDispatcher("./Servlet?acao=listar");
            rd.forward(request, response);
        } else if (acao.equals("tela_alterar")){
            ForcaArmada forcaArmada = new ForcaArmada();
            forcaArmada.setId(Integer.parseInt(request.getParameter("id")));
            forcaArmada.carregar();
            request.setAttribute("forca", forcaArmada);
            RequestDispatcher rd = request.getRequestDispatcher("./tela_alterar.jsp");
            rd.forward(request, response);
        } else if (acao.equals("alterar")){
            ForcaArmada forcaArmada = new ForcaArmada();
            forcaArmada.setId(Integer.parseInt(request.getParameter("id")));
            forcaArmada.setEfetivo(Integer.parseInt(request.getParameter("efetivo")));
            forcaArmada.setNome(request.getParameter("nome"));
            forcaArmada.atualizar();
            //request.setAttribute("forca", forcaArmada);
            RequestDispatcher rd = request.getRequestDispatcher("./Servlet?acao=listar");
            rd.forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
