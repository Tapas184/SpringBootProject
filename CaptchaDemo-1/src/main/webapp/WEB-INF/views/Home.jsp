<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>   
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn Page</title>
 <script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>
<body>
<f:form action="login" method="POST" modelAttribute="acc">
    
   <table>
     <tr>
        <td>User Name</td>
        <td><f:input path="name"/></td>
      </tr>
      <tr>
        <td>User Name</td>
        <td><f:input path="pass"/></td>
      </tr>
      <tr>
        <td class="g-recaptcha" data-sitekey="6LdjbzsnAAAAAKXdfap7iLwC1L0fR6EgdA1IqXfM"></td>
       </tr>
      <tr>
        <td><input type="submit" value="Login"> </td>
      </tr>
   </table>

</f:form>

<script type="text/javascript">
  var onloadCallback = function() {
    alert("grecaptcha is ready!");
  };
</script>
</body>
</html>