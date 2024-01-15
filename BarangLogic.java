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


public class BarangLogic {
    private LinkedList<String[]> dataListBarang = new LinkedList<>();
    private Connection koneksi;
    private PreparedStatement psmt;
    private Statement stat;
    private ResultSet rs;
    private String query, notif;
    
    public BarangLogic() {
        try {
            koneksi = Konfig.configDB();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void doTambahBarang(String idBarang, String namaBarang, String stok) {
        // Simpan data ke LinkedList untuk ditampilkan di tabel
        String[] rowData = {idBarang, namaBarang, stok};
        dataListBarang.add(rowData);
    }
    
    
    public String[] doCariBarang(String idBarang) {
        for (String[] rowData : dataListBarang) {
            if (rowData[0].equals(idBarang)) {
                return rowData;
            }
        }
        // Jika tidak ditemukan, lakukan pencarian di database
        query = "SELECT * FROM barang WHERE id_barang = ?";
        try {
            koneksi = Konfig.configDB();  // Ganti koneksi di sini
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, idBarang);
            rs = psmt.executeQuery();

            if (rs.next()) {
                // Simpan hasil pencarian ke dalam LinkedList
                String idBarangDB = rs.getString("id_barang");
                String namaBarangDB = rs.getString("nama_barang");
                String stokDB = rs.getString("stok");

                String[] rowDataDB = {idBarangDB, namaBarangDB, stokDB};
                dataListBarang.add(rowDataDB);

                return rowDataDB;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    
    
    public void doHapusBarang(int selectedRow) {
        dataListBarang.remove(selectedRow);
    }

    public LinkedList<String[]> getDataListBarang() {
        return dataListBarang;
    }

    public void setDataListBarang(String[] data) {
        dataListBarang.add(data);
    }
    
}
