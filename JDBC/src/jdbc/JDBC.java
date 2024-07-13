package jdbc;
import java.sql.*;

public class JDBC {

	public static void main(String[] args) throws Exception {
		String url= "jdbc:mysql://localhost:3306/rohit"; //msql like a lan
		String uName="root";
		String Password ="Kala123@rohitpriyank";
		String query = "insert into rohit.employee values (?,?,?,?);";
		
		int Uid=5;
		String Name = "Hanuman";
		int age=100;
		int dep = 10000;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uName,Password);
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1,Uid);
		st.setString(2,Name);
		st.setInt(3,age);
		st.setInt(4,dep);
		
		//executeQuery : for DQL 
		//DML : change the values
		// DDL  : for inserting some values
		
		
		int count =st.executeUpdate();
		System.out.print(count );
		
		
		st.close();
		con.close();
		
		
		
		
	}

}
