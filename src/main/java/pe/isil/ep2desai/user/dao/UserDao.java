/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.isil.ep2desai.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import pe.isil.ep2desai.user.dao.mysql.MysqlConnection;
import pe.isil.ep2desai.user.model.User;

/**
 *
 * @author NModem
 */
public class UserDao {
    public int registerUser(User user) throws Exception{
        MysqlConnection mysqConn = new MysqlConnection();
        Connection conn = mysqConn.getConnection();
        int rowsAffected = 0;
        
        String queryInsert = "INSERT INTO ALUMNO (alu_nombre,alu_usuario,alu_password,alu_direccion,alu_telefono,alu_email)" 
                + "VALUES (?,?,?,?,?,?)";
        
        PreparedStatement ps = conn.prepareStatement(queryInsert);
        ps.setString(1, user.getAlu_nombre());
        ps.setString(2, user.getAlu_usuario());
        ps.setString(3, user.getAlu_password());
        ps.setString(4, user.getAlu_direccion());
        ps.setString(5, user.getAlu_telefono());
        ps.setString(6, user.getAlu_email());
        
        rowsAffected = ps.executeUpdate();
        return rowsAffected;
        
    }
    
}
