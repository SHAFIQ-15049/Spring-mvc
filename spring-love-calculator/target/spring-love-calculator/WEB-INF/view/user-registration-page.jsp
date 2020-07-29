<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}
</style>

</head>
<body>

	<h1 align="center">Love Calculator</h1>
	<hr>

	<div align="center">

		<form:form action="./register-success" method="get"
			modelAttribute="userRegistratinInfo">
			<p>
				<label for="n">Name : </label>
				<form:input type="text" id="n" path="name" />
			</p>
			<p>
				<label for="un">User Name : </label>
				<form:input type="text" id="un" path="userName" />
			</p>
			<p>
				<label for="pass">Password : </label>
				<form:input type="password" id="pass" path="password" />
			</p>
			<p>
				<label for="ct">Country : </label>
				<form:select id="ct" path="countryName">
					<option value="Aus" label="Australia"></option>
					<option value="Ban" label="Bangladesh"></option>
					<option value="Ind" label="India"></option>
					<option value="Japan" label="Japan"></option>

				</form:select>

			</p>

			<p>
				<label>Hobby : </label>
				<form:checkbox path="hobbies" value="cricket" />
				cricket
				<form:checkbox path="hobbies" value="reading" />
				reading
				<form:checkbox path="hobbies" value="traveling" />
				traveling
				<form:checkbox path="hobbies" value="programming" />
				programming
			</p>

			<p>
				<label>Gender : </label>
				<form:radiobutton path="gender" value="male" />
				Male
				<form:radiobutton path="gender" value="female" />
				Female
			</p>

			<p>
				<label>Age : </label>
				<form:input path="age" />
				<form:errors path="age" cssClass="error" />
			</p>

			<div align="center">
				<h3>Communication</h3>
				<label>Email : </label>
				<form:input path="communicationDTO.email" />

				<label>Phone : </label>
				<form:input path="communicationDTO.phone" />
			</div>
			<p>
				<input type="submit" value="Register" />
			</p>

		</form:form>
	</div>


</body>
</html>