<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BidWorld!!!</title>
</head>
<body>
	<jsp:include page="includes/header.jsp"></jsp:include>
	<div>
		<c:if test="${errmsg ne null}">
			<h3>${errmsg }</h3>
		</c:if>
		<c:if test="${welcomemsg ne null}">
			<h3>Hello ${uname }. ${welcomemsg }</h3>
		</c:if>
		<c:if test="${registermsg ne null }">
			<h3>${registermsg }</h3>
		</c:if>
		<c:if test="${logoutmsg ne null }">
			<h3>${logoutmsg }</h3>
		</c:if>
		<c:if test="${addAucMsg ne null }">
			<h3>${addAucMsg }</h3>
		</c:if>
		<c:if test="${bidMsg ne null }">
			<h3>${bidMsg }</h3>
		</c:if>
		<p>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry. Lorem Ipsum has been the industry's standard
			dummy text ever since the 1500s, when an unknown printer took a
			galley of type and scrambled it to make a type specimen book. It has
			survived not only five centuries, but also the leap into electronic
			typesetting, remaining essentially unchanged. It was popularised in
			the 1960s with the release of Letraset sheets containing Lorem Ipsum
			passages, and more recently with desktop publishing software like
			Aldus PageMaker including versions of Lorem Ipsum.</p>
		<c:if test="${not empty loggedInUser }">
			<table>
				<tr>
					<td><a href="AddAuction.jsp">Create Auction</a></td>
				</tr>
				<tr>
					<td><a href="viewauction?type=2">View Auctions(Regular)</a></td>
				</tr>
				<tr>
					<td><a href="viewauction?type=1">View Auctions(Immediate)</a></td>
				</tr>
				<tr>
					<td><a href="viewmyauction">View My Auctions</a></td>
				</tr>
				<tr>
				<td><a href="viewstatus">View Bid Status</a>
				</tr>
			</table>
		</c:if>
	</div>
	<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>




