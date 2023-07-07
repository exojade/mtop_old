
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
import java.awt.Container;
import java.text.ParseException;
import javax.swing.JScrollPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rayz
 */
public class Renew extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddFromVacant
     */
    
    
   
    
    static Connection conn = null;
    public static String mtop_id = "";
    SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
    public String mp_expcurrent = "";
    
    private void SearchName() {
      String search[][] = null;
        String col[] = {"Occupied MTOP", "Fullname"};
        

        try {
            
            paid.setEnabled(true);
            conn.setAutoCommit(true);
            Statement s = (Statement) conn.createStatement();
            s.executeQuery("SELECT vehicle.MTOP_NO, CONCAT(lastname,', ',firstname) as fullname FROM vehicle JOIN operator ON vehicle.MTOP_NO = operator.MTOP_NO AND CONCAT(lastname, firstname) != ' ' AND CONCAT(vehicle.MTOP_NO,lastname, firstname) RLIKE '" + searchfield.getText() + "' and expiration_date <= NOW() ORDER BY vehicle.MTOP_NO");
            ResultSet rs1 = s.getResultSet();//manages result
            int count = 0;
            s = (Statement) conn.createStatement();
            ResultSet res = s.executeQuery("SELECT count(vehicle.MTOP_NO) as num  FROM vehicle JOIN operator ON vehicle.MTOP_NO = operator.MTOP_NO AND CONCAT(lastname, firstname) != ' ' AND CONCAT(vehicle.MTOP_NO,lastname, firstname) RLIKE '" + searchfield.getText() + "' and expiration_date <= NOW() ORDER BY vehicle.MTOP_NO");//manages result
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

    public Renew() {
        this.setLocation(10, 10);
        initComponents();
        conn = DB.establishConnection();

        OccupiedMTOP();
       
    }

    private void OccupiedMTOP() {
        String search[][] = null;
        String col[] = {"Occupied MTOP", "Fullname"};

        try {
            
         
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            year=year + 3;
            String yearInString = String.valueOf(year);
            
            String datenowyear = "1, " + yearInString;
            
            
            MonthCombo.addItem("Jan " + datenowyear);
            MonthCombo.addItem("Feb " + datenowyear);
            MonthCombo.addItem("Mar " + datenowyear);
            MonthCombo.addItem("Apr " + datenowyear);
            MonthCombo.addItem("May " + datenowyear);
            MonthCombo.addItem("Jun " + datenowyear);
            MonthCombo.addItem("Jul " + datenowyear);
            MonthCombo.addItem("Aug " + datenowyear);
            MonthCombo.addItem("Sep " + datenowyear);
            MonthCombo.addItem("Oct " + datenowyear);
            MonthCombo.addItem("Nov " + datenowyear);
            MonthCombo.addItem("Dec " + datenowyear);
            
            
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
        lastname.setText("");
        firstname.setText("");
        address.setText("");
        mtop_num.setText("");
        make.setText("");
        lastname.setText("");
        motor.setText("");
        chassis.setText("");
        plate.setText("");
        cert.setText("");
        route.setText("");
        filling_fee.setText("");
        franchise_fee.setText("");
        mayors_permit_fee.setText("");
        or_num.setText("");
        lastname.setText("");
        penalty.setText("");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        firstname = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        motor = new javax.swing.JTextField();
        make = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cert = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        route = new javax.swing.JTextField();
        chassis = new javax.swing.JTextField();
        plate = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mtop_num = new javax.swing.JTextField();
        expiration_date = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        note = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        gender = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        mpexpdate = new com.toedter.calendar.JDateChooser();
        save = new javax.swing.JButton();
        searchfield = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        filling_fee = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        mayors_permit_fee = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        or_num = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        paid = new com.toedter.calendar.JDateChooser();
        franchise_fee = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        penalty = new javax.swing.JTextField();
        MonthCombo = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        releasedate = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Renew");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Lastname: ");

        lastname.setEditable(false);
        lastname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastname.setEnabled(false);
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Firstname:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Address:");

        address.setEditable(false);
        address.setColumns(20);
        address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        address.setRows(4);
        address.setEnabled(false);
        jScrollPane2.setViewportView(address);

        firstname.setEditable(false);
        firstname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstname.setEnabled(false);
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Make");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Motor Number:");

        motor.setEditable(false);
        motor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        motor.setEnabled(false);
        motor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motorActionPerformed(evt);
            }
        });

        make.setEditable(false);
        make.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        make.setEnabled(false);
        make.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Cert. of Reg Number:");

        cert.setEditable(false);
        cert.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cert.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Chassis / Serial Number:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Route:");

        route.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        route.setEnabled(false);

        chassis.setEditable(false);
        chassis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chassis.setEnabled(false);

        plate.setEditable(false);
        plate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        plate.setEnabled(false);
        plate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plateActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Plate Number:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("MTOP NO:");

        mtop_num.setEditable(false);
        mtop_num.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mtop_num.setEnabled(false);
        mtop_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mtop_numActionPerformed(evt);
            }
        });

        expiration_date.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Expiration Date:");

        note.setColumns(20);
        note.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        note.setRows(4);
        note.setEnabled(false);
        jScrollPane3.setViewportView(note);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Note");

        gender.setEditable(false);
        gender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gender.setEnabled(false);
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Gender:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("MP Expiration Date:");

        mpexpdate.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(route, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(motor))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(mtop_num, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(make, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(plate, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cert, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(expiration_date, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mpexpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(chassis, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1))
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel18)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mtop_num, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(make, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chassis, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mpexpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(expiration_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(route, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(motor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cert, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        save.setText("Update");
        save.setEnabled(false);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        searchfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchfieldActionPerformed(evt);
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
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fees", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Filling Fee:");

        filling_fee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Franchise Fee:");

        mayors_permit_fee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Mayor's Permit Fee:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("OR Number:");

        or_num.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Date Paid:");

        paid.setDateFormatString("MM-dd-yyyy");

        franchise_fee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Expiration Date:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Penalty:");

        penalty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        MonthCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthComboActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Released Date:");

        releasedate.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filling_fee, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(franchise_fee, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mayors_permit_fee, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(penalty, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(releasedate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(or_num, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(paid, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filling_fee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(franchise_fee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mayors_permit_fee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(penalty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(releasedate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(or_num, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchfield)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(save)))
                .addGap(0, 8, Short.MAX_VALUE))
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

           filling_fee.setText("400.00");
            franchise_fee.setText("325.00");
            filling_fee.setEnabled(true);
            franchise_fee.setEnabled(true);
            mayors_permit_fee.setEnabled(true);
            or_num.setEnabled(true);
            note.setEnabled(true);
           
            save.setEnabled(true);
            penalty.setEnabled(true);
         
            mtop_num.setText(mtop_id);
            Statement s = (Statement) conn.createStatement();
            s.executeQuery("SELECT v.MTOP_NO, lastname, firstname, address, Gender, plate_no, make, chassis_no, released_date, route, reg_no, motor_no, expiration_date, status, mp_expiration_date, care_of FROM vehicle v, operator o WHERE v.MTOP_NO = o.MTOP_NO AND v.MTOP_NO ='" + mtop_id + "'");
            ResultSet result = s.getResultSet();
            if (result.next()) {
                lastname.setText(result.getString("lastname"));
                firstname.setText(result.getString("firstname"));
                gender.setText(result.getString("Gender"));
                address.setText(result.getString("address"));
                make.setText(result.getString("make"));
                motor.setText(result.getString("motor_no"));
                chassis.setText(result.getString("chassis_no"));
                plate.setText(result.getString("plate_no"));
                cert.setText(result.getString("reg_no"));
                route.setText(result.getString("route"));
                expiration_date.setDate(result.getDate("expiration_date"));
                mp_expcurrent = (result.getString("mp_expiration_date"));
                mpexpdate.setDate(result.getDate("mp_expiration_date"));
                releasedate.setDate(result.getDate("released_date"));
                note.setText(result.getString("care_of"));
                Calendar today = Calendar.getInstance(); 
                Calendar nextYearToday = today;
                nextYearToday.add(Calendar.YEAR, 1);
                
              
                
         
                //mp_exp_date.setDate();
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        PreparedStatement pst3 = null;
        PreparedStatement pst6 = null;

        // Initialization
        Date date_paid = paid.getDate();
        String paid_date = dformat.format(date_paid);
        
         String expdate = "lol";
         
            
            Date nowdate = new Date();
            
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            String yearInString = String.valueOf(year);
            
            String mp_date = yearInString + "-12-31";
         
      
        
        SimpleDateFormat originalFormat = new SimpleDateFormat("MMM dd, yyyy");
  
   Date datenow;
   
   //expiration date
    SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
   try {
     Date initDate = new SimpleDateFormat("MMM dd, yyyy").parse(MonthCombo.getSelectedItem().toString());
     expdate = targetFormat.format(initDate);

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null,ex.toString());
    }
   
   //end of expiration date
        
        String filling = filling_fee.getText();
        String franchise = franchise_fee.getText();
        String mayors = mayors_permit_fee.getText();

        String mtop = mtop_num.getText();
        String route1 = route.getText();
        String or_no = or_num.getText();

        String query1 = "UPDATE vehicle SET route = ?, status = ?, expiration_date = ?, released_date = ?, care_of = ? WHERE MTOP_NO = ?";
        String query2 = "INSERT INTO fees(filling_fee, franchise_fee, mayors_permit"
                + "_fee, or_no, penalty, date_paid, MTOP_NO ) values( ? , ? , ? , ? , ? , ?, ? )";
        
        String query3 = null;
        if (!mayors.isEmpty() || mayors.trim().length() != 0) {
            mp_expcurrent = mp_date;
        }
        
        query3 = "UPDATE vehicle SET mp_expiration_date = ? WHERE MTOP_NO = ?";
        String query6 = "INSERT INTO transaction_logs(MTOP_NO, firstname, lastname, make, plate_num, chassis_no, motor_no, ddate, type, action) values( ? , ? , ?, ?, ?, ? ,? ,?, ? , ?)";
        try {
            conn.setAutoCommit(false);
            pst = (PreparedStatement) conn.prepareStatement(query1);
            pst.setString(1, route1);
            pst.setString(2, "For Release");
            pst.setString(3, expdate);
            pst.setString(4, dformat.format(nowdate).toString());
            pst.setString(5, note.getText());
            pst.setString(6, mtop);
            pst.execute();

            pst2 = (PreparedStatement) conn.prepareStatement(query2);
            pst2.setString(1, filling);
            pst2.setString(2, franchise);
            pst2.setString(3, mayors);
            pst2.setString(4, or_no);
            pst2.setString(5, penalty.getText());
            pst2.setString(6, paid_date);
            pst2.setString(7, mtop);
            pst2.execute();
            
            pst3 = (PreparedStatement) conn.prepareStatement(query3);
            pst3.setString(1, mp_expcurrent);
            pst3.setString(2, mtop);
            pst3.execute();
            
            pst6 = (PreparedStatement) conn.prepareStatement(query6);
            pst6.setString(1, mtop);
            pst6.setString(2, firstname.getText());
            pst6.setString(3, lastname.getText());
            pst6.setString(4, make.getText());
            pst6.setString(5, plate.getText());
            pst6.setString(6, chassis.getText());
            pst6.setString(7, motor.getText());
            pst6.setString(8, dformat.format(date_paid).toString());
            pst6.setString(9, "Renew");
            pst6.setString(10, "Application For MTOP to Operate an MCH Service");
            pst6.execute();

            pst.close();
            pst2.close();
            pst6.close();

            conn.commit();
            JOptionPane.showMessageDialog(null,"Waiting For Approval. Updating Successfully ");
            List.view();
            OccupiedMTOP();
            Clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            try {
                conn.rollback();
            } catch (SQLException ex) {

            }
        }

    }//GEN-LAST:event_saveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        OccupiedMTOP();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchfieldActionPerformed
       
    }//GEN-LAST:event_searchfieldActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void searchfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfieldKeyPressed
      SearchName();
      
    }//GEN-LAST:event_searchfieldKeyPressed

    private void mtop_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mtop_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mtop_numActionPerformed

    private void plateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plateActionPerformed

    private void makeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_makeActionPerformed

    private void motorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motorActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void MonthComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonthComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> MonthCombo;
    private javax.swing.JTextArea address;
    private javax.swing.JTextField cert;
    private javax.swing.JTextField chassis;
    private com.toedter.calendar.JDateChooser expiration_date;
    private javax.swing.JTextField filling_fee;
    private javax.swing.JTextField firstname;
    private javax.swing.JTextField franchise_fee;
    private javax.swing.JTextField gender;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField make;
    private javax.swing.JTextField mayors_permit_fee;
    private javax.swing.JTextField motor;
    private com.toedter.calendar.JDateChooser mpexpdate;
    private javax.swing.JTextField mtop_num;
    private javax.swing.JTextArea note;
    private javax.swing.JTextField or_num;
    private com.toedter.calendar.JDateChooser paid;
    private javax.swing.JTextField penalty;
    private javax.swing.JTextField plate;
    private com.toedter.calendar.JDateChooser releasedate;
    private javax.swing.JTextField route;
    private javax.swing.JButton save;
    private javax.swing.JTextField searchfield;
    // End of variables declaration//GEN-END:variables
}
