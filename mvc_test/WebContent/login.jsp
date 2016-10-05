<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login page</title>
</head>
<body>
	<h1>login page</h1>
	<hr>
	<form action="${pageContext.request.contextPath }/servlet/loginServlet" method="post">
	<table border="1" width="438">
		<tr>
			<td>account</td>
			<td>
				<input type="text" name="username" value="">
			</td>
		</tr>
		
		<tr>
			<td>password</td>
			<td>
				<input type="password" name="password" value="">
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="submit" value="SUBMIT">
			</td>
			<td>
				<a href="${pageContext.request.contextPath }">BACK</a>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>