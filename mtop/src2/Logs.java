
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rayz
 */
public class Logs extends javax.swing.JInternalFrame {

    
    public static String mtop_id = "";
    static Connection conn = null;
    
    public Logs() {
        this.setLocation(10, 10);
        initComponents();
        conn = DB.establishConnection();
        view();
    }

    public static void view() {
        String search[][] = null;
        String col[] = {"MTOP NO", "NAME", "MAKE", "PLATE NO", "CHASSIS NO", "MOTOR NO", "DATE PAID", "TRANSACTION", "ACTION"};

        try {
            conn.setAutoCommit(true);
            Statement s = (Statement) conn.createStatement();
            s.executeQuery("SELECT MTOP_NO, CONCAT(firstname,' ',lastname) as fullname, plate_num, make, chassis_no, motor_no, ddate, type, action FROM transaction_logs ORDER BY ID DESC");
            ResultSet rs1 = s.getResultSet();//manages result
            int count = 0;
            s = (Statement) conn.createStatement();
            ResultSet res = s.executeQuery("SELECT count(MTOP_NO) as num, CONCAT(firstname,' ',lastname) as fullname, plate_num, make, chassis_no, motor_no, type, action FROM transaction_logs ORDER BY ID DESC");//manages result
            while (res.next()) {
                count = res.getInt("num");
            }

            ResultSetMetaData rsMetaData = (ResultSetMetaData) rs1.getMetaData();//manages result
            int numberOfColumns = rsMetaData.getColumnCount();
            search = new String[count][numberOfColumns];
            String rs[] = new String[numberOfColumns];
            int x = 0;
            while (rs1.next()) {
                rs[0] = "" + rs1.getString("MTOP_NO");
                rs[1] = "" + rs1.getString("fullname").toUpperCase();
                rs[2] = "" + rs1.getString("make").toUpperCase();
                rs[3] = "" + rs1.getString("plate_num");
                rs[4] = "" + rs1.getString("chassis_no");
                rs[5] = "" + rs1.getString("motor_no");
                rs[6] = "" + rs1.getString("ddate");
                rs[7] = "" + rs1.getString("type");
                rs[8] = "" + rs1.getString("action");
                for (int y = 0; y < rs.length; y++) {
                    search[x][y] = rs[y];
                }
                x++;
            }
            jTable1.setModel(new DefaultTableModel(search, col));
            ColumnSize();
            rs1.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void ColumnSize() {
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(500);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Logs");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        searchfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchfieldKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Search:");

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfieldKeyReleased
        String search[][] = null;
        String col[] = {"MTOP NO", "NAME", "MAKE", "PLATE NO", "CHASSIS NO", "MOTOR NO", "DATE PAID", "TRANSACTION", "ACTION"};

        try {
            conn.setAutoCommit(true);
            Statement s = (Statement) conn.createStatement();
            s.executeQuery("SELECT MTOP_NO, CONCAT(firstname,' ',lastname) as fullname, plate_num, make, chassis_no, motor_no, ddate, type, action FROM transaction_logs WHERE CONCAT(MTOP_NO, firstname, lastname, plate_num, make, type) RLIKE '" + searchfield.getText() +"' ORDER BY ID DESC");
            ResultSet rs1 = s.getResultSet();//manages result
            int count = 0;
            s = (Statement) conn.createStatement();
            ResultSet res = s.executeQuery("SELECT count(MTOP_NO) as num, CONCAT(firstname,' ',lastname) as fullname, plate_num, make, chassis_no, motor_no, ddate, type, action FROM transaction_logs WHERE CONCAT(MTOP_NO, firstname, lastname, plate_num, make, type) RLIKE '" + searchfield.getText() +"' ORDER BY ID DESC");//manages result
            while (res.next()) {
                count = res.getInt("num");
            }

            ResultSetMetaData rsMetaData = (ResultSetMetaData) rs1.getMetaData();//manages result
            int numberOfColumns = rsMetaData.getColumnCount();
            search = new String[count][numberOfColumns];
            String rs[] = new String[numberOfColumns];
            int x = 0;
            while (rs1.next()) {
                rs[0] = "" + rs1.getString("MTOP_NO");
                rs[1] = "" + rs1.getString("fullname").toUpperCase();
                rs[2] = "" + rs1.getString("make").toUpperCase();
                rs[3] = "" + rs1.getString("plate_num");
                rs[4] = "" + rs1.getString("chassis_no");
                rs[5] = "" + rs1.getString("motor_no");
                rs[6] = "" + rs1.getString("ddate");
                rs[7] = "" + rs1.getString("type");
                rs[8] = "" + rs1.getString("action");
                for (int y = 0; y < rs.length; y++) {
                    search[x][y] = rs[y];
                }
                x++;
            }
            jTable1.setModel(new DefaultTableModel(search, col));
            ColumnSize();
            rs1.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchfieldKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    view();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField searchfield;
    // End of variables declaration//GEN-END:variables
}
