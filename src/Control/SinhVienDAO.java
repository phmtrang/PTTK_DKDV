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
import model.SinhVien;

/**
 *
 * @author PhamTrang
 */
public class SinhVienDAO {
    private Connection conn;
    private DAO dao;
    public SinhVienDAO() { 
    }
    public SinhVien getThongTin(String msv){
        dao = new DAO();
        conn = dao.setupConnection(conn);
        SinhVien sinhvien;
        try {
            Class.forName(JDBC_DRIVER);    
            Statement stm = conn.createStatement();
            String sql = "SELECT MSV,hoTen  FROM sinhvien where MSV = '"+msv+"';";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
              String maSV = rs.getString(1);
              String ten = rs.getString(2);
              sinhvien = new SinhVien(maSV, ten);
              return sinhvien;
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
