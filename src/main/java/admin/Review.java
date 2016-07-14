package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.ReviewBean;
public class Review extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reqval = request.getParameter("request");
		RequestDispatcher rd = null;
		if(reqval.equalsIgnoreCase("viewReview")){
			String city = request.getParameter("city");
			
			ArrayList<ReviewBean> result = new ReviewImp().getReview(city);
			request.setAttribute("review", result);
			rd = request.getRequestDispatcher("Review.jsp?city="+city);
			rd.forward(request, response);
		}
		else if(reqval.equalsIgnoreCase("postReview")){
			String city = request.getParameter("city");
			String msg = request.getParameter("msg");
			String uname = request.getParameter("uname");
			ReviewBean rb = new ReviewBean();
			rb.setUserid(uname);
			rb.setCity(city);
			rb.setMessage(msg);
			ArrayList<ReviewBean> result = new ReviewImp().postReview(rb);
			request.setAttribute("review", result);
			rd = request.getRequestDispatcher("Review.jsp?city="+city);
			rd.forward(request, response);
		}
	}

}
