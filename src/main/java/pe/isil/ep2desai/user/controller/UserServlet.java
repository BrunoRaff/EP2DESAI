/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.isil.ep2desai.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pe.isil.ep2desai.user.dao.UserDao;
import pe.isil.ep2desai.user.model.User;
/**
 *
 * @author NModem
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
               RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
               dispatcher.forward(request, response);
    }


     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserDao userDao = new UserDao();
        int rowsAffected = 0;
        String mensaje="";
        
        String alu_nombre = request.getParameter("alu_nombre");
        String alu_usuario = request.getParameter("alu_usuario");
        String alu_password = request.getParameter("alu_password");
        String alu_direccion = request.getParameter("alu_direccion");
        String alu_telefono = request.getParameter("alu_telefono");
        String alu_email = request.getParameter("alu_email");
        
        User user = new User();
        user.setAlu_nombre(alu_nombre);
        user.setAlu_usuario(alu_usuario);
        user.setAlu_password(alu_password);
        user.setAlu_direccion(alu_direccion);
        user.setAlu_telefono(alu_telefono);
        user.setAlu_email(alu_email);
        
        try{
            rowsAffected = userDao.registerUser(user);
            mensaje="Usuario registrado satisfactoriamente";
        }catch(Exception e){
            mensaje=e.toString();
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
        
        request.setAttribute("message", mensaje);
        
        dispatcher.forward(request,response);
        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
