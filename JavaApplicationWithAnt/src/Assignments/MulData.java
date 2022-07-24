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
 *  3. Write a program to select data from multiple columns of multiple tables. 
 *  Use customers and student tables to select 2 fields from each table.
 * 
 */

public class MulData {
    public static void main(String[] args) throws Exception {
        DBConnection dbcon = new DBConnection(); // class - getDBConnection()
        Statement st;
        ResultSet rs;
        
        try (Connection con = dbcon.getDBConnection()) {
            if(con != null)
                System.out.println("Connected!!");
            
            st = con.createStatement();
            String q= "select c.cid, c.balance, s.sname, s.gpa from customer c, student s where c.cname= s.sname;";
            rs = st.executeQuery(q);
            
            System.out.println("+---------------------------------+");
            System.out.println("cid\tbalance\tsname\tgpa");
            System.out.println("----\t-----\t-------\t-----------");
            
            while(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
            }
            System.out.println("+---------------------------------+");
        }
        st.close();
        rs.close();
    }
    
}
