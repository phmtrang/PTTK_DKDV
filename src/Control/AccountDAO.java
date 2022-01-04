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
import model.Account;
import model.DichVu;

/**
 *
 * @author PhamTrang
 */
public class AccountDAO {
    private Connection conn;
    private DAO dao;
    public AccountDAO() {
    }
    public Account checkAccount(String username, String password){
        dao = new DAO();
        conn = dao.setupConnection(conn);
        try {
            Class.forName(JDBC_DRIVER);    
            Statement stm = conn.createStatement();
            String sql = "select * from thanhvien where userName='"+username+"' and password='"+password+"'";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                String name = rs.getString("userName");
                model.Account acc = new model.Account(name);
                return acc;
            }
             else {
                return null;
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
