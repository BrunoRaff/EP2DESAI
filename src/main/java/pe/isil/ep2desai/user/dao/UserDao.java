package pe.isil.ep2desai.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.isil.ep2desai.user.dao.mysql.MysqlConnection;
import pe.isil.ep2desai.user.model.User;


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
    
    
     public String updateUser(User user) throws Exception{
       String message= "";
        MysqlConnection mysqConn = new MysqlConnection();
        Connection conn = mysqConn.getConnection();
        int rowsAffected=0;
        int count=0;
        
        
        PreparedStatement  ps = conn.prepareStatement("SELECT * FROM ALUMNO where alu_id=?");
        ps.setInt(1, user.getAlu_id());
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            count++;
        }
        
        if(count > 0 ){
            
            
            String queryUpdate = "UPDATE ALUMNO SET alu_nombre=?, alu_usuario=?,alu_password=?,alu_direccion=?,alu_telefono=?,alu_email=? WHERE alu_id=?";
       
            PreparedStatement psUpdate = conn.prepareStatement(queryUpdate);
            psUpdate.setString(1, user.getAlu_nombre());
            psUpdate.setString(2, user.getAlu_usuario());
            psUpdate.setString(3, user.getAlu_password());
            psUpdate.setString(4, user.getAlu_direccion());
            psUpdate.setString(5, user.getAlu_telefono());
            psUpdate.setString(6, user.getAlu_email());
            psUpdate.setInt(7, user.getAlu_id());
            rowsAffected= psUpdate.executeUpdate();
            
            
            if(rowsAffected>0){
                message="Se actualizo el usuario satisfactoriamente";
            }else{
                message="Ocurrio un error";
            }         
        }else{
            message="Alumno no existe";
        }
        
        return message;
        
    }
     
      public String deleteUser(User user) throws Exception{
        String message= "";
        MysqlConnection mysqConn = new MysqlConnection();
        Connection conn = mysqConn.getConnection();
        int rowsAffected = 0;
        PreparedStatement  ps = conn.prepareStatement("DELETE FROM ALUMNO where alu_id=?");
        ps.setInt(1, user.getAlu_id());
        
       rowsAffected = ps.executeUpdate();
        if(rowsAffected>0){
                message="Se elimino el usuario satisfactoriamente";
            }else{
                message="Alumno no existe";
            }
        
        return message;
    }
     
     
    
}
