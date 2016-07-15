package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class RegFormbean {
	
	String fname,pwd,gender,phno,loc;
	Connection con=new Dbconnection().getConnection();
	PreparedStatement stmt=null;
	int status;
	private static final Logger logger = Logger.getLogger(RegFormbean.class.getName());
	public int storeform(String fn, String pw, String gen, String pn, String loc2) {
		// TODO Auto-generated method stub
         
        try {
        	stmt=con.prepareStatement("INSERT INTO userreg VALUES(?,?,?,?,?,?,?,?,?)"); 
				stmt.setString(1, fn);
				stmt.setString(2, "null");
				stmt.setString(3, pw);
		        
		        stmt.setString(4, "null");
		        stmt.setString(5, gen);
		        stmt.setString(6, pn);
		        stmt.setString(7, "null");
		        stmt.setString(8, loc2);
		        stmt.setString(9, "null");
		        status=stmt.executeUpdate();
		        if(status>0){
		        	//new SendMailClass().sendmail(ce, msg);
		        	stmt.close();
		        	stmt=con.prepareStatement("insert into login values('"+fn+"','"+pw+"','user')");
		        	status=stmt.executeUpdate();
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
				logger.info(e);
			}
        	
        }
        return status;
       }
	}

