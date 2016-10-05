<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>regist page</h1>
<hr>
<div>
			用户名：3~8个字母组成，不能为空<br/>
	  		密码：3~8位数字组成，不能为空<br/>
	  		重复密码：必须和密码一致<br/>
	  		邮箱：不能为空，且要符合邮箱的格式<br/>
	  		生日：不能为空，且要符合yyyy-MM-dd的格式<br/>
</div>
<hr>
<form action="${pageContext.request.contextPath}/servlet/registServlet" method="post">
	
	<table border="1" width="438">
		<tr>
			<td>account</td>
			<td>
				<input type="text" name="username" value="${formatbean.username }">${formatbean.errors.username }
			</td>
		</tr>
		
		<tr>
			<td>password</td>
			<td>
				<input type="text" name="password" value="${formatbean.password }">${formatbean.errors.password }
			</td>
		</tr>
		
			<tr>
			<td>repassword</td>
			<td>
				<input type="text" name="repassword" value="${formatbean.repassword }">${formatbean.errors.repassword }
			</td>
		</tr>
		
			<tr>
			<td>email</td>
			<td>
				<input type="text" name="email" value="${formatbean.email }">${formatbean.errors.email }
			</td>
		</tr>
		
			<tr>
			<td>birthday</td>
			<td>
				<input type="text" name="birthday" value="${formatbean.birthday }">${formatbean.errors.birthday }
			</td>
		</tr>
		
		<tr>
			<td >
				<input type="submit" value="submit!">
			</td>
			<td>
				<a href="${pageContext.request.contextPath }">BACK</a>
			</td>
		
		</tr>
	</table>
</form>
</body>
</html>