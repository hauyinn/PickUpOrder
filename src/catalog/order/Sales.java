/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalog.order;

import Control.OrderControl;
import Domain.Orderdetail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yong
 */
public class Sales extends javax.swing.JFrame {

      List<Orderdetail> OrderdetailList=new ArrayList<Orderdetail>();
     private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Orderdetail";
    private OrderControl orderControl = new OrderControl();
    
    public Sales() {
        initComponents();
        displayOrder();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Invoice ID", "Customer ID", "Customer Name", "Flower Type", "OrderDate", "DeliveryDate", "Quantity", "Price", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public ArrayList<Orderdetail> OrderdetailList() {
            
            ArrayList<Orderdetail> OrderdetailList=new ArrayList<Orderdetail>();
        
        try {
           String host = "jdbc:derby://localhost:1527/order";
           Connection conn = DriverManager.getConnection(host,user, password);
            String queryStr = "SELECT * FROM " + "Orderdetail";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(queryStr);
            Orderdetail orderR;
            while(rs.next()) {
                 orderR = new Orderdetail(rs.getString("ORDERID"), rs.getString("INVOICEID"), rs.getString("CUSTOMERID"), rs.getString("CUSTOMERNAME"), rs.getString("FLOWERTYPE"), rs.getString("ORDERDATE"), rs.getString("DELIVERYDATE"), rs.getInt("QUANTITY"), rs.getDouble("PRICE"), rs.getString("ADDRESS"));
                 OrderdetailList.add(orderR);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return  OrderdetailList;
    }
     
      public void displayOrder(){
        ArrayList<Orderdetail> List = OrderdetailList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[10];
        for(int i=0; i<List.size(); i++){

                    row[0]= List.get(i).getOrderid();
                    row[1]= List.get(i).getInvoiceid();
                    row[2]= List.get(i).getCustomerid();
                    row[3]= List.get(i).getCustomername();
                    row[4]= List.get(i).getFlowertype();
                    row[5]= List.get(i).getOrderdate();
                    row[6]= List.get(i).getDeliverydate();
                    row[7]= List.get(i).getQuantity();
                    row[8]= List.get(i).getPrice();
                    row[9]= List.get(i).getAddress();
                    model.addRow(row);
                    
                    }
        }
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
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
