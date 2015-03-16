<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Auctions</title>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>

	<h2 align="center">All your bids Mr. ${uname}.Now Contemplate!!!</h2>
	<c:if test="${myAucMsg ne null }">
		<h3>${myAucMsg }</h3>
	</c:if>
	<c:if test="${not empty myAucLst }">
		<table align="center" border="1" cellpadding="5px">
			<tr>
				<td>Item Name</td>
				<td>Reserver Price</td>
				<td>Description</td>
				<td>Category</td>
				<td>Status</td>
			</tr>
			<c:forEach items="${myAucLst }" var="entry">
				<tr>

					<td>${entry.getItem().getItemName() }</td>
					<td>${entry.getReservePrice() }</td>
					<td>${entry.getItem().getItemDescription() }</td>
					<td>${entry.getItem().getItemCategory() }</td>
					<td><c:if test="${entry.getAuctionStatus() == 0 }">Open</c:if>
						<c:if test="${entry.getAuctionStatus() == 1 }">Closed</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>