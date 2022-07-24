/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignments;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sachin
 2. Write a program to demonstrate sub queries. 
    Provide customerdetails who is having maximum balance using subquery.
 */
public class MaxBal {
     public static void main(String[] args) throws Exception {
        DBConnection dbcon = new DBConnection(); // class - getDBConnection()
        Statement st;
        ResultSet rs;
        try (Connection con = dbcon.getDBConnection()) {
            if(con != null)
                System.out.println("Connected!!");
            st = con.createStatement();
            String q= "select * from customer where balance=(select max(balance) from customer)";
            rs = st.executeQuery(q);
            System.out.println("+------------------------------+");
            System.out.println("cid\tcname\tbalance\tcity");
            System.out.println("----\t-----\t-------\t----");
            while(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
            }
            System.out.println("+------------------------------+");
        }
        st.close();
        rs.close();
    }
}
