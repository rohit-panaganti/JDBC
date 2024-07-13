package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_DAO {
	public static void main(String args[]) throws Exception {
		studentDAO sdao = new studentDAO();
		Student s1=sdao.getStudent(1);
		Student s2=new Student();
		s2.name="Ravi";
		s2.roll_num=4;
		
		sdao.addStudent(s2);
		

		
		System.out.println(s1.name);
}
}

class studentDAO {
	public Student getStudent(int roll_num) throws Exception {
		Student s = new Student();
		String query="select Name from rohit.student where id="+ roll_num ;
		s.roll_num=roll_num;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rohit","root","Kala123@rohitpriyank");
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(query);
		rs.next();
		
		s.name = rs.getString(1);
		
		return s;
		
		
	}
	
	public void addStudent(Student s) throws Exception {
		String query = "insert into Student values (?,?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rohit","root","Kala123@rohitpriyank");
		PreparedStatement pst= con.prepareStatement(query);
		pst.setInt(1, 4);
		pst.setString(2, "Mahabharath");
		
		pst.executeUpdate();
		
		
	}
}