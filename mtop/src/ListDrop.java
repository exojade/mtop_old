
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rayz
 */
public class ListDrop extends javax.swing.JInternalFrame {

    public static String mtop_id = "";
    static Connection conn = null;
    SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
    
    public ListDrop() {
        this.setLocation(10, 10);
        initComponents();
        conn = DB.establishConnection();
        view();
    }

    public static void view() {
        String search[][] = null;
        String col[] = {"MTOP NO", "NAME", "MAKE", "PLATE NO", "CHASSIS NO", "MOTOR NO", "DATE PAID", "TRANSACTION", "ACTION"};
        jTable1.setModel(new DefaultTableModel(search, col));
        ColumnSize();
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
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        from = new com.toedter.calendar.JDateChooser();
        to = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        searchfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("List of Dropped MTOP");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date Range", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText(" From: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("To:");

        jButton1.setText("Go");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        searchfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchfieldKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Search:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(from, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Date from1 = from.getDate();
        Date to1 = to.getDate();
        String from2 = dformat.format(from1).toString();
        String to2 = dformat.format(to1).toString();
        
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("from_date", from2);
            map.put("to_date", to2);
            String report = "reports/list_drop_mtop.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(report);
            JasperPrint jp = JasperFillManager.fillReport(jr, map, conn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("List of Dropped MTOP");
            jv.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String search[][] = null;
        String col[] = {"MTOP NO", "NAME", "MAKE", "PLATE NO", "CHASSIS NO", "MOTOR NO", "DATE PAID", "TRANSACTION", "ACTION"};
       
        Date from1 = from.getDate();
        Date to1 = to.getDate();

        String from2 = dformat.format(from1).toString();
        String to2 = dformat.format(to1).toString();

        try {
            conn.setAutoCommit(true);
            Statement s = (Statement) conn.createStatement();
            s.executeQuery("SELECT MTOP_NO, CONCAT(firstname,' ',lastname) as fullname, plate_num, make, chassis_no, motor_no, ddate, type, action FROM transaction_logs WHERE ddate >= '" + from2 + "' AND ddate <= '" + to2 + "' AND type = 'Dropping' ORDER BY ID DESC");
            ResultSet rs1 = s.getResultSet();//manages result
            int count = 0;
            s = (Statement) conn.createStatement();
            ResultSet res = s.executeQuery("SELECT count(MTOP_NO) as num, CONCAT(firstname,' ',lastname) as fullname, plate_num, make, chassis_no, motor_no, type, action FROM transaction_logs WHERE ddate >= '" + from2 + "' AND ddate <= '" + to2 + "' AND type = 'Dropping' ORDER BY ID DESC");//manages result
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfieldKeyReleased
        String search[][] = null;
        String col[] = {"MTOP NO", "NAME", "MAKE", "PLATE NO", "CHASSIS NO", "MOTOR NO", "DATE PAID", "TRANSACTION", "ACTION"};
       
        Date from1 = from.getDate();
        Date to1 = to.getDate();

        String from2 = dformat.format(from1).toString();
        String to2 = dformat.format(to1).toString();

        try {
            conn.setAutoCommit(true);
            Statement s = (Statement) conn.createStatement();
            s.executeQuery("SELECT MTOP_NO, CONCAT(firstname,' ',lastname) as fullname, plate_num, make, chassis_no, motor_no, ddate, type, action FROM transaction_logs WHERE ddate >= '" + from2 + "' AND ddate <= '" + to2 + "' AND type = 'Dropping' AND CONCAT(MTOP_NO,', ',lastname,', ',firstname,', ',plate_num) RLIKE '" + searchfield.getText() + "' ORDER BY ID DESC");
            ResultSet rs1 = s.getResultSet();//manages result
            int count = 0;
            s = (Statement) conn.createStatement();
            ResultSet res = s.executeQuery("SELECT count(MTOP_NO) as num, CONCAT(firstname,' ',lastname) as fullname, plate_num, make, chassis_no, motor_no, type, action FROM transaction_logs WHERE ddate >= '" + from2 + "' AND ddate <= '" + to2 + "' AND CONCAT(MTOP_NO,', ',lastname,', ',firstname,', ',plate_num) RLIKE '" + searchfield.getText() + "' AND type = 'Dropping' ORDER BY ID DESC");//manages result
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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser from;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField searchfield;
    private com.toedter.calendar.JDateChooser to;
    // End of variables declaration//GEN-END:variables
}
