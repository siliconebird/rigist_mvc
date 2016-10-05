<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to my page!</h1>
	<hr>
	<c:if test="${sessionScope.user==null}">
		<a href="${pageContext.request.contextPath }/regist.jsp">regist</a>
		<a href="${pageContext.request.contextPath }/login.jsp">login</a>
	</c:if>
	<c:if test="${sessionScope.user!=null }">
		欢迎回来 ${sessionScope.user.username}<a href="${pageContext.request.contextPath }/servlet/logoutServlet">logout</a>
	</c:if>
</body>
</html>