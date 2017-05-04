/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.*;
import java.util.List;
import java.util.ArrayList;
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
public class Bacheca extends HttpServlet {

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
                List<Nerd> listaNerd = NerdFactory.getInstance().getNerdList();
                request.setAttribute("listaNerd", listaNerd);
                if(request.getParameter("b_id")!=null){
                    Integer b_id = Integer.parseInt(request.getParameter("b_id"));
                    int bacheca_id = b_id;
                    request.setAttribute("bacheca_id", bacheca_id);
                    Nerd user_bacheca = NerdFactory.getInstance().getNerdById(bacheca_id);
                    request.setAttribute("user_bacheca", user_bacheca);
                    String contenuto = request.getParameter("cont");
                    if (contenuto != null){
                        Post newPost = new Post();
                        newPost.setId(bacheca_id*4);
                        newPost.setUtente(nerd);
                        newPost.setpBacheca(user_bacheca);
                        newPost.setContent(contenuto);
                        PostFactory.getInstance().addPost(newPost);
                        request.setAttribute("newPost", true);
                    }
                    List<Post> posts = PostFactory.getInstance().getPostListB(user_bacheca);
                    request.setAttribute("posts", posts);
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                }else{
                    request.setAttribute("user_bacheca", nerd);
                    String contenuto = request.getParameter("cont");
                    if (contenuto != null){
                        Post newPost = new Post();
                        newPost.setId(userID*4);
                        newPost.setUtente(nerd);
                        newPost.setpBacheca(nerd);
                        newPost.setContent(contenuto);
                        PostFactory.getInstance().addPost(newPost);
                        request.setAttribute("newPost", true);
                    }
                    List<Post> posts = PostFactory.getInstance().getPostListB(nerd);
                    request.setAttribute("posts", posts);
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                }
            }else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }else{
            request.setAttribute("accessDenied", true);
            request.getRequestDispatcher("bacheca.jsp").forward(request, response);
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
