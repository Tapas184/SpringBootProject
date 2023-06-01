
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h2 style="color: Blue; text-align: center; text-decoration: underline;">Employee
	Details FillUp Form</h2>
<hr>
<frm:form modelAttribute="cust">
	<table align="center" bgcolor="Pink">
		<tr style="color: yellow">
			<td colspan="1" align="center">Form</td>
		</tr>
		<tr>
			<td>Person Name ::</td>
			<td><frm:input path="name" /></td>
		</tr>
		<tr>
			<td>Country ::</td>
			<td><frm:select path="country">
					<frm:options items="${countriesInfo}" />
				</frm:select></td>
		</tr>
		<tr>
			<td>Languages :</td>
			<td><frm:select path="language" multiple="multiple">
					<frm:options items="${languageInfo}" />
				</frm:select></td>
		</tr>
		<tr>
			<td>Languages :</td>
			<td><frm:checkboxes items="${hubbiesInfo}" path="hobbies" /></td>
		</tr>
		<tr>
			<td style="text-align: center;"><input type="submit"
				value="Register" /></td>
			<td style="text-align: center;"><input type="reset"
				value="Cancel" /></td>
		</tr>

	</table>

</frm:form>
<hr>
<h4 style="text-align: center;">
	<a href="./"><img src="logo/Home.png" height="40" width="40"><br>Home</a>
</h4>