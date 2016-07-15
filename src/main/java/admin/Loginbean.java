package admin;

import java.sql.*;

import org.apache.log4j.Logger;

public class Loginbean {
	
	String uid;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	String query;
	private static final  Logger logger = Logger.getLogger(Loginbean.class.getName());
	public String checkStatus(String uid,String pwd){
		con=new Dbconnection().getConnection();
		query="select uid from login where uid='"+uid+"' and pwd='"+pwd+"'";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			if(rs.next()){
				uid=rs.getString(1);
			}
			else{
				uid="notvalid";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info(e);
		}
		finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.info(e);
			}
		}
		return uid;
	}

}

