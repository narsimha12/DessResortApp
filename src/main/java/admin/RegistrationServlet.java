package admin;

import java.io.IOException;

import java.sql.SQLException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		String fn = null;
		String pw = null;
		String gen = null;
		String pn = null;
		String loc = null;
		
		try {
			fn=request.getParameter("name");
			pw=generatePWDcode();	
			gen=request.getParameter("gender");
			pn=request.getParameter("mobile");
			loc=request.getParameter("location");
			
			HttpSession session=request.getSession(true);
			regFormbean rb=new regFormbean();
			int st=rb.storeform(fn, pw, gen, pn, loc);
			if(st>0){
				session.setAttribute("uname",fn);
				session.setAttribute("password",pw);
				response.sendRedirect("Welcome.jsp");
			}
			else{
				System.out.println("Registration fail...");
				response.sendRedirect("RegForm.html");
			}
		}
		catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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

