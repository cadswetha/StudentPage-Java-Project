package JDBCcon;
import java.sql.*;
import java.util.*;
public class Connect {
	public Statement stm;
	public Connect(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sastra123");
			stm = con.createStatement();
			//ResultSet rs = stm.executeQuery("select * from employees");
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
	public void CreateTable(){
		Connection con =null;
		Statement stmt =null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sastra123");
			stmt = con.createStatement();
			stmt.executeQuery("create table studentdetails(regno varchar(10),name varchar(30),dob date,gender varchar(5),mail varchar(30),contact varchar(10),degree varchar(8),cgpa varchar(10))");
		}catch(Exception e) {
			System.out.print(e);
		}finally{
			try { stmt.close(); } catch (Exception e) { /* Ignored */ }
			try { con.close(); } catch (Exception e) { /* Ignored */ }
		}
	}
}
