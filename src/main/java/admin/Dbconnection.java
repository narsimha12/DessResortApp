package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconnection {
	Connection con=null;
	Statement stmt=null;
	Logger logger = Logger.getLogger(Dbconnection.class.getName());
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aws","root","root");
			stmt=con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.info(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info(e);
		}
		return con;
	}
}
