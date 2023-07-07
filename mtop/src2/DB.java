/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.InetAddress;
import java.sql.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DB {

    static int flag = 0;

    public static Connection establishConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex1) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            BufferedReader br = null;
            File f = new File("connection.cfg");
            if (!f.exists()) {
                File file = new File("connection.cfg");
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                String ip = InetAddress.getLocalHost().getHostAddress();
                String note = "ipserver : " + ip + " \nuser : mtop \npassword : s3cr3t \ndatabase : mtop \nport : 3306 \n";
                fw.write(note);
                fw.flush();
                fw.close();
            }
            String line;
            String str = "";
            br = new BufferedReader(new FileReader("connection.cfg"));
            while ((line = br.readLine()) != null) {
                String r[] = line.split(":");
                if (str.isEmpty()) {
                    str = r[1];
                } else {
                    str = str + "|" + r[1];
                }
            }
            StringTokenizer st = new StringTokenizer(str, "|");
            String ip = st.nextToken().trim();
            String user = st.nextToken().trim();
            String password = st.nextToken().trim();
            String database = st.nextToken().trim();
            String port = st.nextToken().trim();
            String connection = "jdbc:mysql://" + ip + ":" + port + "/" + database;
            conn = DriverManager.getConnection(connection, user, password);
            flag = 1;
        } catch (Exception ex2) {
            JOptionPane.showMessageDialog(null, ex2);
            ex2.printStackTrace();
            System.exit(0);
        }
        return conn;
    }
}
