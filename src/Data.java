/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dentalsoftwareapp;

/**
 *
 * @author Roy
 */
import java.sql.*;

public class Data {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Data() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdb", "root", "");
            st = con.createStatement();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);

        }

    }

    public void getData() {
        try {
            String data = "SELECT * from registertbl";
            rs = st.executeQuery(data);

            while (rs.next()) {
                System.out.println("Records from Database:");
                System.out.println();

                String id = rs.getString("ID");
                String name = rs.getString("Full Name");
                String username = rs.getString("Username");
                System.out.println("ID: " + id + " Name: " + name + "Username:" + username);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("No data found");
        }
    }

    public void checkLicense() {
        try {
            int x = 0;
            String checkLicense = "SELECT * from keytbl";
            rs = st.executeQuery(checkLicense);

            while (rs.next()) {
                x += 1;
            }
            if (x == 0) {
                System.out.println("There is no license key available to use");
                System.out.println("Force closing the app...");
                System.exit(1);
            }
            else if (x == 1) {
                System.out.println("1 License found and is ready to use");
            } else if (x > 1) {
                System.out.println("Found more than 1 license! If you're one of the devs of this software, dispose multiple license immediately!");
            }
        } catch (Exception ex) {

        }
    }
}
