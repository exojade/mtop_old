
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
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
public class Substitution extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddFromVacant
     */
    static Connection conn = null;
    public static String mtop_id = "";
    public String expiredate = "";
    SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
           
    public Substitution() {
        this.setLocation(10, 10);
        initComponents();
        conn = DB.establishConnection();
        OccupiedMTOP();
    }
    
    private void Search(){
      String search[][] = null;
        String col[] = {"Occupied MTOP", "Fullname"};

        try {
            conn.setAutoCommit(true);
            Statement s = (Statement) conn.createStatement();
            s.executeQuery("SELECT vehicle.MTOP_NO, CONCAT(lastname,', ',firstname) as fullname FROM vehicle JOIN operator ON vehicle.MTOP_NO = operator.MTOP_NO AND CONCAT(lastname, firstname) != ' ' AND CONCAT(vehicle.MTOP_NO,lastname, firstname) RLIKE '" + searchfield.getText() + "' ORDER BY vehicle.MTOP_NO");
            ResultSet rs1 = s.getResultSet();//manages result
            int count = 0;
            s = (Statement) conn.createStatement();
            ResultSet res = s.executeQuery("SELECT count(vehicle.MTOP_NO) as num  FROM vehicle JOIN operator ON vehicle.MTOP_NO = operator.MTOP_NO AND CONCAT(lastname, firstname) != ' ' AND CONCAT(vehicle.MTOP_NO,lastname, firstname) RLIKE '" + searchfield.getText() + "' ORDER BY vehicle.MTOP_NO");//manages result
            while (res.next()) {
                count = res.getInt("num");
            }

            ResultSetMetaData rsMetaData = (ResultSetMetaData) rs1.getMetaData();//manages result
            int numberOfColumns = rsMetaData.getColumnCount();
            search = new String[count][numberOfColumns];
            String rs[] = new String[numberOfColumns];
            int x = 0;
            while (rs1.next()) {
                rs[0] = "" + rs1.getString("vehicle.MTOP_NO");
                rs[1] = "" + rs1.getString("fullname");
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
    

    private void OccupiedMTOP() {
        String search[][] = null;
        String col[] = {"Occupied MTOP", "Fullname"};

        try {
             paid.setEnabled(true);
            
            conn.setAutoCommit(true);
            Statement s = (Statement) conn.createStatement();
            s.executeQuery("SELECT vehicle.MTOP_NO, CONCAT(lastname,', ',firstname) as fullname FROM vehicle JOIN operator ON vehicle.MTOP_NO = operator.MTOP_NO AND (status != 'DROP') AND firstname !=' ' ORDER BY vehicle.MTOP_NO");
            ResultSet rs1 = s.getResultSet();//manages result
            int count = 0;
            s = (Statement) conn.createStatement();
            ResultSet res = s.executeQuery("SELECT count(vehicle.MTOP_NO) as num, CONCAT(lastname,', ',firstname) as fullname FROM vehicle JOIN operator ON vehicle.MTOP_NO = operator.MTOP_NO AND (status != 'DROP') AND firstname !=' ' ORDER BY vehicle.MTOP_NO");//manages result
            while (res.next()) {
                count = res.getInt("num");
            }

            ResultSetMetaData rsMetaData = (ResultSetMetaData) rs1.getMetaData();//manages result
            int numberOfColumns = rsMetaData.getColumnCount();
            search = new String[count][numberOfColumns];
            String rs[] = new String[numberOfColumns];
            int x = 0;
            while (rs1.next()) {
                rs[0] = "" + rs1.getString("vehicle.MTOP_NO");
                rs[1] = "" + rs1.getString("fullname");
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

    void Clear() {
        address.setText("");
        make1.setText("");
        motor1.setText("");
        chassis1.setText("");
        plate1.setText("");
        make.setText("");
        motor.setText("");
        chassis.setText("");
        plate.setText("");
        amount.setText("");
        fullname.setText("");
        or_num.setText("");
        yearModel1.setText("");
        yearModel.setText("");
    }

    private void ColumnSize() {
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        motor1 = new javax.swing.JTextField();
        make1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        chassis1 = new javax.swing.JTextField();
        plate1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        yearModel1 = new javax.swing.JTextField();
        cert2 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        mpcurrent = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        expcurrent = new com.toedter.calendar.JDateChooser();
        save = new javax.swing.JButton();
        searchfield = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        address = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        mtop_no = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        motor = new javax.swing.JTextField();
        make = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        chassis = new javax.swing.JTextField();
        plate = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        yearModel = new javax.swing.JTextField();
        cert = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notes = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        or_num = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        paid = new com.toedter.calendar.JDateChooser();
        MonthCombo = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        picture = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Substitution of Unit");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Occupied MTOP", "Fullname"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setFocusable(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unit To Be Registered", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Make");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Motor Number:");

        motor1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        motor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motor1ActionPerformed(evt);
            }
        });

        make1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        make1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                make1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Chassis / Serial Number:");

        chassis1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        plate1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        plate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plate1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Plate Number:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Year Model:");

        yearModel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        yearModel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearModel1ActionPerformed(evt);
            }
        });

        cert2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cert2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cert2ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Certficate of Registration Number");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Current MP Expiration Date");

        mpcurrent.setDateFormatString("MMMM dd, yyyy");
        mpcurrent.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Current Expiration Date");

        expcurrent.setDateFormatString("MMMM dd, yyyy");
        expcurrent.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(make1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(motor1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(yearModel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cert2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chassis1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(mpcurrent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plate1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(expcurrent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addGap(34, 34, 34))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(plate1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(expcurrent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(make1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                    .addComponent(motor1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cert2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(yearModel1))))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mpcurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chassis1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))))
        );

        save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        save.setText("Substitute");
        save.setEnabled(false);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        searchfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchfieldKeyPressed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        address.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        fullname.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        mtop_no.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unit Withdrawn / Substituted", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Make");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Motor Number:");

        motor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        motor.setEnabled(false);
        motor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motorActionPerformed(evt);
            }
        });

        make.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        make.setEnabled(false);
        make.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Chassis / Serial Number:");

        chassis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chassis.setEnabled(false);

        plate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        plate.setEnabled(false);
        plate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plateActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Plate Number:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Year Model:");
        jLabel22.setToolTipText("");
        jLabel22.setOpaque(true);

        yearModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        yearModel.setEnabled(false);
        yearModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearModelActionPerformed(evt);
            }
        });

        cert.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cert.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Certficate of Registration Number");

        notes.setColumns(20);
        notes.setRows(5);
        notes.setEnabled(false);
        jScrollPane2.setViewportView(notes);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Note:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(make, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(plate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chassis, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(motor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yearModel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cert, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(86, 86, 86))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(yearModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(make, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(motor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(plate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chassis)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(11, 11, 11))))
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Amount Paid:");

        amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("OR Number:");

        or_num.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Date Paid:");

        paid.setDateFormatString("MM-dd-yyyy");

        MonthCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthComboActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Expiration Date:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addGap(81, 81, 81)
                            .addComponent(jButton1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mtop_no, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(or_num, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(paid, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(MonthCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(mtop_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(or_num, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(paid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(save))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void motor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motor1ActionPerformed

    private void make1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_make1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_make1ActionPerformed

    private void plate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plate1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            conn.setAutoCommit(true);
            PreparedStatement pst = null;//query statement
            ResultSet rs = null;//manages result
            int row = jTable1.getSelectedRow();
            String table_clicked_id = jTable1.getModel().getValueAt(row, 0).toString();
            mtop_id = table_clicked_id;
            save.setEnabled(true);
            notes.setEnabled(true);
            
            String gender = null;

            Statement s = (Statement) conn.createStatement();
            s.executeQuery("SELECT v.MTOP_NO, CONCAT(lastname,', ',firstname) as fullname, address, Gender, plate_no, reg_no, make, chassis_no, yearModel, released_date, mp_expiration_date, route, reg_no, motor_no, expiration_date, status, care_of FROM vehicle v, operator o WHERE v.MTOP_NO = o.MTOP_NO AND v.MTOP_NO ='" + mtop_id + "'");
            ResultSet result = s.getResultSet();
            if (result.next()) {
                mtop_no.setText(mtop_id);
                fullname.setText(result.getString("fullname"));
                address.setText(result.getString("address"));
                make.setText(result.getString("make"));
                motor.setText(result.getString("motor_no"));
                chassis.setText(result.getString("chassis_no"));
                plate.setText(result.getString("plate_no"));
                cert.setText(result.getString("reg_no"));
                yearModel.setText(result.getString("yearModel"));
                expiredate = result.getString("expiration_date");
                notes.setText(result.getString("care_of"));
                mpcurrent.setDate(result.getDate("mp_expiration_date"));
                expcurrent.setDate(result.getDate("expiration_date"));
                gender = (result.getString("Gender"));
                if (gender == "")
                {
                    gender = "Male";
                }
                
                
                if (gender.equals("Male"))
                {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("male2.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                    picture.setIcon(imageIcon);
                }
                else
                {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon("female2.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                    picture.setIcon(imageIcon);
                }
                
                
                
                
                
                String [] dateParts = expiredate.split("-");
               
                String year = dateParts[0];
                String month = dateParts[1];
                String day = dateParts[2];
                
                String datenowyear = "01, " + year;

                MonthCombo.removeAllItems();
                MonthCombo.addItem("January " + datenowyear);
                MonthCombo.addItem("February " + datenowyear);
                MonthCombo.addItem("March " + datenowyear);
                MonthCombo.addItem("April " + datenowyear);
                MonthCombo.addItem("May " + datenowyear);
                MonthCombo.addItem("June " + datenowyear);
                MonthCombo.addItem("July " + datenowyear);
                MonthCombo.addItem("August " + datenowyear);
                MonthCombo.addItem("September " + datenowyear);
                MonthCombo.addItem("October " + datenowyear);
                MonthCombo.addItem("November " + datenowyear);
                MonthCombo.addItem("December " + datenowyear);
                
                expiredate = year + "-" + month + "-01";
                
                   String expdate = "lol";
   SimpleDateFormat targetFormat = new SimpleDateFormat("MMMM dd, yyyy");
  
   try {
     Date initDate = new SimpleDateFormat("yyyy-MM-dd").parse(expiredate.toString());
     expdate = targetFormat.format(initDate);

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null,ex.toString());
    }
   
   
   MonthCombo.setSelectedItem(expdate);
                
                
                
            }

        } catch (Exception e) {
            //e.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        PreparedStatement pst3 = null;
        

        Date date_paid = paid.getDate();
        String paid_date = dformat.format(date_paid);
        String name[] = fullname.getText().split(",");
        String lastname = name[0];
        String firstname = name[1];
        
        Date nowdate = new Date();
        
        String expdate = "lol";
   SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
  
   try {
     Date initDate = new SimpleDateFormat("MMMM dd, yyyy").parse(MonthCombo.getSelectedItem().toString());
     expdate = targetFormat.format(initDate);

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null,ex.toString());
    }
        
        

        // Initialization
        String query1 = "UPDATE vehicle SET plate_no = ?, make = ?, motor_no = ?, chassis_no = ?, yearModel = ?, plate_no1 = ?, make1 = ?, motor_no1 = ?, chassis_no1 = ?, yearModel1 = ?, reg_no = ?, expiration_date = ?, care_of = ?, released_date = ? WHERE MTOP_NO = ?";
        
        String query2 = "INSERT INTO fees(substitution_fee, or_no, date_paid, MTOP_NO) values( ? , ? , ? , ?)";

        String query3 = "INSERT INTO transaction_logs(MTOP_NO, firstname, lastname, make, plate_num, chassis_no, motor_no, ddate, type, action) values( ? , ? , ?, ?, ?, ? ,? ,?, ? , ?)";

        String subs = "Substituted from Plate Number: " + plate.getText() + ", Make: " + make.getText() + ", Motor No: " + motor.getText() + ", Chassis Number: " + chassis.getText() + "";

        try {
            conn.setAutoCommit(false);
            pst = (PreparedStatement) conn.prepareStatement(query1);
            
            pst.setString(1, plate1.getText());
            pst.setString(2, make1.getText());
            pst.setString(3, motor1.getText());
            pst.setString(4, chassis1.getText());
            pst.setString(5, yearModel1.getText());
            pst.setString(6, plate.getText());
            pst.setString(7, make.getText());
            pst.setString(8, motor.getText());
            pst.setString(9, chassis.getText());
            pst.setString(10, yearModel.getText());     
            pst.setString(11, cert2.getText());
            pst.setString(12, expdate);
            pst.setString(13, notes.getText());
            pst.setString(14, dformat.format(nowdate).toString());
            pst.setString(15, mtop_no.getText());
            pst.execute();

            pst2 = (PreparedStatement) conn.prepareStatement(query2);
            pst2.setString(1, amount.getText());
            pst2.setString(2, or_num.getText());
            pst2.setString(3, paid_date);
            pst2.setString(4, mtop_no.getText());
            pst2.execute();

            pst3 = (PreparedStatement) conn.prepareStatement(query3);
            pst3.setString(1, mtop_no.getText());
            pst3.setString(2, firstname);
            pst3.setString(3, lastname);
            pst3.setString(4, make.getText());
            pst3.setString(5, plate.getText());
            pst3.setString(6, chassis.getText());
            pst3.setString(7, motor.getText());
            pst3.setString(8, dformat.format(date_paid).toString());
            pst3.setString(9, "Substitution");
            pst3.setString(10, subs);
            pst3.execute();

            pst.close();
            pst2.close();
            pst3.close();

            conn.commit();
            JOptionPane.showMessageDialog(null, "Succesfully Substituted!");
            List.view();
            OccupiedMTOP();
            Clear();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {

            }
        }

    }//GEN-LAST:event_saveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        OccupiedMTOP();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void yearModel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearModel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearModel1ActionPerformed

    private void searchfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfieldKeyPressed
        Search();
    }//GEN-LAST:event_searchfieldKeyPressed

    private void cert2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cert2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cert2ActionPerformed

    private void MonthComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthComboActionPerformed

    }//GEN-LAST:event_MonthComboActionPerformed

    private void yearModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearModelActionPerformed

    private void plateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plateActionPerformed

    private void makeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_makeActionPerformed

    private void motorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> MonthCombo;
    private javax.swing.JLabel address;
    private javax.swing.JTextField amount;
    private javax.swing.JTextField cert;
    private javax.swing.JTextField cert2;
    private javax.swing.JTextField chassis;
    private javax.swing.JTextField chassis1;
    private com.toedter.calendar.JDateChooser expcurrent;
    private static javax.swing.JLabel fullname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField make;
    private javax.swing.JTextField make1;
    private javax.swing.JTextField motor;
    private javax.swing.JTextField motor1;
    private com.toedter.calendar.JDateChooser mpcurrent;
    private static javax.swing.JLabel mtop_no;
    private javax.swing.JTextArea notes;
    private javax.swing.JTextField or_num;
    private com.toedter.calendar.JDateChooser paid;
    private javax.swing.JLabel picture;
    private javax.swing.JTextField plate;
    private javax.swing.JTextField plate1;
    private javax.swing.JButton save;
    private javax.swing.JTextField searchfield;
    private javax.swing.JTextField yearModel;
    private javax.swing.JTextField yearModel1;
    // End of variables declaration//GEN-END:variables
}
