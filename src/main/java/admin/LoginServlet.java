package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session=request.getSession(true);
		RequestDispatcher rd=null;
		String uid=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		
		Loginbean lb=new Loginbean();
		String status = lb.checkStatus(uid, pwd);
		if(status.equals("notvalid")){
			rd=request.getRequestDispatcher("/Login.jsp?status=Invalid username or password!");
		}
		else{
			session.setAttribute("uname",uid);
			rd=request.getRequestDispatcher("/Welcome.jsp");
		}
		rd.forward(request, response);
	}

}
