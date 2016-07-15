package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		String fn = null;
		String pwd = null;
		String gen = null;
		String pn = null;
		String loc = null;
		PrintWriter pw = response.getWriter();
		fn=request.getParameter("name");
		pwd=generatePWDcode();	
		gen=request.getParameter("gender");
		pn=request.getParameter("mobile");
		loc=request.getParameter("location");
		
		HttpSession session=request.getSession(true);
		RegFormbean rb=new RegFormbean();
		int status=rb.storeform(fn, pwd, gen, pn, loc);
		System.out.println("status:"+status);
		if(status>0){
			if(request.getAttribute("request")==null){
				session.setAttribute("uname",fn);
				session.setAttribute("password",pwd);
				response.sendRedirect("Welcome.jsp");
			}
		}
		else{
			if(request.getAttribute("request")==null){
				response.sendRedirect("RegForm.html");
			}
		}
		if(request.getAttribute("request")!=null){
			pw.println(status);
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

