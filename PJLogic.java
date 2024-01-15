/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diah AR
 */
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;


public class PJLogic {
    private LinkedList<String[]> dataListPJ = new LinkedList<>();
    private Connection koneksi;
    private PreparedStatement psmt;
    private Statement stat;
    private ResultSet rs;
    private String query, notif;
    
    public PJLogic() {
        try {
            koneksi = Konfig.configDB();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void doTambahPJ(String id_pj, String nama_pj, String jenis_kelamin, String no_hp, String alamat ) {
        // Simpan data ke LinkedList untuk ditampilkan di tabel
        String[] rowData = {id_pj,nama_pj,jenis_kelamin,no_hp, alamat};
        dataListPJ.add(rowData);
    }
    
    
    public String[] doCariPJ(String id_pj) {
        for (String[] rowData : dataListPJ) {
            if (rowData[0].equals(id_pj)) {
                return rowData;
            }
        }
        // Jika tidak ditemukan, lakukan pencarian di database
        query = "SELECT * FROM penanggungjawab WHERE id_pj = ?";
        try {
            koneksi = Konfig.configDB();  // Ganti koneksi di sini
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, id_pj);
            rs = psmt.executeQuery();

            if (rs.next()) {
                // Simpan hasil pencarian ke dalam LinkedList
                String idpj = rs.getString("id_pj");
                String nama_pj = rs.getString("nama_pj");
                String jenis_kelamin = rs.getString("jenis_kelamin");
                String no_hp = rs.getString("no_hp");
                String alamat = rs.getString("alamat");
                

                String[] rowDataDB = {idpj,nama_pj,jenis_kelamin,no_hp, alamat};
                dataListPJ.add(rowDataDB);

                return rowDataDB;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    
    
    public void doHapusPJ(int selectedRow) {
        dataListPJ.remove(selectedRow);
    }

    public LinkedList<String[]> getDataListPJ() {
        return dataListPJ;
    }

    public void setDataListPJ(String[] data) {
        dataListPJ.add(data);
    }
    
}
