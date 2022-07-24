/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

1. Write a program to select specfic columns (atleast 2 cols) from customers table with multiple conditions
 (atleast two conditions)

 */

package Assignments;

import java.sql.*;

/**
 *
 * @author sachin
 */
public class SelectCol {
    public static void main(String[] args) throws Exception {
        DBConnection dbcon = new DBConnection(); // class - getDBConnection()
        Statement st;
        ResultSet rs;
        try (Connection con = dbcon.getDBConnection()) {
            if(con != null)
                System.out.println("Connected!!");
            st = con.createStatement();
            String q= "select cid, cname, balance from customer where balance<40000 and cid!= 2222";
            rs = st.executeQuery(q);
            System.out.println("+-----------------------+");
            System.out.println("cid\tcname\tbalance");
            System.out.println("----\t-----\t-------");
            while(rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
            }   System.out.println("+-----------------------+");
        }
        st.close();
        rs.close();
    }
}
