package admin;

import java.sql.*;

public class loginbean {
	
	String uid;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	String query;
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
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return uid;
	}
	/*public String getPhoto(String uid,String pwd){
		con=new Dbconnection().getConnection();
		String photoname = null;
		query="select photo from userreg where uid='"+uid+"' and pwd='"+pwd+"'";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			if(rs.next()){
				photoname=rs.getString(1);
			}
			else{
				photoname="notvalid";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return photoname;
	}*/

}
