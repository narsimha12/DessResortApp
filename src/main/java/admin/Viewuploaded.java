package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.beans.*;
public class Viewuploaded {
	
	
	Connection con=new Dbconnection().getConnection();
	PreparedStatement stmt=null;
	int status;
	ArrayList<String> arr=new ArrayList<>();
	public ArrayList getuploadedfiles(String city) throws SQLException {
		// TODO Auto-generated method stub
		 ResultSet rr=null;
		 
         stmt=con.prepareStatement("select image from upload where location = ?"); 
        try {
				stmt.setString(1, city);
		       rr= stmt.executeQuery();
		       while(rr.next())
		       {
		    	   arr.add(rr.getString(1));
		       }
		        
		        	stmt.close();
		        	
		        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
        	stmt.close();
        	con.close();
        }
        return arr;
       }
	}

