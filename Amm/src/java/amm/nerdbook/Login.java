/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.GruppoFactory;
import amm.nerdbook.Classi.NerdFactory;
import amm.nerdbook.Classi.PostFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pierandrea
 */

@WebServlet(loadOnStartup = 0)
public class Login extends HttpServlet {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override
    public void init() {
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        //IMPOSTO LA CONNECTION STRING PER OGNI FACTORY
        NerdFactory.getInstance().setConnectionString(dbConnection);
        PostFactory.getInstance().setConnectionString(dbConnection);
        GruppoFactory.getInstance().setConnectionString(dbConnection);
    }
    
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Apre la sessione
        HttpSession session = request.getSession();
        
        //In caso di logout
        if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        //Se l'utente è già loggato
        if (session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) {
            //Verifica che il profilo dell'utente sia completo e
            //reindirizza alla bacheca in caso positivo o al profilo in caso negativo
            if(NerdFactory.getInstance().getNerdById((int)(session.getAttribute("loggedUserID"))).checkCompleteProfile() == -1){
                request.getRequestDispatcher("profilo.html").forward(request, response);
                return;
            }else{
                request.getRequestDispatcher("bacheca.html").forward(request, response);
                return;
            }
        //Se l'utente non è loggato    
        }else{
            
            String username = request.getParameter("user_id");
            String password = request.getParameter("psw");
            
            if(username != null && password != null){
                int loggedUserID = NerdFactory.getInstance().getIdByUserAndPassword(username, password);
                //Se l'utente è valido
                if(loggedUserID != -1){
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("loggedUserID", loggedUserID);
                    //Verifica che il profilo dell'utente sia completo e
                    //reindirizza alla bacheca in caso positivo o al profilo in caso negativo
                    if(NerdFactory.getInstance().getNerdById(loggedUserID).checkCompleteProfile() == -1){
                        request.getRequestDispatcher("profilo.html").forward(request, response);
                        return;
                    }else{
                        request.getRequestDispatcher("bacheca.html").forward(request, response);
                        return;
                    }
                //Se l'utente non è valido
                }else{
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
