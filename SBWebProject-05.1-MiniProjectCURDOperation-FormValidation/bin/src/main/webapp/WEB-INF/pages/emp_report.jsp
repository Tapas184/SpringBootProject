<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<h1
	style="color: orange; text-align: center; text-decoration: underline;">
	Employee Details</h1>
<f:choose>
	<f:when test="${!empty emplist}">
		<table border="1" align="center" bgcolor="pink">
			<tr bgcolor="yellow">
				<th>EmpNo</th>
				<th>EmpName</th>
				<th>Job</th>
				<th>Salary</th>
				<th>Operation</th>
			</tr>
			<f:forEach var="emp" items="${emplist}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.sal}</td>
					<td>${emp.job}</td>
					<td>&nbsp;<a href="edit?empno=${emp.empno}"><img
							src="logo/edit.png" height="30" width="40"></a>&nbsp;&nbsp; <a
						href="delete?empno=${emp.empno}"
						onclick="return confirm('Do you want to delete thsis id :: ${emp.empno}')"><img
							src="logo/delete.png" height="30" width="40"></a>
					</td>
				</tr>

			</f:forEach>
		</table>
	</f:when>
	<f:otherwise>
		<h2 style="color: red; text-align: center">Record Not Found</h2>
	</f:otherwise>
</f:choose>
<blink>
	<h4 style="color: Green; text-align: center;">${resultMsg}</h4>
</blink>
<br>
<h3 style="text-align: center;">
	<a href="add"><img src="logo/add.png" height="50" width="50"><br>
		Add_Employee</a> <br>
	<br> <a href="./"><img src="logo/Home.png" height="50"
		width="50"><br>Home</a>
</h3>