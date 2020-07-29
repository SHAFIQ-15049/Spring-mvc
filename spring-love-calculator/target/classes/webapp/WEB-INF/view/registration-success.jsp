<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Success</title>
</head>
<body>
	<h1 align="center">Love Calculator</h1>
	<hr>
	<h2>Registration completed successfully....</h2>
	<h3>The details entered by you are</h3>
	
	Name : ${userRegistrationInfo.name} <br>
	User Name : ${userRegistrationInfo.userName} <br>
	Password : ${userRegistrationInfo.password} <br>
	Country : ${userRegistrationInfo.countryName} <br>
	Hobbies : 
		<c:forEach var="temp" items="${userRegistrationInfo.hobbies}">
		${temp}
		</c:forEach>

	 <br>
	Gender : ${userRegistrationInfo.gender} <br>
	Age : ${userRegistrationInfo.age} <br>
	Email : ${userRegistrationInfo.communicationDTO.email} <br>
	Phone : ${userRegistrationInfo.communicationDTO.phone} <br>
	
	
	
</body>
</html>