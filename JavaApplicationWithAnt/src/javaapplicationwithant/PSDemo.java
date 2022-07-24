/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplicationwithant;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author sachin
 */
public class PSDemo {
    public static void main(String[] args) throws Exception {
        DBConnection dbcon = new DBConnection(); // class - getDBConnection()
        Connection con = dbcon.getDBConnection();
        if(con != null)
            System.out.println("Connected!!");
        
        Scanner in= new Scanner(System.in);
        System.out.println("How many customer records you want to insert?");
        int n = in.nextInt();
        
        PreparedStatement pst= null;
        for(int i=0; i<n; i++){
            System.out.println("Enter customer "+(i+1)+"details");
            int id= in.nextInt();
            String name= in.next();
            double bal= in.nextDouble();
            String city= in.next();
            
            String q1 = "insert into customer values(?,?,?,?)";
            pst= con.prepareStatement(q1);
            
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setDouble(3, bal);
            pst.setString(4, city);

            int x= pst.executeUpdate();
            if(x>0)
                System.out.println((i+1)+" records updated!");
        }
        PreparedStatement pst1= con.prepareStatement("select * from customer");
         ResultSet rs= pst1.executeQuery();
         while(rs.next())
             System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
        con.close();
//        pst.close();
        
    }
}
