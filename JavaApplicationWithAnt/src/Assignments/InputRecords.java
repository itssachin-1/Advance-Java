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
 * 5. Write program to read multiple student details ( 10 records) from user and insert them to student table. 
 * Use for loop and PreparedStatement
 * 
 */
public class InputRecords {
    public static void main(String[] args) throws Exception {
        DBConnection dbcon= new DBConnection();
        Connection con = dbcon.getDBConnection();
        if(con !=null)
            System.out.println("Connection Established!");
        
        Scanner in= new Scanner(System.in);
        System.out.println("How many Student records you want to insert?");
        int n = in.nextInt();
        
        PreparedStatement pst= null;
        for(int i =0; i<n; i++){
            System.out.println("Enter Student "+(i+1)+" details: ");
            int sid= in.nextInt();
            String sname= in.next();
            double gpa= in.nextDouble();
            
            String q1= "insert into Student values(?,?,?)";
            pst= con.prepareStatement(q1);

            pst.setInt(1, sid);
            pst.setString(2, sname);
            pst.setDouble(3, gpa);

            int x= pst.executeUpdate();
            if(x>0)
                System.out.println((i+1)+" record inserted!");        
        }
        PreparedStatement pst1= con.prepareStatement("select * from Student");
        ResultSet rs= pst1.executeQuery();
        
        System.out.println("+----------------------------------+");
        System.out.println("sid\tsname\t\tgpa");
        System.out.println("-----\t---------\t-------");
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t \t"+rs.getDouble(3));
        }
        System.out.println("+----------------------------------+");

        con.close();
//        pst.close();
        pst1.close();
    }
    
}
