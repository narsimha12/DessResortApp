package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mockito;

import admin.Review;

public class TestPostReview extends Mockito{
	@Test
	public void testDoProcess() throws IOException, ServletException
	{
	HttpServletRequest stubHttpServletRequest = mock(HttpServletRequest.class);
	HttpServletResponse stubHttpServletResponse = mock(HttpServletResponse.class);
	

	when(stubHttpServletRequest.getParameter("request")).thenReturn("postReview");
	when(stubHttpServletRequest.getParameter("city")).thenReturn("Hyderabad");
	when(stubHttpServletRequest.getParameter("msg")).thenReturn("Hello");
	when(stubHttpServletRequest.getParameter("uname")).thenReturn("narsimha");
	when(stubHttpServletRequest.getAttribute("request")).thenReturn("test");
	StringWriter sw = new StringWriter();
	PrintWriter pw =new PrintWriter(sw);

	when(stubHttpServletResponse.getWriter()).thenReturn(pw);

	Review sampleServlet = new Review();
	sampleServlet.doPost(stubHttpServletRequest, stubHttpServletResponse);
	int result = Integer.parseInt(sw.getBuffer().toString().trim());

	//System.out.println("result: "+result);
	TestCase.assertNotSame(result,0);

	}
}

