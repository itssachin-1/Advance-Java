// * @author sachin
// *  4. Program to delete and update a record of student table based on data read from user


package Assignments;
import java.util.Scanner;
import java.sql.*;

public class DelUpRecord4 {
    public static void main(String[] args) throws Exception {
        DBConnection dbcon = new DBConnection(); // class - getDBConnection()
        Connection con = dbcon.getDBConnection();
        if(con != null)
            System.out.println("Connected!!");
        
        Statement st;        
        Scanner sc= new Scanner(System.in);
        st = con.createStatement();

        System.out.println("To delete a record enter 0 | To update a record enter any nonzero no.");
        int x= sc.nextInt();
        if(x==0){
            System.out.println("Enter the name of Student to delete: ");
            String delName= sc.next();
            String q1= "delete from student where sname="+ delName;
            st.executeUpdate(q1);
            System.out.println(delName+" was deleted from records!");
        }
        else{
            System.out.println("Enter the sid of Student to update: ");
            int urRoll= sc.nextInt();
            System.out.println("Enter GPA to update with: ");
            double gp= sc.nextDouble();
            String q2= "update student set gpa= "+ gp+" where sid= "+urRoll;
            st.executeUpdate(q2);
            System.out.println("data of roll "+urRoll+" is updated!");
        }
        
        st.close();
    }
}
