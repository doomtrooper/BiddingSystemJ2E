<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty loggedInUser }">
	<c:redirect url="/index.jsp" />
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Auction</title>
</head>
<body>
	<jsp:include page="includes/header.jsp"></jsp:include>
	<form action="addauction" method="post">
		<table align="center">
			<tr>
				<td>Item Name:</td>
				<td><input type="text" name="iname"
					placeholder="Enter item name" /></td>
			</tr>
			<tr>
				<td>Item Description:</td>
				<td><input type="text" name="idesc"
					placeholder="Enter item description" /></td>
			</tr>
			<tr>
				<td>Item Category:</td>
				<td><input type="text" name="icat"
					placeholder="Enter item category" /></td>
			</tr>
			<tr>
				<td>Item Reserve Price:</td>
				<td><input type="text" name="ares"
					placeholder="Enter item name" /></td>
			</tr>
			<tr>
				<td>Auction length:</td>
				<td><input type="number" max="10" min="0" name="alen"
					placeholder="(in days)" /></td>
			</tr>
			<tr>
				<td>Auction type:</td>
				<td><input type="radio" name="atype" value="1" />Immediate <input
					type="radio" name="atype" value="2" />Regular</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Create Auction" /></td>
			</tr>
		</table>
	</form>
	<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>