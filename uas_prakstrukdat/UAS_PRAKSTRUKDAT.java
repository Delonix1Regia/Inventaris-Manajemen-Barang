/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_prakstrukdat;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diah AR
 */
// http://localhost/phpmyadmin/index.php?route=/database/structure&db=inventaris
public class UAS_PRAKSTRUKDAT {

    /**
     * @param args the command line arguments
     */
    public static String servername = "localhost";
    public static String username = "root";
    public static String dbname = "inventaris";
    public static Integer portnumber = 3306;
    public static String password ="";
    
    public static Connection getConnection(){
        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        datasource.setPassword(password);
        

        try {
            return datasource.getConnection();
                    } catch (SQLException ex) {
            Logger.getLogger(UAS_PRAKSTRUKDAT.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
