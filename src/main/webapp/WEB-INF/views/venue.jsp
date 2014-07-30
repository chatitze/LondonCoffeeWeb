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
	<br/>
     Name: ${COFFEESHOP.name}
     <br/>
     Rating:  ${COFFEESHOP.rating}
     <br/>
     Web:  ${COFFEESHOP.webAddress}
     <br/>
     Location:  ${COFFEESHOP.location}
     <br/>
     City:  ${COFFEESHOP.location.city}</P>
</body>
</html>