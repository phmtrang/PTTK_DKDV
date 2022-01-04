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
import model.DichVuDaDangKy;

/**
 *
 * @author PhamTrang
 */
public class DichVuDaDangKyDAO {
    private Connection conn;
    private DAO dao;
    public DichVuDaDangKyDAO() { 
    }
     public List <DichVu> getDVDangSuDung(String loai, String msv){
        dao = new DAO();
        conn = dao.setupConnection(conn);
        List <DichVu> listDV = new LinkedList<>();
        DichVu dichvu;
        try {
            Class.forName(JDBC_DRIVER);    
            Statement stm = conn.createStatement();
            String sql = "SELECT B.ID, B.tên from pttk.dichvudadangky as A, pttk.dichvu as B where B.ID = A.IDDichVu "
                    + "and B.Loại ='"+loai+"' and A.MSV = '"+msv+"' and (A.trangThai = \"on-going\" or A.trangThai = \"unconfirmed\");";
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
     public void luuDangKy(String ngaySuDung, String yeuCauChiTiet, String trangThai, String IDDichVu, String MSV){
        dao = new DAO();
        conn = dao.setupConnection(conn);
        try {
            Class.forName(JDBC_DRIVER);    
            Statement stm = conn.createStatement();
            String sql = "Insert into dichvudadangky(ngaySuDung, yeuCauChiTiet, trangThai, IDDichVu, MSV)"
                    + " values ('"+ngaySuDung+"','"+yeuCauChiTiet+"','"
                    + trangThai + "','" + IDDichVu + "','" + MSV + "');";
            stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
}
