/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.NerdFactory;
import amm.nerdbook.Classi.Nerd;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pierandrea
 */
public class Profilo extends HttpServlet {

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
        
        HttpSession session = request.getSession(false);
        
        if(session!=null && session.getAttribute("loggedIn")!=null && session.getAttribute("loggedIn").equals(true)){
            
            String user = request.getParameter("user");
            
            int userID;

            if(user != null){
                userID = Integer.parseInt(user);
            } else {
                Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
                userID = loggedUserID;
            }
            
            Nerd nerd = NerdFactory.getInstance().getNerdById(userID);
            if(nerd != null){
                request.setAttribute("nerd", nerd);
                request.getRequestDispatcher("profilo.jsp").forward(request, response);
                String nome = request.getParameter("name");
                String cognome = request.getParameter("surname");
                String img_pro = request.getParameter("img");
                String password = request.getParameter("psw");
                String c_pass = request.getParameter("c_psw");
                if(nome != null && cognome != null && img_pro != null && password != null && c_pass != null && password.equals(c_pass)){
                    nerd.setNome(nome);
                    nerd.setCognome(cognome);
                    nerd.setUrlFotoProfilo(img_pro);
                    nerd.setPassword(password);
                    request.setAttribute("profileModified", true);
                    request.getRequestDispatcher("profilo.jsp").forward(request, response);
                }
            }else{
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }else{
            request.setAttribute("accessDenied", true);
            request.getRequestDispatcher("profilo.jsp").forward(request, response);
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
