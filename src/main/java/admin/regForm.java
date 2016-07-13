package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.beans.*;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;

import com.oreilly.servlet.MultipartFilter;

/**
 * Servlet implementation class regForm
 */

public class regForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		String uname = null;
		String password = null;
		String gender = null;
		String mobileno = null;
		String location = null;
		
		
		uname=request.getParameter("name");
		
		password=generatePWDcode();		
		gender=request.getParameter("gender");
		mobileno=request.getParameter("mobile");
		
		location=request.getParameter("location");
		
		//PrintWriter pw = response.getWriter();
		//pw.println(uname);
		
		HttpSession session=request.getSession(true);
		regFormbean rb=new regFormbean();
		int st;
		try {
			st = rb.storeform(uname, password, gender, mobileno, location);
		
			if(st>0){
				session.setAttribute("uname",uname);
				session.setAttribute("password",password);
				response.sendRedirect("Welcome.jsp");
			}
			else{
				System.out.println("Registration fail...");
				response.sendRedirect("RegForm.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

	private String generatePWDcode() {
		// TODO Auto-generated method stub
        String gcode="";
        String range="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer gencode=new StringBuffer();
        for(int i=0;i<5;i++){
                gencode.append(range.charAt((int) (Math.random()*(range.length()))));
        }
        gcode=gencode.toString();
        System.out.println("genecode: "+gcode);
    return gcode;
		
	}
	
}

