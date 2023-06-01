<%@ page language="java" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="titles"%>

<header>
	<title><titles:insertAttribute name="title" ignore="true" /></title>
</header>
<table border="0" height="100%" width="100%" rows="3" cols="3">
	<tr height="20%">
		<td colspan="3"><titles:insertAttribute name="header" /></td>
	</tr>
	<tr height="70%">
		<td width="20%"><titles:insertAttribute name="menu" /></td>
		<td width="60%"><titles:insertAttribute name="body" /></td>
		<td width="20%"><titles:insertAttribute name="add" /></td>
	</tr>
	<tr height="10%">
		<td colspan="3"><titles:insertAttribute name="footer" /></td>
	</tr>
</table>