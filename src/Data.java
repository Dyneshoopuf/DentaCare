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
            String query = "select * from registertbl";
            rs = st.executeQuery(query);
            System.out.println("Records from Database:");
            System.out.println();
            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("Full Name");
                String username = rs.getString("Username");
                System.out.println("ID: " + id + " Name: " + name + "Username:" + username);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
