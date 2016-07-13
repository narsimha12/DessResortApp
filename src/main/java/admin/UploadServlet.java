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

import org.apache.catalina.Session;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;


/**
 * Servlet implementation class regForm
 */

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hi i am uploading");
		String imagepath=null;
		Enumeration e=null;
		MultipartFormDataRequest mfr = null;
		UploadBean upb=null;
		response.setContentType("text/html");
		String fn = null;
		String un = null;
		String pw = null;
	
		String ag = null;
		String gen = null;
		String pn = null;
		String ce = null;
		String loc = null;
		Hashtable fi;
		


		System.out.println("regform called.....");
		try {
			upb=new UploadBean();
			mfr=new MultipartFormDataRequest(request);
			
			loc=mfr.getParameter("city");
			
			//un=generateUserCode();
			un=mfr.getParameter("user_name");
			System.out.println(un);
			fi=mfr.getFiles();
			upb.setFolderstore("C:\\Users\\tcshydisuser\\Desktop\\998102\\DessResort\\WebContent\\uploads");
			upb.store(mfr);
			
			Hashtable ht= mfr.getFiles();
			      e=ht.elements();
			while(e.hasMoreElements())
			{
				UploadFile file= (UploadFile) e.nextElement();
				imagepath=file.getFileName();
				
			} 
//			HttpSession session=request.getSession(true);
		UploadFiles rb=new UploadFiles();
			int st=rb.storeform(un, imagepath,loc);
			if(st>0){
				HttpSession session=request.getSession(true);
				session.setAttribute("status","done");
			response.sendRedirect("Welcome.jsp");
			}

		}
			catch (UploadException e1) {
//			 TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//PrintWriter out=response.getWriter();
		catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


	
	}


	private String generateUserCode() {
		// TODO Auto-generated method stub
        String gcode="";
        String range="0123456789";
        StringBuffer gencode=new StringBuffer();
        for(int i=0;i<3;i++){
                gencode.append(range.charAt((int) (Math.random()*(range.length()))));
        }
        gcode="User"+gencode.toString();
        System.out.println("genecode: "+gcode);
    return gcode;
		
	}
	
}

