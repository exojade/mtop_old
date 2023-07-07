
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Image;
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
public class TransferOfOwnership extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddFromVacant
     */
    static Connection conn = null;
    public static String mtop_id = "";
    SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
    

    public TransferOfOwnership() {
        this.setLocation(10, 10);
        initComponents();
        conn = DB.establishConnection();
        OccupiedMTOP();
        picture.setText("");
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
        lname.setText("");
        fname.setText("");
        address.setText("");
        make.setText("");
        motor.setText("");
        chassis.setText("");
        plate.setText("");
        amount.setText("");
        or_num.setText("");
        addr.setText("");
        fullname.setText("");
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
        lname = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        addr = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        jLabel12 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        or_num = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        paid = new com.toedter.calendar.JDateChooser();
        picture = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Transfer of Ownership");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transfer  To", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });

        fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });

        addr.setColumns(20);
        addr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addr.setRows(4);
        jScrollPane2.setViewportView(addr);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Address:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Firstname:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Lastname: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(466, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(22, 22, 22)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(12, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3))
                    .addGap(4, 4, 4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 62, Short.MAX_VALUE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                    .addContainerGap()))
        );

        save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        save.setText("Transfer");
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(make, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(motor, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(chassis, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 97, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(make)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plate)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chassis, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(motor))
                        .addGap(68, 68, 68))))
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

        picture.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchfield)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(or_num, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(paid, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(picture)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mtop_no, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(picture))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mtop_no, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(or_num, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(6, 6, 6)
                                    .addComponent(paid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(save)))
                .addGap(20, 34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            conn.setAutoCommit(true);
            PreparedStatement pst = null;//query statement
            ResultSet rs = null;//manages result
            int row = jTable1.getSelectedRow();
            String table_clicked_id = jTable1.getModel().getValueAt(row, 0).toString();
            mtop_id = table_clicked_id;
            save.setEnabled(true);
            
            
            String gender = null;
            Statement s = (Statement) conn.createStatement();
            s.executeQuery("SELECT v.MTOP_NO, CONCAT(lastname,', ',firstname) as fullname, address, Gender, plate_no, make, chassis_no, released_date, route, reg_no, motor_no, expiration_date, status, care_of FROM vehicle v, operator o WHERE v.MTOP_NO = o.MTOP_NO AND v.MTOP_NO ='" + mtop_id + "'");
            ResultSet result = s.getResultSet();
            if (result.next()) {
                mtop_no.setText(mtop_id);
                fullname.setText(result.getString("fullname"));
                address.setText(result.getString("address"));
                make.setText(result.getString("make"));
                motor.setText(result.getString("motor_no"));
                chassis.setText(result.getString("chassis_no"));
                plate.setText(result.getString("plate_no"));
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
        // Initialization
        String query1 = "UPDATE operator SET lastname = ?, firstname = ?, address = ? WHERE MTOP_NO = ?";
        String query2 = "INSERT INTO fees(transfer_fee, or_no, date_paid, MTOP_NO) values( ? , ? , ? , ?)";
        String query3 = "INSERT INTO transaction_logs(MTOP_NO, firstname, lastname, make, plate_num, chassis_no, motor_no, ddate, type, action) values( ? , ? , ?, ?, ?, ? ,? ,?, ? , ?)";
        String subs = "Transfer of Ownership from " + firstname + " " + lastname + " to " + fname.getText() + " " + lname.getText();
        try {
            conn.setAutoCommit(false);

            pst = (PreparedStatement) conn.prepareStatement(query1);
            pst.setString(1, lname.getText());
            pst.setString(2, fname.getText());
            pst.setString(3, addr.getText());
            pst.setString(4, mtop_no.getText());
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
            pst3.setString(9, "Transfer of Ownership");
            pst3.setString(10, subs);
            pst3.execute();

            pst.close();
            pst2.close();
            pst3.close();

            conn.commit();
            JOptionPane.showMessageDialog(null, "Transfer of Ownership Complete");
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

    private void motorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motorActionPerformed

    private void makeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_makeActionPerformed

    private void plateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plateActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void searchfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfieldKeyPressed
        Search();
    }//GEN-LAST:event_searchfieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addr;
    private javax.swing.JLabel address;
    private javax.swing.JTextField amount;
    private javax.swing.JTextField chassis;
    private javax.swing.JTextField fname;
    private static javax.swing.JLabel fullname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField make;
    private javax.swing.JTextField motor;
    private static javax.swing.JLabel mtop_no;
    private javax.swing.JTextField or_num;
    private com.toedter.calendar.JDateChooser paid;
    private javax.swing.JLabel picture;
    private javax.swing.JTextField plate;
    private javax.swing.JButton save;
    private javax.swing.JTextField searchfield;
    // End of variables declaration//GEN-END:variables
}
