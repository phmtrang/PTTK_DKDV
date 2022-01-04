/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Account;

/**
 *
 * @author PhamTrang
 */
public class DAO {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
    private Connection conn;
    private String server = "localhost:3306";
    private String db = "pttk";
    private String user = "root";
    private String pass = "trang1034408043";

    public DAO() {
        setupConnection(conn);
    }
    
    public Connection setupConnection(Connection con) {   
        try {
            String url = "jdbc:mysql://" + server + "/" + db + "?useUnicode=true&characterEncoding=UTF-8";
            con = DriverManager.getConnection(url, user, pass);
            return con;
        } catch (SQLException ex) {
            System.err.println("Loi ket noi DB: " + ex.getMessage());
        }
        return null;
    }

}
