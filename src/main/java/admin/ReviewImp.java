package admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.ReviewBean;

public class ReviewImp {
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	String query;
	public ArrayList<ReviewBean> getReview(String city){
		ArrayList<ReviewBean> res = new ArrayList<>();
		con=new Dbconnection().getConnection();
		query="select * from review where city='"+city+"'";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()){
				ReviewBean rb = new ReviewBean();
				rb.setUserid(rs.getString(1));
				rb.setMessage(rs.getString(2));
				rb.setCity(rs.getString(3));
				res.add(rb);
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
		return res;
	}
	public ArrayList<ReviewBean> postReview(ReviewBean rb){
		ArrayList<ReviewBean> res = new ArrayList<>();
		con=new Dbconnection().getConnection();
		query="insert into review values('"+rb.getUserid()+"','"+rb.getMessage()+"','"+rb.getCity()+"')";
		try {
			stmt=con.createStatement();
			int num = stmt.executeUpdate(query);
			stmt.close();
			stmt=con.createStatement();
			if (num>0){
				query = "select * from review where city='"+rb.getCity()+"'";
				rs=stmt.executeQuery(query);
				while(rs.next()){
					ReviewBean rb1 = new ReviewBean();
					rb1.setUserid(rs.getString(1));
					rb1.setMessage(rs.getString(2));
					rb1.setCity(rs.getString(3));
					res.add(rb1);
				}
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
		return res;
	}
}
