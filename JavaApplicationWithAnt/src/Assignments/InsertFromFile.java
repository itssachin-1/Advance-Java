// * @author sachin
//9. program to Read data from a text file (student.txt) and insert into student table
//   ( Use prepared statement)

package Assignments;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class InsertFromFile {
    public static void main(String[] args) throws Exception {
        DBConnection dbcon= new DBConnection();
        Connection con = dbcon.getDBConnection();
        if(con != null)
            System.out.println("Connected!");
        
//        Scanner in= new Scanner(System.in);
//        System.out.println("How many customer records you want to insert?");
//        int n = in.nextInt();
        
        // Passing file path as parameter
        File file = new File("/Users/sachin/NetBeansProjects/JavaApplicationWithAnt/src/Assignments/input.txt");
        
        // Creating object of BufferedReader class
        BufferedReader br= new BufferedReader(new FileReader(file));
        String line= null;
        
        PreparedStatement pst= null;
        int i=0;
        while((line= br.readLine()) != null) {
            String tmp[]= line.split(" ");
            
            int sid= Integer.parseInt(tmp[0]);
            String name= tmp[1];
            double gp= Double.parseDouble(tmp[2]);
            
            String q= "insert ignore into student values(?, ?, ?)";
            pst= con.prepareStatement(q);
        
            pst.setInt(1, sid);
            pst.setString(2, name);
            pst.setDouble(3, gp);
        
            int x= pst.executeUpdate();
            if(x>0)
                  i=i+1;      
        }
        System.out.println(i+"record(s) updated!");
        // printing the table
        PreparedStatement ps= con.prepareStatement("select * from student");
        ResultSet rs= ps.executeQuery();
        System.out.println("sid\tsname\tgpa");
        while(rs.next())
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
        con.close();
        br.close();
    }
    
}
