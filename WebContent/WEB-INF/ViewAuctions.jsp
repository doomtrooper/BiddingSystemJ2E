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
		All the bids of
		<c:if test="${aucType ==1 }">Immediate</c:if>
		<c:if test="${aucType ==2 }">Regular</c:if>
	</h2>
	<c:if test="${aucMsg ne null }">
		<h3>${aucMsg }</h3>
	</c:if>
	<c:if test="${not empty map }">
		<table align="center" border="1" cellpadding="5px">
			<tr>
				<td align="center">Owner Name</td>
				<td>Company</td>
				<td>Contact No</td>
				<td>Nationality</td>
				<td>Reserver Price</td>
				<td>Item Name</td>
				<td>Description</td>
				<td>Category</td>
				<td>Status</td>
				<td>Bid Now</td>
			</tr>
			<c:forEach items="${map }" var="entry">
				<tr>
					<td>${entry.getValue().getUserName() }</td>
					<td>${entry.getValue().getUserCompany() }</td>
					<td>${entry.getValue().getUserContact() }</td>
					<td>${entry.getValue().getUserNationality() }</td>
					<td>${entry.getKey().getReservePrice() }</td>
					<td>${entry.getKey().getItem().getItemName() }</td>
					<td>${entry.getKey().getItem().getItemDescription() }</td>
					<td>${entry.getKey().getItem().getItemCategory() }</td>
					<td><c:if test="${entry.getKey().getAuctionStatus() == 0 }">Open</c:if>
						<c:if test="${entry.getKey().getAuctionStatus() == 1 }">Closed</c:if></td>
					<td><form action="setbid" method="post">
							<input type="number" min="0" name="bidprice" /> <input
								type="submit" value="Bid" /><input type="hidden" name="aucid"
								value="${entry.getKey().getAucId() }">
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>