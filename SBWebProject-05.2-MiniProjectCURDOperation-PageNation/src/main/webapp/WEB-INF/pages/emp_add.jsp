<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2 style="text-align: center; color: Rea; text-decoration: underline;">Employee
	Registration</h2>
<br>
<script type="text/javascript" src="js/validation.js">
</script>
<form:form modelAttribute="emp" onsubmit="return validate(this)">
<%-- <p style="color: red;text-align: center;">
   <form:errors path="*"/>
</p>
 --%>	<table bgcolor="Pink" border="1" align="center">
		<tr bgcolor="Yellow">
			<td colspan="2" align="center">Employee Details</td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><form:input path="ename" onclick="Enter your name"/><form:errors cssStyle="color:red" path="ename"/><span id="enameError" style="color: red"></span></td>
		</tr>
		<tr>
			<td>Salary :</td>
			<td><form:input path="sal" onfocus="Enter Employee Salary"/><form:errors cssStyle="color:red" path="sal"/><span id="salError" style="color: red"></span></td>
		</tr>
		<tr>
			<td>Job Profile:</td>
			<td><form:input path="job" onfocus="Enter Employee JobProfile"/><form:errors cssStyle="color:red" path="job"/><span id="jobError" style="color: red"></span></td>
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
		<tr>
		  <td><form:hidden path="hflag"/> </td>
		</tr>
	</table>
</form:form>