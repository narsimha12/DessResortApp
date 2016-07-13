package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.jasper.tagplugins.jstl.core.Out;

import admin.Dbconnection;

public class Complaintformbean
{

	
	Connection con=null;
	int status;
	PreparedStatement pst = null;
	String pending;
	public int storePosts(String uid,String cid, String state, String loc,String str,String phn,String post,String department,String postcomments,String imagepath)
	{
		con=new Dbconnection().getConnection();
		System.out.println("connection"+ con);
	try
	{
	pst=con.prepareStatement("insert into complaints values('"+cid+"','"+state+"','"+loc+"','"+str+"','"+phn+"','2013-02-13','"+post+"','"+department+"','"+postcomments+"','"+imagepath+"','pending')");
	status=pst.executeUpdate();
	pst.close();
	pst=con.prepareStatement("insert into uid_cid values('"+uid+"','"+cid+"')");
	status=pst.executeUpdate();
	}
	catch (SQLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		try {
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return status;
	
}
}
	
