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

import admin.login;
import admin.regForm;


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

StringWriter sw = new StringWriter();
PrintWriter pw =new PrintWriter(sw);

when(stubHttpServletResponse.getWriter()).thenReturn(pw);

regForm sampleServlet = new regForm();
sampleServlet.doPost(stubHttpServletRequest, stubHttpServletResponse);
String result = sw.getBuffer().toString().trim();

System.out.println(result);
TestCase.assertEquals(result,"TestUser");

}
}