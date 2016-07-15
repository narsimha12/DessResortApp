package test;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.Mockito;

import admin.RegistrationServlet;
import admin.LoginServlet;


public class TestRegServlet extends Mockito {


@Test
public void testDoProcess() throws IOException, ServletException
{
HttpServletRequest stubHttpServletRequest = mock(HttpServletRequest.class);
HttpServletResponse stubHttpServletResponse = mock(HttpServletResponse.class);
HttpSession stubHttpSession = mock(HttpSession.class);

when(stubHttpServletRequest.getParameter("name")).thenReturn("TestUser");
when(stubHttpServletRequest.getParameter("gender")).thenReturn("male");
when(stubHttpServletRequest.getParameter("mobile")).thenReturn("9546464646");
when(stubHttpServletRequest.getParameter("location")).thenReturn("hyderabad");
when(stubHttpServletRequest.getAttribute("request")).thenReturn("test");
StringWriter sw = new StringWriter();
PrintWriter pw =new PrintWriter(sw);

when(stubHttpServletResponse.getWriter()).thenReturn(pw);

RegistrationServlet sampleServlet = new RegistrationServlet();
sampleServlet.doPost(stubHttpServletRequest, stubHttpServletResponse);
int result = Integer.parseInt(sw.getBuffer().toString().trim());

//System.out.println(result);
TestCase.assertEquals(result,1);

}
}