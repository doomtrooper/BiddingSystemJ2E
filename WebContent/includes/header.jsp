<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 align="center">
		<strong><u>Welcome to BidWorld</u></strong>
	</h1>
	<c:if test="${not empty loggedInUser }">
		<strong>Hello ${uname } </strong><a href="logout"><button align="left">Logout</button></a>
	</c:if>
	<c:if test="${empty loggedInUser }">
		<form method="post" action="login">
			<table align="right" border="1">
				<tr>
					<td>Username:</td>
					<td><input type="text" placeholder="Enter the User Name"
						required="required" name="username" />
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" placeholder="Password"
						required="required" name="password" />
				</tr>
				<tr>
					<td><input type="submit" value="Login" /></td>
					<td><a href="Register.jsp">SignUp</a></td>
				</tr>
			</table>
			<br />
		</form>
	</c:if>
	<br />

	<hr />