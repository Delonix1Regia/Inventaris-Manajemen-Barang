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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;




public class Transaksi extends javax.swing.JFrame {
    private LinkedList<String[]> dataListTransaksi = new LinkedList<>(); 
    private TransaksiLogic transaksilogic = new TransaksiLogic();
    
    private javax.swing.JRadioButton radioPenerimaan;
    private javax.swing.JRadioButton radioPengiriman;
    private javax.swing.ButtonGroup jenisGroup;
    

    private String id_transaksi;  
//  private JComboBox<String> comboBoxIDBarang;
//  private JComboBox<String> comboBoxIDPJ;

    /**
     * Creates new form try3
     */
    
     private void kosong(){
        txtIDtransaksi.setText(null);
        txtjenis.setText(null);
        txtIDbrg.setText(null);
        txtIDPJ.setText(null);
        txtTGL.setText(null);
        txtJumlah.setText(null);
    }
    
    private void tampilkan() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("ID Transaksi");
        model.addColumn("ID Penanggung Jawab");
        model.addColumn("ID Barang");
        model.addColumn("Jenis Transaksi");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Jumlah Transaksi");

        for (int i = 0; i < dataListTransaksi.size(); i++) {
            String[] rowData = dataListTransaksi.get(i);
            model.addRow(new Object[]{i + 1, rowData[0], rowData[1], rowData[2], rowData[3], rowData[4], rowData[5]});
        }

        try {
            int no = model.getRowCount() + 1;
            String sql = "SELECT * FROM transaksi";
            java.sql.Connection conn = (Connection) Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{no++, res.getString(1), res.getString(2), res.getString(3),res.getString(4), res.getString(5), res.getString(6)});
            }
            jTable1.setModel(model);

        } catch (SQLException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    

    
    
    public Transaksi() {
        initComponents();
        this.setLocationRelativeTo(null);
        tampilkan();
        kosong();
        addRadioButtons();  // Add radio buttons to the frame
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtIDtransaksi = new javax.swing.JTextField();
        txtjenis = new javax.swing.JTextField();
        txtIDPJ = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnhapus = new javax.swing.JButton();
        btncari = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        txtTGL = new javax.swing.JTextField();
        txtIDbrg = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        radiobtnIDPJ = new javax.swing.JRadioButton();
        radiobtnJenis = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        txtIDtransaksi.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtIDtransaksi.setBorder(null);
        jPanel1.add(txtIDtransaksi);
        txtIDtransaksi.setBounds(150, 410, 240, 50);

        txtjenis.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtjenis.setBorder(null);
        txtjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjenisActionPerformed(evt);
            }
        });
        jPanel1.add(txtjenis);
        txtjenis.setBounds(650, 950, 240, 50);

        txtIDPJ.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtIDPJ.setBorder(null);
        txtIDPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPJActionPerformed(evt);
            }
        });
        jPanel1.add(txtIDPJ);
        txtIDPJ.setBounds(70, 970, 240, 60);

        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/transaksi (1).png"))); // NOI18N
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsert);
        btnInsert.setBounds(360, 970, 160, 40);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/edit (1).png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);
        btnEdit.setBounds(1210, 280, 160, 40);

        jTable1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "ID Transaksi", "ID PJ", "ID Barang", "Jenis Transaksi", "Tanggal Transaksi", "Jumlah Barang"
            }
        ));
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(950, 420, 850, 580);

        btnhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/hapuss.png"))); // NOI18N
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnhapus);
        btnhapus.setBounds(930, 270, 160, 50);

        btncari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/Find (1).png"))); // NOI18N
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        jPanel1.add(btncari);
        btncari.setBounds(1500, 130, 140, 60);

        btnexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/edit (2).png"))); // NOI18N
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        jPanel1.add(btnexit);
        btnexit.setBounds(1510, 280, 140, 40);

        txtcari.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtcari.setBorder(null);
        jPanel1.add(txtcari);
        txtcari.setBounds(1090, 140, 310, 40);

        txtTGL.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtTGL.setBorder(null);
        txtTGL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTGLActionPerformed(evt);
            }
        });
        jPanel1.add(txtTGL);
        txtTGL.setBounds(490, 610, 240, 60);

        txtIDbrg.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtIDbrg.setBorder(null);
        txtIDbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDbrgActionPerformed(evt);
            }
        });
        jPanel1.add(txtIDbrg);
        txtIDbrg.setBounds(50, 910, 240, 60);

        txtJumlah.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txtJumlah.setBorder(null);
        jPanel1.add(txtJumlah);
        txtJumlah.setBounds(490, 760, 250, 60);

        radiobtnIDPJ.setText("157");
        radiobtnIDPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtnIDPJActionPerformed(evt);
            }
        });
        jPanel1.add(radiobtnIDPJ);
        radiobtnIDPJ.setBounds(170, 620, 71, 35);

        radiobtnJenis.setText("Pengiriman");
        radiobtnJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobtnJenisActionPerformed(evt);
            }
        });
        jPanel1.add(radiobtnJenis);
        radiobtnJenis.setBounds(520, 400, 145, 35);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(150, 762, 240, 50);

        jRadioButton1.setText("Penerimaan");
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(520, 430, 149, 35);

        jRadioButton2.setText("144");
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(300, 620, 71, 35);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/png/Transaksi new (3).png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1910, 1080);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1904, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1077, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjenisActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        try {
        
        String jenistransaksi = txtjenis.getText();

        
        if (!jenistransaksi.isEmpty()) {
            // linked list
            for (String[] rowData : dataListTransaksi) {
                if (rowData[1].equals(jenistransaksi)) {
                    dataListTransaksi.remove(rowData);
                    break;
                }
            }

            // hapus dari table model
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 2).equals(jenistransaksi)) {
                    model.removeRow(i);
                    break;
                }
            }

            // hapus dari database
            String sql = "DELETE FROM transaksi WHERE `jenis_transaksi`=?";
            try (Connection conn = Konfig.configDB();
                 PreparedStatement pstm = conn.prepareStatement(sql)) {
                pstm.setString(1, jenistransaksi);
                pstm.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
            }

            kosong();
        }
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void addRadioButtons() {
    radioPenerimaan = new javax.swing.JRadioButton("Penerimaan");
    radioPengiriman = new javax.swing.JRadioButton("Pengiriman");
    jenisGroup = new javax.swing.ButtonGroup();
    jenisGroup.add(radioPenerimaan);
    jenisGroup.add(radioPengiriman);

    radioPenerimaan.setBounds(770, 260, 100, 30);
    radioPengiriman.setBounds(870, 260, 100, 30);

    radioPenerimaan.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            radioPenerimaanActionPerformed(evt);
        }
    });

    radioPengiriman.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            radioPengirimanActionPerformed(evt);
        }
    });
    
    jPanel1.add(radioPenerimaan);
    jPanel1.add(radioPengiriman);
}

    private void radioPenerimaanActionPerformed(java.awt.event.ActionEvent evt) {
    // Handle Penerimaan radio button selection
    if (radioPenerimaan.isSelected()) {
        // Additional logic when Penerimaan is selected
        System.out.println("Penerimaan radio button selected");
    }
}

private void radioPengirimanActionPerformed(java.awt.event.ActionEvent evt) {
    // Handle Pengiriman radio button selection
    if (radioPengiriman.isSelected()) {
        // Additional logic when Pengiriman is selected
        System.out.println("Pengiriman radio button selected");
    }
}
    
    
    
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        try {
        String sql = "INSERT INTO transaksi (id_barang, id_pj, jenis_transaksi, tanggal_transaksi, jumlah_barang) VALUES (?, ?, ?, ?, ?)";
        java.sql.Connection conn = (Connection) Konfig.configDB();
        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, txtIDbrg.getText());
        pstm.setString(2, txtIDPJ.getText());
        pstm.setString(3, getSelectedJenisTransaksi());  // Use the selected radio button value
        pstm.setString(4, txtTGL.getText());
        pstm.setString(5, txtJumlah.getText());

        // Check if the transaction type is Penerimaan
        if (radioPenerimaan.isSelected()) {
            // Penerimaan: Tambah stok
            updateStok(getSelectedIDPJ(), Integer.parseInt(txtJumlah.getText()), true);
        } else if (radioPengiriman.isSelected()) {
            // Pengiriman: Kurangi stok
            updateStok(getSelectedIDPJ(), Integer.parseInt(txtJumlah.getText()), false);
        }

        pstm.executeUpdate();
        JOptionPane.showMessageDialog(null, "Tambah data berhasil");
        tampilkan();
        kosong();
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void updateStok(String id_barang, int jumlah, boolean isPenerimaan) throws SQLException {
    // Retrieve current stock
    String sqlSelect = "SELECT stok FROM barang WHERE id_barang=?";
    try (Connection conn = Konfig.configDB();
         PreparedStatement pstmSelect = conn.prepareStatement(sqlSelect)) {
        pstmSelect.setString(1, id_barang);
        ResultSet rs = pstmSelect.executeQuery();

        if (rs.next()) {
            int currentStok = rs.getInt("stok");

            // Update stock based on the transaction
            int newStok = isPenerimaan ? currentStok + jumlah : currentStok - jumlah;

            // Ensure that the stock is not negative
            newStok = Math.max(0, newStok);

            // Update the stock in the database
            String sqlUpdate = "UPDATE barang SET stok=? WHERE id_barang=?";
            try (PreparedStatement pstmUpdate = conn.prepareStatement(sqlUpdate)) {
                pstmUpdate.setInt(1, newStok);
                pstmUpdate.setString(2, id_barang);
                pstmUpdate.executeUpdate();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error updating stock: " + e.getMessage());
            }
        }
    }
}


    
    
    
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.rowAtPoint(evt.getPoint());
        
        if (baris >= 0 && baris < jTable1.getRowCount()) {
        id_transaksi = jTable1.getValueAt(baris, 1).toString(); 
        txtIDtransaksi.setText(id_transaksi);
        
        String id_pj = jTable1.getValueAt(baris, 2).toString();
        txtIDPJ.setText(id_pj);

        String id_barang = jTable1.getValueAt(baris, 3).toString();
        txtIDbrg.setText(id_barang);
        
        String jenis_transaksi = jTable1.getValueAt(baris, 4).toString();
        setRadioButtonSelected(jenis_transaksi);
        
        String tanggal_transaksi = jTable1.getValueAt(baris, 5).toString();
        txtTGL.setText(tanggal_transaksi);
        
        String jumlah_barang = jTable1.getValueAt(baris, 6).toString();
        txtJumlah.setText(jumlah_barang);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void setRadioButtonSelected(String jenis_transaksi) {
    if ("Penerimaan".equalsIgnoreCase(jenis_transaksi)) {
        radioPenerimaan.setSelected(true);
    } else if ("Pengiriman".equalsIgnoreCase(jenis_transaksi)) {
        radioPengiriman.setSelected(true);
    }
}
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:

    try {
        String sql = "UPDATE transaksi SET id_barang = ?, id_pj = ?, jenis_transaksi = ?, tanggal_transaksi = ?, jumlah_barang = ? WHERE id_transaksi = ?";
        java.sql.Connection conn = (Connection) Konfig.configDB();
        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, txtIDbrg.getText());
        pstm.setString(2, txtIDPJ.getText());
        pstm.setString(3, txtjenis.getText());
        pstm.setString(4, txtTGL.getText());
        pstm.setString(5, txtJumlah.getText());
        pstm.setString(6, id_transaksi);

        // Check if the transaction type is Penerimaan
        if ("Penerimaan".equalsIgnoreCase(txtjenis.getText())) {
            // Penerimaan: Tambah stok
            updateStok(txtIDbrg.getText(), Integer.parseInt(txtJumlah.getText()), true);
        } else if ("Pengiriman".equalsIgnoreCase(txtjenis.getText())) {
            // Pengiriman: Kurangi stok
            updateStok(txtIDbrg.getText(), Integer.parseInt(txtJumlah.getText()), false);
        }

        pstm.execute();
        JOptionPane.showMessageDialog(null, "Edit data berhasil");
        tampilkan();
        kosong();
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtIDPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPJActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
        String jenis_transaksi = txtcari.getText();

    // Gunakan metode pencarian pada pohon biner
    try {
        // Query SQL untuk mencari data barang berdasarkan nama_barang
        String sql = "SELECT * FROM transaksi WHERE jenis_transaksi LIKE ?";
        java.sql.Connection conn = (Connection) Konfig.configDB();
        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
        
        // Set parameter query dengan nilai nama_barang yang diambil dari JTextField
        pstm.setString(1, "%" + jenis_transaksi + "%");

        // Eksekusi query
        java.sql.ResultSet res = pstm.executeQuery();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("ID Transaksi");
        model.addColumn("ID Penanggung Jawab");
        model.addColumn("ID Barang");
        model.addColumn("Jenis Transaksi");
        model.addColumn("Tanggal Transaksi");
        model.addColumn("Jumlah Transaksi");

        int no = 1;
        // Tampilkan hasil pencarian di dalam tabel
        while (res.next()) {
            model.addRow(new Object[]{no++, res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)});
        }
        jTable1.setModel(model);

        if (model.getRowCount() > 0) {
            JOptionPane.showMessageDialog(this, "Data ditemukan untuk Transaksi: " + jenis_transaksi);

        } else {
            JOptionPane.showMessageDialog(this, "Data tidak ditemukan untuk Transaksi: " + jenis_transaksi);
        }
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
        
    }
    
    }
    
    private String getSelectedIDPJ() {
        if (radiobtnIDPJ.isSelected()) {
            return "157";
        } else if (radiobtnJenis.isSelected()) {
            return "144";
        } else {
            return ""; // Handle default case
        }
    }

    private String getSelectedJenisTransaksi() {
        if (radiobtnJenis.isSelected()) {
            return "Penerimaan";
        } else if (jRadioButton1.isSelected()) {
            return "Pengiriman";
        } else {
            return ""; // Handle default case
        }
    
    
    }//GEN-LAST:event_btncariActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Menu().setVisible(true);
    }//GEN-LAST:event_btnexitActionPerformed

    private void txtIDbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDbrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDbrgActionPerformed

    private void txtTGLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTGLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTGLActionPerformed

    private void radiobtnJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtnJenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiobtnJenisActionPerformed

    private void radiobtnIDPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobtnIDPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiobtnIDPJActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radiobtnIDPJ;
    private javax.swing.JRadioButton radiobtnJenis;
    private javax.swing.JTextField txtIDPJ;
    private javax.swing.JTextField txtIDbrg;
    private javax.swing.JTextField txtIDtransaksi;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtTGL;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtjenis;
    // End of variables declaration//GEN-END:variables
}