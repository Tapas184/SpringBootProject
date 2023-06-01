<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<h3 style="color: blue; text-align: center; text-decoration: underline;">Employee
	Modification</h3>
<f:form modelAttribute="emp">
	<table style="background-color: pink" align="center">
		<tr bordercolor="red" border="1">
			<td colspan="2" bgcolor="Yellow" align="center">Employee Details</td>
		</tr>
		<tr>
			<td>Employee Id ::</td>
			<td><f:input path="empno" readonly="true" /></td>
		</tr>
		<tr>
			<td>Employee Name ::</td>
			<td><f:input path="ename" /></td>
		</tr>
		<tr>
			<td>Employee Salary ::</td>
			<td><f:input path="sal" /></td>
		</tr>
		<tr>
			<td>Employee Position ::</td>
			<td><f:input path="job" /></td>
		</tr>
		<tr>
			<td align="center"><button type="submit" onclick="return confirm('Are you sure for update for id : ${emp.empno}')">Update</button></td>
			<td align="center"><button type="reset">Reset</button></td>
		</tr>
	</table>
</f:form>
<h4 style="text-align: center;">
	<a href="report"><img src="logo/Home.png" height="40" width="40"><br>Home</a>
</h4>