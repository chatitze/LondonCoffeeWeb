<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h4>Add coffee shop to databse</h4>
<form:form action="/londoncoffee/venue" commandName="coffeeShop">
<p> Name: <form:input path="name"/> </p>
<p> Rating: <form:input path="rating"/> </p>
<p> WebAddress: <form:input path="webAddress"/> </p>
<%-- <p> Availability: <form:select path="location"> <form:options items="${locations}" itemValue="id" itemLabel="name" /> </form:select> </p> --%>
<input type="submit" value="add it" /> <input type="reset" value="reset" />
</form:form>
</body>
</html>
