<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auctions</title>
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<h2 align="center">
		<u>All the bids!!! Enjoy :D</u> 
	</h2>
	<c:if test="${myBidMsg ne null }">
		<h3>${myBidMsg }</h3>
	</c:if>
	<c:if test="${not empty myBidLst }">
		<table align="center" border="1" cellpadding="5px">
			<tr>
				<td>Item Name</td>
				<td>Description</td>
				<td>Category</td>
				<td>Max Bidder</td>
				<td>Owner</td>
				<td>OwnerContact</td>
				<td>OwnerCompany</td>
				<td>Status</td>
				<td>Max Bid</td>
			</tr>
			<c:forEach items="${myBidLst }" var="entry">
				<tr>
					<td>${entry.getItemDetails().getItemName() }</td>
					<td>${entry.getItemDetails().getItemDescription() }</td>
					<td>${entry.getItemDetails().getItemCategory() }</td>
					<td>${entry.getMaxBidder() }</td>
					<td>${entry.getItemOwner().getUserName() }</td>
					<td>${entry.getItemOwner().getUserContact() }</td>
					<td>${entry.getItemOwner().getUserCompany() }</td>
					<td><c:if test="${entry.getBidStatus() == 0 }">Open</c:if>
						<c:if test="${entry.getBidStatus() == 1 }">Closed</c:if></td>
					<td>${entry.getBidDetails().getBidPrice() }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>