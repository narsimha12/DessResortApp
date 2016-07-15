package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String uid,pwd;
		HttpSession session=request.getSession(true);
		RequestDispatcher rd=null;
		uid=request.getParameter("uname");
		pwd=request.getParameter("pwd");
		PrintWriter pw = response.getWriter();
		
		Loginbean lb = new Loginbean();
		String status = lb.checkStatus(uid, pwd);
		
		if(status.equals("notvalid")){
			rd=request.getRequestDispatcher("/Login.jsp?status=Invalid username or password!");
		}
		else{
			if(request.getAttribute("request")==null){
				session.setAttribute("uname",uid);
			}	
		   rd=request.getRequestDispatcher("/Welcome.jsp");
		}
		if(request.getAttribute("request")==null){
			rd.forward(request, response);
		}
		else{
			pw.println(status);
		}
	}

}

