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
import java.util.LinkedList;
import java.util.List;
import model.DichVu;

/**
 *
 * @author PhamTrang
 */
public class DichVuDAO {
    private Connection conn;
    private DAO dao;
    public DichVuDAO() { 
    }
     public List <DichVu> getDVTheoLoai(String loai){
        dao = new DAO();
        conn = dao.setupConnection(conn);
        List <DichVu> listDV = new LinkedList<>();
        DichVu dichvu;
        try {
            Class.forName(JDBC_DRIVER);    
            Statement stm = conn.createStatement();
            String sql = "SELECT ID, tên FROM dichvu where loại = '"+loai+"';";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
              String id = rs.getString(1);
              String ten = rs.getString(2);
              dichvu = new DichVu(id, ten);
              listDV.add(dichvu); 
            }
            return listDV;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public DichVu getTTDV(String id){
        dao = new DAO();
        conn = dao.setupConnection(conn);
        DichVu dichvu;
        try {
            Class.forName(JDBC_DRIVER);    
            Statement stm = conn.createStatement();
            String sql = "SELECT ID, Tên, Loại, `Giá tiền` FROM dichvu where ID = '"+id+"';";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
              String idDV = rs.getString(1);
              String ten = rs.getString(2);
              String loai = rs.getString(3);
              String giaTien = rs.getString(4);
              dichvu = new DichVu(id, ten, loai, giaTien); 
              return dichvu;
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    } 
}
