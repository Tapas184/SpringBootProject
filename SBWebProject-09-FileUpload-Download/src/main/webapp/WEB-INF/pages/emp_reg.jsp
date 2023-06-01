<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ page isELIgnored="false"%>
<frm:form action="reg" method="POST" modelAttribute="emp"
	enctype="multipart/form-data">
	<table bgcolor="pink" border="1" align="center">
		<tr bgcolor="yellow">
			<td colspan="2" align="center">Employee Registration Form</td>
		</tr>
		<tr>
			<td>Employee name ::</td>
			<td><frm:input title="Enter Name" path="name" /></td>
		</tr>
		<tr>
			<td>Employee Gender ::</td>
			<td><frm:radiobutton path="gender" value="Male" />Male <frm:radiobutton
					path="gender" value="Female" />Female</td>
		</tr>
		<tr>
			<td>Upload your resume::</td>
			<td><frm:input type="file" path="resume" /></td>
		</tr>
		<tr>
			<td>Upload your Photo::</td>
			<td><frm:input type="file" path="photo" /></td>
		</tr>
		<tr>
			<td align="center"><button type="submit">Submit</button></td>
			<td align="center"><button type="Reset">Reset</button></td>
		</tr>
	</table>
</frm:form>
<hr>
<h2 style="text-align: center">
	<a href="./"><img src="logo/Home.png" height="40" width="40"><br>
		Home</a>
</h2>
