<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html lang="java">
<head>
<meta charset="ISO-8859-1">
<title>Tourist Reg.Form</title>
</head>
<body>
	<h1
		style="text-align: center; color: blue; text-decoration: underline;">Tourist
		Registration Form</h1>
	<br>
	<frm:form modelAttribute="tst">
		<table
			style="margin-left: auto; margin-right: auto; background-color: pink"
			border="1">
			<caption>Tourist EditForm</caption>
			<tr>
				<th colspan="2"
					style="background-color: yellow; text-align: center;">Edit
					Form</th>
			</tr>
			<tr>
				<td>Tourist Id :</td>
				<td><frm:input path="tid" readonly="true" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><frm:input path="name" title="Enter Tourist Name" /></td>
			</tr>
			<tr>
				<td>City :</td>
				<td><frm:input path="city" title="Enter Tourist City Name" /></td>
			</tr>
			<tr>
				<td>Package :</td>
				<td><frm:input path="pakage" title="Enter Pakage" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><frm:input path="price" title="Enter Pakage" /></td>
			</tr>
			<tr>
				<td style="text-align: center;"><input type="submit" value="Update"></td>
				<td style="text-align: center;"><input type="reset"></td>
			</tr>
		</table>
	</frm:form>
	<hr>
	<h1 style="text-align: center;">
		<a href="alltouristlist"><button>All Tourist List</button></a>
	</h1>
</body>
</html>