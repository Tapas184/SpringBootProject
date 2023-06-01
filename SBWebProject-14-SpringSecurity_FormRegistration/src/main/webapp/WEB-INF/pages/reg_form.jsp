<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h2 style="color: red; text-align: center;">Customer_Registration
	Form</h2>
<hr>
<frm:form action="reg_cust" method="POST" modelAttribute="cust">
	<table align="center" bgcolor="pink"
		style="border: thin; font-style: italic;">
		<tr bgcolor="yellow">
			<td colspan="2" style="text-align: center;">Registration Form</td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><frm:input path="name" title="Enter Name" /></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><frm:password path="pwd" title="Enter Password" /></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><frm:input path="email" title="Enter mail id" /></td>
		</tr>
		<tr>
			<td>Role:</td>
			<td><frm:checkbox path="roles" value="manager" />Manager <frm:checkbox
					path="roles" value="customer" />Customer</td>
		</tr>
		<tr>
			<td><input type="submit" value="Register"></td>
			<td><input type="reset" value="Cancel"></td>
		</tr>
	</table>
</frm:form>
<h4 style="text-align: center; color: green;">${message}</h4>
<hr>

<h3 style="text-align: center">
	<a href="./home_auth">Home </a>
</h3>