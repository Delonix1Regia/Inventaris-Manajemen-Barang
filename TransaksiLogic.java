import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TransaksiLogic {
    private LinkedList<String[]> dataList = new LinkedList<>();
    private Connection koneksi;
    private PreparedStatement psmt;
    private Statement stat;
    private ResultSet rs;
    private String query, notif;
    
    public TransaksiLogic() {
        try {
            koneksi = Konfig.configDB();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    public void doTransaksi(String id_barang, String id_pj, String id_transaksi,String tanggal_transaksi, String jenis_transaksi, String jumlah_barang) {
        // Simpan data ke LinkedList untuk ditampilkan di tabel
        String[] rowData = {id_transaksi, id_pj, id_barang, jenis_transaksi, tanggal_transaksi, jumlah_barang};
        dataList.add(rowData);
    }

    public ResultSet searchByJenis(String jenis) {
        query = "SELECT * FROM transaksi WHERE jenis_transaksi = ?";
        try {
        psmt = koneksi.prepareStatement(query);
        psmt.setString(1, jenis);
        rs = psmt.executeQuery();
    } catch (Exception e) {
        System.out.println(e);
    }
    return rs;
    }

    public void doHapus(int selectedRow) {
        dataList.remove(selectedRow);
    }

    public LinkedList<String[]> getDataList() {
        return dataList;
    }

    public void setDataList(String[] data) {
        dataList.add(data);
    }
    
    // Metode transaksi yang telah dimodifikasi
    public String transaksi(String id_barang, String id_pj, String id_transaksi,String tanggal_transaksi, String jenis_transaksi, String jumlah_barang) {
        query = "INSERT INTO transaksi (id_transaksi, id_pj, id_barang,  jenis_transaksi, tanggal_transaksi, jumlah_barang) VALUES (?,?,?,?,?,?)";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, id_transaksi);
            psmt.setString(2, id_pj);
            psmt.setString(3, id_barang);
            psmt.setString(4, jenis_transaksi);
            psmt.setString(5, tanggal_transaksi);
            psmt.setString(6, jumlah_barang);
            psmt.executeUpdate();
            psmt.close();

            // Update stok barang
            updateStokBarang(id_barang, Integer.parseInt(jumlah_barang), jenis_transaksi);
        } catch (Exception e) {
            notif = "Data Gagal Disimpan" + e;
        }
        return notif;
    }

    
    public String hapusData(String id_barang){
        query = "delete from transaksi where id_barang = ?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, id_barang);
            psmt.executeUpdate();
            psmt.close();
        } catch (Exception e) {
            notif = "Data Gagal Dihapus" +e;
        }
        return notif;
    }
    
    public ResultSet TampilData() {
        query = "SELECT * FROM transaksi";
        try {
            stat = koneksi.createStatement();
            rs = stat.executeQuery(query);
        } catch (Exception e) {
            System.out.println("ela");
            System.out.println(e);
        }
        return rs;
    }
    
    // Metode untuk mendapatkan stok barang berdasarkan ID barang
    public int getStokBarang(String id_barang) {
        int stok = 0;
        try {
            String query = "SELECT stok FROM barang WHERE id_barang = ?";
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, id_barang);
            ResultSet result = psmt.executeQuery();
            if (result.next()) {
                stok = result.getInt("stok");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stok;
    }

    // Metode untuk melakukan penjumlahan atau pengurangan stok
    private void updateStokBarang(String id_barang, int jumlah, String jenis_transaksi) {
        try {
            int stok = getStokBarang(id_barang);
            if (jenis_transaksi.equals("pengiriman")) {
                // Kurangi stok jika jenis transaksi adalah pengiriman
                stok -= jumlah;
            } else if (jenis_transaksi.equals("penerimaan")) {
                // Tambahkan stok jika jenis transaksi adalah penerimaan
                stok += jumlah;
            }

            // Update stok di database
            String updateQuery = "UPDATE barang SET stok = ? WHERE id_barang = ?";
            psmt = koneksi.prepareStatement(updateQuery);
            psmt.setInt(1, stok);
            psmt.setString(2, id_barang);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
       public List<String> getIdBarangList() {
        List<String> idBarangList = new ArrayList<>();
        String query = "SELECT id_barang FROM barang";

        try (Connection connection = Konfig.configDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                idBarangList.add(resultSet.getString("id_barang"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idBarangList;
    }

    public List<String> getIdPJList() {
        List<String> idPJList = new ArrayList<>();
        String query = "SELECT id_pj FROM penanggungjawab";

        try (Connection connection = Konfig.configDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                idPJList.add(resultSet.getString("id_pj"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idPJList;
    }

    public String getNamaBarangById(String id_barang) {
        String namaBarang = "";
        String query = "SELECT nama_barang FROM barang WHERE id_barang = ?";

        try (Connection connection = Konfig.configDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, id_barang);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    namaBarang = resultSet.getString("nama_barang");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return namaBarang;
    }

    public String getNamaPJById(String id_pj) {
        String namaPJ = "";
        String query = "SELECT nama_pj FROM penanggungjawab WHERE id_pj = ?";

        try (Connection connection = Konfig.configDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, id_pj);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    namaPJ = resultSet.getString("nama_pj");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return namaPJ;
    }
}
