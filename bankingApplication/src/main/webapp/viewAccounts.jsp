<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="bankingApplication.Credentials"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="javax.servlet.http.Cookie"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Dashboard:</h1>
	<h4>Welcome!</h4>
	<%
  Credentials cd = new Credentials();
%>


	<% 
String username = request.getParameter("uname");
	%>
<% if(username!=null && username!="")
{
out.print(username);
%>
	<h6>Your account summary below:</h6>
	<pre>
<table>
		<tr>
			<th>Account Number     </th>
			<th>Balance</th>
		</tr>
		</table>
		<% 
	
		ArrayList<String> accNumbers = cd.getBalanceInfo();
		int i=1;
		for(String allAccNums: accNumbers) {
		if(username.equals(cd.getUserName(allAccNums))) {
			out.println();
			out.print(allAccNums+"        ");
			out.println(cd.getBalance(allAccNums));
			
		}}}
		%> 
</pre>

	<form method="get" action="Logout">
		<table>
			<tr>
				<td><input type="submit" value="Logout"></td>
			</tr>
		</table>

	</form>
</body>
</html>