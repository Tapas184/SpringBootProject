+<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2 style="text-align: center; color: Rea; text-decoration: underline;">Employee
	Registration</h2>
<br>
<form:form modelAttribute="emp">
<p style="color: red;text-align: center;">
   <form:errors path="*"/>
</p>
	<table bgcolor="Pink" border="1" align="center">
		<tr bgcolor="Yellow">
			<td colspan="2" align="center">Employee Details</td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><form:input path="ename"/></td>
		</tr>
		<tr>
			<td>Salary :</td>
			<td><form:input path="sal" /></td>
		</tr>
		<tr>
			<td>Job Profile:</td>
			<td><form:input path="job"/></td>
		</tr>
		<tr>
			<td align="center"><button type="submit"
					style="height: 20; width: 60">Submit</button>
			<td align="center"><button type="reset"
					style="height: 20; width: 60">Reset</button>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="report"><img
					src="logo/Home.png" height="30" width="30"></a>
		</tr>
	</table>
</form:form>