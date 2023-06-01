<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color: blue; text-align: center">Login Page</h1>
<hr>
<frm:form action="login" method="POST">

	<table border="1" bgcolor="blue" align="center">
		<tr style="color: pink">
			<td>UserName ::</td>
			<td><input type="text" name="username" title="Enter Name" /></td>
		</tr>
		<tr style="color: pink">
			<td>Password ::</td>
			<td><input type="password" name="password"
				title="Enter Password" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"></td>
			<td><input type="reset" value="Cancel"></td>
		</tr>
	</table>
</frm:form>
<hr>
<h2 style="text-align: center">
	<a href="./">Home</a>
</h2>