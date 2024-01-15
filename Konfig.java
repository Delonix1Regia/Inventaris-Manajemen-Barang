/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diah AR
 */

//import com.mysql.cj.x.protobuf.Mysqlx;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//
//
//
//public class Konfig {
//    public static Connection Konfig;
//    public static Connection configDB()throws SQLException{
//        try{
//            String url = "jdbc:mysql://localhost:3306/inventaris";
//            String user = "root";
//            String pass = "";
//            
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            Konfig =  DriverManager.getConnection(url, user, pass);
//        }catch(SQLException ex){
//            System.out.println("Koneksi gagal "+ ex.getMessage());
//        }
//        return Konfig;
//    }
//}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konfig {
    public static Connection Konfig;

    public static Connection configDB() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/inventaris";
            String user = "root";
            String pass = "";

            // Registering the MySQL JDBC driver (not required in recent JDBC versions)
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // Creating a connection using the new driver class
            Konfig = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println("Koneksi gagal " + ex.getMessage());
        }
        return Konfig;
    }
}
