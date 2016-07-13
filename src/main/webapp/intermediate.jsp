<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function call() {
		document.f1.submit();
	}
</script>
</head>
<%
String city=request.getParameter("city");
System.out.println("city in intermediate: "+city);
%>
<body onload="call()">
	<form action="./ViewUpload" name="f1" method="post">
		<input type="hidden" name="city" value="<%=city%>">
	</form>
</body>
</html>