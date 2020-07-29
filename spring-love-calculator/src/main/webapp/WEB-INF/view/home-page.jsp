<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

.error{
	color:red;
	position:fixed;
	text-align: left;
	margin-left: 30px;

}


</style>



<script type="text/javascript">
function validateUserName(){
	var userName = document.getElementById('yn').value;

	if (userName.length < 1) {
		alert("Your name should have atleast one character...")
		return false;
		
	}
	else{
		return true;
	}
	
}
</script>

<!-- onsubmit="return validateUserName()" -->

</head>
<body>

	<h1 align="center">Love Calculator</h1>
	<hr>
	<!-- onsubmit="return validateUserName()" -->
	<div align="center">
		<form:form action="./process-homepage" method="get"
			modelAttribute="userInfo" >

			<p>
				<label for="yn">Your Name :</label>
				<form:input id="yn" path="userName" />
				<form:errors path="userName" cssClass="error"/>
			</p>

			<p>
				<label for="cn">Crush Name :</label>
				<form:input id="cn" path="crushName" />
				<form:errors path="crushName" cssClass="error"/>
			</p>
			
			<p> <form:checkbox path="termsAndConditions" id="check"/>
				<label>I am agreeing that this is for fun.</label>
				<form:errors path="termsAndConditions" cssClass="error"/>
			 </p>

			<input type="submit" value="Calculate">

		</form:form>

	</div>

</body>
</html>