/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplicationwithant;
import java.sql.*;
/**
 *
 * @author sachin
 */
public class NewClass {
        public static void main(String[] agrs) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        String url ="jdbc:mysql://localhost:3306/test";
        String uname="root";
        String pwd = "mysql01)";
        
        Connection con = DriverManager.getConnection(url,uname,pwd);
        
        if(con!=null)
            System.out.println("Connection established");
        Statement st = con.createStatement();
        String q1 = "create table customer(cid int, cname varchar(10), balance float, city varchar(10), PRIMARY KEY(cid))";
        
        int x = st.executeUpdate(q1);
        
        System.out.println(x);
        con.close();
        
    }
}
