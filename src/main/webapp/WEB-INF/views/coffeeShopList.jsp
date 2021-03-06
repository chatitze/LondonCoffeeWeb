<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>London Coffee Shop List</title>
</head>
<body>
<table>
	<c:forEach var="coffeeShops" items="${COFFEESHOP_LIST}" >
		<tr>
			<td> ${coffeeShops.name} </td>
			<td> ${coffeeShops.rating} </td>
			<td> ${coffeeShops.webAddress} </td>
			<td> ${coffeeShops.location} </td>
			<td> ${coffeeShops.location.city} </td>
			<td> ${coffeeShops.socialMedia.facebook} </td>
		</tr>
	</c:forEach>
</table>

</body>
</html>