/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;

import controller.productController;

/**
 *
 * @author REDMIBOOK
 */
public class productmanagement extends javax.swing.JFrame {

    String productid = "";
    /**
     * Creates new form productmanagement
     * @throws ClassNotFoundException
     */
    public productmanagement(int userid) throws ClassNotFoundException {
        initComponents(userid);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(int userid) throws ClassNotFoundException {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Tambah = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NamaProduk = new javax.swing.JTextField();
        Deskripsi = new javax.swing.JTextField();
        Harga = new javax.swing.JTextField();
        Stock = new javax.swing.JTextField();
        Delete = new javax.swing.JButton();
        Kembali = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 255, 51));

        jLabel6.setBackground(new java.awt.Color(0, 255, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 70)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 0));
        jLabel6.setText("SUII TOKO [POS]");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        Tambah.setBackground(new java.awt.Color(204, 0, 102));
        Tambah.setForeground(new java.awt.Color(255, 255, 255));
        Tambah.setText("Tambah");
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    TambahActionPerformed(evt, userid);
                    JOptionPane.showMessageDialog(Tambah, "Berhasil Menambahkan Barang");

                } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(Tambah, "Gagal Menambahkan Barang Error - " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });


        Edit.setBackground(new java.awt.Color(204, 0, 102));
        Edit.setForeground(new java.awt.Color(255, 255, 255));
        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    EditActionPerformed(evt, userid);
                    JOptionPane.showMessageDialog(Edit, "Berhasil Edit Barang");
                } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(Edit, "Gagal Edit Barang Error"+ e.getMessage());
                    e.printStackTrace();

                }
            }

        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nama Product :");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product Deskripsi :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Harga Product :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Stock Product :");

        NamaProduk.setBackground(new java.awt.Color(255, 51, 0));
        NamaProduk.setForeground(new java.awt.Color(255, 255, 255));
        NamaProduk.setToolTipText("Masukan Nama Product");

        Deskripsi.setBackground(new java.awt.Color(255, 51, 0));
        Deskripsi.setForeground(new java.awt.Color(255, 255, 255));
        Deskripsi.setToolTipText("Masukan Deskripsi Produk");

        Harga.setBackground(new java.awt.Color(255, 51, 0));
        Harga.setForeground(new java.awt.Color(255, 255, 255));
        Harga.setToolTipText("Masukan Harga Produk");


        Stock.setBackground(new java.awt.Color(255, 51, 0));
        Stock.setForeground(new java.awt.Color(255, 255, 255));
        Stock.setToolTipText("Masukan Stock Produk");

        Delete.setBackground(new java.awt.Color(204, 0, 102));
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                try {
                    deleteProductData(arg0, userid);
                } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }


        });

        Kembali.setBackground(new java.awt.Color(204, 0, 102));
        Kembali.setForeground(new java.awt.Color(255, 255, 255));
        Kembali.setText("Kembali");
        Kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    KembaliActionPerformed(evt, userid);
                } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Deskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        // .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Kembali)
                            .addComponent(Tambah))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, Short.MAX_VALUE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Deskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Harga, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(Kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel3.setBackground(new java.awt.Color(51, 0, 102));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            
            new Object [][] {},
            new String [] {
                "Product ID", "Nama Product", "Product Deskripsi", "Harga Product", "Stock Product"
            }
        ));
        jTable1.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {


            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent arg0) {
                // TODO Auto-generated method stub 

                if (!arg0.getValueIsAdjusting()) {
                    // Get selected row
                    int selectedRow = jTable1.getSelectedRow();

                    // Populate text fields with data from the selected row
                    productid = jTable1.getValueAt(selectedRow, 0).toString();
                    NamaProduk.setText(jTable1.getValueAt(selectedRow, 1).toString());
                    Deskripsi.setText(jTable1.getValueAt(selectedRow, 2).toString());
                    Harga.setText(jTable1.getValueAt(selectedRow, 3).toString());
                    Stock.setText(jTable1.getValueAt(selectedRow, 4).toString());
                }
            }

        });
        loadData();
        // jTable1 = new DefaultTableModel(new Object[][]{}, new String[]{"Nama Product", "Product Deskripsi", "Harga Product", "Stock Product"});
        jScrollPane6.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadData() throws ClassNotFoundException {
        List<models.Product> productList = productController.GetAllproductData();
    
        // Clear existing rows from the table
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    
        // Populate the table with the retrieved data
        for (models.Product product : productList) {
            Object[] rowData = {product.getProductId(),product.getProductName(), product.getProductDesc(), product.getProductHarga(), product.getProductStock()};
            model.addRow(rowData);
        }
    }
    
    


    private void EditActionPerformed(java.awt.event.ActionEvent evt, int userid) throws NumberFormatException, ClassNotFoundException, SQLException {//GEN-FIRST:event_EditActionPerformed
        // TODO add your handling code here:
        dispose();
        this.setVisible(false);
        String product_nama = NamaProduk.getText();
        String product_desc = Deskripsi.getText();
        String product_harga = Harga.getText();
        String product_stock = Stock.getText();

        productController.updateProductData(Integer.parseInt(productid), product_nama, product_desc, Integer.parseInt(product_harga), Integer.parseInt(product_stock));
        new productmanagement(userid).setVisible(true);

    }//GEN-LAST:event_EditActionPerformed

    private void TambahActionPerformed(java.awt.event.ActionEvent evt, int userid) throws ClassNotFoundException, SQLException {//GEN-FIRST:event_TambahActionPerformed
        // TODO add your handling code here:
        dispose();
        this.setVisible(false);
        String product_nama = NamaProduk.getText();
        String product_desc = Deskripsi.getText();
        String product_harga = Harga.getText();
        String product_stock = Stock.getText();

        productController.insertProductData(product_nama, product_desc, Integer.parseInt(product_harga), Integer.parseInt(product_stock));
        new productmanagement(userid).setVisible(true);


    }//GEN-LAST:event_TambahActionPerformed

    private void deleteProductData(ActionEvent arg0, int userid) throws NumberFormatException, ClassNotFoundException, SQLException {
        dispose();
        this.setVisible(false);
        String product_nama = NamaProduk.getText();

        productController.deleteProductData(Integer.parseInt(productid));
        new productmanagement(userid).setVisible(true);

    }

    private void KembaliActionPerformed(java.awt.event.ActionEvent evt, int userid) throws ClassNotFoundException, SQLException {//GEN-FIRST:event_KembaliActionPerformed
        // TODO add your handling code here:
        dispose();
        this.setVisible(false);
        dashboard dash = new dashboard(userid);
        dash.setVisible(true);
        dash.setTitle("SUI DASHBOARD");
    }//GEN-LAST:event_KembaliActionPerformed

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
            java.util.logging.Logger.getLogger(productmanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productmanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productmanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productmanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        // java.awt.EventQueue.invokeLater(new Runnable() {
        //     public void run() {
        //         new productmanagement().setVisible(true);
        //     }
        // });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JTextField Deskripsi;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField Harga;
    private javax.swing.JButton Kembali;
    private javax.swing.JTextField NamaProduk;
    private javax.swing.JTextField Stock;
    private javax.swing.JButton Tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea4;
    // End of variables declaration//GEN-END:variables
}
