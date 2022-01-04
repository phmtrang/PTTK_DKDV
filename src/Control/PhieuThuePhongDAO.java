/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import static Control.DAO.JDBC_DRIVER;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author PhamTrang
 */
public class PhieuThuePhongDAO {
    private Connection conn;
    private DAO dao;
    public PhieuThuePhongDAO() { 
    }
     public String getPhong(String msv){
        dao = new DAO();
        conn = dao.setupConnection(conn);
        try {
            Class.forName(JDBC_DRIVER);    
            Statement stm = conn.createStatement();
            String sql = "SELECT IDPhong FROM phieuthuephong where MSV = '"+msv+"';";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                String phong = rs.getString("IDPhong");
                return phong;
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
