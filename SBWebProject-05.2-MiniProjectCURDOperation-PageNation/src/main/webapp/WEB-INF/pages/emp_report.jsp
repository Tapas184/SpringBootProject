
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="f" %>
<h1
	style="color: orange; text-align: center; text-decoration: underline;">
	Employee Details</h1>
<f:choose>
	<f:when test="${!empty pagedata}">
		<table border="1" style="background-color: pink; margin: auto;">
		  <caption>Employee Report</caption>
			<tr style="background-color: yellow;">
				<th>EmpNo</th>
				<th>EmpName</th>
				<th>Salary</th>
				<th>Job</th>
				<th>Operation</th>
			</tr>
			<f:forEach var="emp" items="${pagedata.getContent()}">
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
<div style="text-align: center;">
	${resultMsg}
</div>
<hr>
<p style="text-align: center;">
	<f:if test="${!pagedata.isFirst()}">
		<a href="report?page=page-1"><b>[Previous]</b></a>
	</f:if>

	<f:forEach var="i" begin="1" end="${pagedata.getTotalPages()}" step="1">
          [<a href="report?page=${i-1}">${i}</a>]&nbsp;&nbsp;
    </f:forEach>
	<f:choose>
		<f:when test="${!pagedata.isLast()}">
			<a href="report?page=${pagedata.getTotalPages()}"><b>[Last]</b></a>
		</f:when>
		<f:otherwise>
			<a href="report?page=0"><b>[First]</b></a>
		</f:otherwise>
	</f:choose>
</p>
<br>
<h3 style="text-align: center;">
	<a href="add"><img src="logo/add.png" height="50" width="50"><br>
		Add_Employee</a> <br> <br> <a href="./"><img
		src="logo/Home.png" height="50" width="50"><br>Home</a>
</h3>