
package pe.isil.ep2desai.user.controller;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pe.isil.ep2desai.user.dao.UserDao;
import pe.isil.ep2desai.user.model.User;

@WebServlet(name = "UserUpdateServlet", urlPatterns = {"/UserUpdateServlet"})
public class UserUpdateServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
               RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
               dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserDao userUpdateDao = new UserDao();
        String mensaje="";
        
        String alu_id = request.getParameter("alu_id");
        String alu_nombre = request.getParameter("alu_nombre");
        String alu_usuario = request.getParameter("alu_usuario");
        String alu_password = request.getParameter("alu_password");
        String alu_direccion = request.getParameter("alu_direccion");
        String alu_telefono = request.getParameter("alu_telefono");
        String alu_email = request.getParameter("alu_email");
   
        
        User user = new User();   
        user.setAlu_id(Integer.parseInt(alu_id));
        user.setAlu_nombre(alu_nombre);
        user.setAlu_usuario(alu_usuario);
        user.setAlu_password(alu_password);
        user.setAlu_direccion(alu_direccion);
        user.setAlu_telefono(alu_telefono);
        user.setAlu_email(alu_email) ;
        
        try{
            mensaje = userUpdateDao.updateUser(user);
            
        }catch(Exception e){
            mensaje=e.toString();
            e.printStackTrace();
        }
        
  
        RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
        request.setAttribute("message",mensaje );
        dispatcher.forward(request,response);
  
        
        //processRequest(request, response);
    }

}
