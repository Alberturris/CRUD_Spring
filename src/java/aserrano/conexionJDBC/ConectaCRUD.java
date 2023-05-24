/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aserrano.conexionJDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alberturris
 */
@WebServlet(name = "ConectaCRUD", urlPatterns = {"/ConectaCRUD"})
public class ConectaCRUD extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConectaCRUD</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Servlet ConectaCRUD at " + request.getServletPath() + "</h3>"); // Nombre Servlet
            out.println("<h3>Servlet ConectaCRUD at " + request.getContextPath() + "</h3>"); // Nombre Proyecto
            out.println("<h3>Servlet ConectaCRUD at " + request.getPathInfo() + "</h3>");
            out.println("<h3>Servlet ConectaCRUD at " + request.getRemoteUser() + "</h3>");
            out.println("<h3>Servlet ConectaCRUD at " + request.getRequestURI()+ "</h3>"); // Proyecto/Servlet
            out.println("<h3>Servlet ConectaCRUD at " + request.getRequestURL()+ "</h3>"); // URL : ip:puerto/proyecto/servlet
            out.println("</body>");
            out.println("</html>");
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
        
        String jdbcUrl = "jdbc:mysql://localhost:3306/gestionpedidoscrud?useSSL=false";  
        String user = "root";
        String password = "";
        String driver = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(driver);
            DriverManager.getConnection(jdbcUrl, user, password);
            processRequest(request, response);
        }catch(Exception e){
            e.printStackTrace();
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
