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


public class TestLoginServelt extends Mockito {


@Test
public void testDoProcess() throws IOException, ServletException
{
HttpServletRequest stubHttpServletRequest = mock(HttpServletRequest.class);
HttpServletResponse stubHttpServletResponse = mock(HttpServletResponse.class);
HttpSession stubHttpSession = mock(HttpSession.class);

when(stubHttpServletRequest.getParameter("uname")).thenReturn("Narsimha");
when(stubHttpServletRequest.getParameter("pwd")).thenReturn("TTD");

when(stubHttpServletRequest.getSession()).thenReturn(stubHttpSession);
when(stubHttpSession.getAttribute("uname")).thenReturn("Narsimha");

StringWriter sw = new StringWriter();
PrintWriter pw =new PrintWriter(sw);

when(stubHttpServletResponse.getWriter()).thenReturn(pw);

login sampleServlet = new login();
sampleServlet.doPost(stubHttpServletRequest, stubHttpServletResponse);
String result = sw.getBuffer().toString().trim();
System.out.println(stubHttpSession.getAttribute("uname"));

System.out.println(result);
TestCase.assertEquals(result,"Narsimha");

}
}