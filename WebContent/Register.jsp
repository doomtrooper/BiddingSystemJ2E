<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<c:if test="${not empty loggedInUser }">
	<c:redirect url="/index.jsp" />
</c:if>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<jsp:include page="includes/header.jsp"></jsp:include>
	<form action="signup" method="post">
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="username" />
			</tr>
			<tr>
				<td>Company:</td>
				<td><input type="text" name="usercompany" />
			</tr>
			<tr>
				<td>Contact:</td>
				<td><input type="text" name="usercontact" />
			</tr>
			<tr>
				<td>Nationality:</td>
				<td><input type="text" name="usernationality" />
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="userpassword" />
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Register Me" />
			</tr>
		</table>
	</form>
	<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>