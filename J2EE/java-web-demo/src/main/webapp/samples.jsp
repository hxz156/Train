<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Samples</title>
</head>
<body>

<!--jsp directive: extract samples data from request  -->
<jsp:useBean id="samples" scope="request" class="java.util.ArrayList"></jsp:useBean>
<%@page import="com.mercury.java_web_demo.bean.Sample" %>

<h1>All samples from samples.jsp</h1>
<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Age</th>
		</tr>
	</thead>
	<tbody>
		<%
			for(Object o : samples) {
				Sample sample = (Sample)o;
				// implicit object: out (不需要创建对象，可以直接访问)
				out.print("<tr>");
				out.print("<td>" + sample.getName() + "</td>");
				out.print("<td>" + sample.getAge() + "</td>");
				out.print("</tr>");
			}
		%>
	</tbody>

</table>
</body>
</html>













