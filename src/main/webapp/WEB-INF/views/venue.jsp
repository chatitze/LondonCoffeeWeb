<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Venue</title>
</head>
<body>
<h1>
	Venue
</h1>

<P>  Current venue is:
     Name: ${COFFEESHOP.name}
     Rating:  ${COFFEESHOP.rating}
     Web:  ${COFFEESHOP.webAddress}</P>
</body>
</html>