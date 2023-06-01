<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<h4 style="color: blue;text-align: center">Welcome to Employee Registration form</h4>
<f:form action="register" method="POST" modelAttribute="emp">
  <table border="1" bgcolor="pink" align="center">
     <tr><td>Employee Number ::</td><td><f:input path="eid"/></td></tr>
     <tr><td>Employee Name ::</td><td><f:input path="name"/></td></tr>
     <tr><td>Employee Salary ::</td><td><f:input path="salary"/></td></tr>
     <tr><td colspan="2" align="center"><input type="submit" value="Register"/></td></tr>
  </table>
</f:form>