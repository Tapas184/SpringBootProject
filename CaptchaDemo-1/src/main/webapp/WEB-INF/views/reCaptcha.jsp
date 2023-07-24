<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Captcha</title>
</head>
<body>
	<form action="login" method="post">
		<div class="g-recaptcha" data-sitekey="6Lc44jYnAAAAADqPnniQa6Sr3dM3i32opIi-qrGD"></div>
		<button type="submit">Submit</button>
	</form>
</body>
</html>