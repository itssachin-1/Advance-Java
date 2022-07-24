/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignments;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author sachin
 *  6. Demonstrate select query using Prepared Statement by reading data from user
 * ( Read gpa and provide details of students whose gpa less than that entered)
 * 
 */
public class gpa {
    public static void main(String[] args) throws Exception {
         DBConnection dbcon = new DBConnection();
         Connection con= dbcon.getDBConnection();
         
         if(con != null)
             System.out.println("Connected!");
         
        Scanner in= new Scanner(System.in);
        System.out.println("Enter GPA of Student: ");
        double gpa = in.nextDouble();
        
        PreparedStatement pst= null;
        String q= "select * from student where gpa< ?";
        pst= con.prepareStatement(q);
        
        pst.setDouble(1, gpa);
        
        ResultSet rs= pst.executeQuery();
        
        System.out.println("+------------------------+");
        System.out.println("sid\tsname\tgpa");
        System.out.println("-----\t-------\t------");
        
        while(rs.next()){
            System.out.println(rs.getInt("sid")+"\t"+rs.getString("sname")+"\t"+rs.getDouble("gpa"));
        }
        System.out.println("+------------------------+");

        con.close();
        pst.close();
       
    }
    
    
}
