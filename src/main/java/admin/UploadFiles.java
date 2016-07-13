package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.beans.*;
public class UploadFiles {
	
	String fname,pwd,gender,phno,loc;
	Connection con=new Dbconnection().getConnection();
	PreparedStatement stmt=null;
	int status;
	public int storeform(String user, String file ,String loc) throws SQLException {
		// TODO Auto-generated method stub
         stmt=con.prepareStatement("INSERT INTO upload VALUES(?,?,?)"); 
        try {
				stmt.setString(1, user);
				stmt.setString(2, file);
				stmt.setString(3, loc);
		        status=stmt.executeUpdate();
		        
		        if(status>0){
		        	//new SendMailClass().sendmail(ce, msg);
		        	stmt.close();
		        	
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
        	stmt.close();
        	con.close();
        }
        return status;
       }
	}

