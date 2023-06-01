<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="f" %>
<!DOCTYPE html>
<html lang="java">
<head>
<meta charset="ISO-8859-1">
<title>Tourist List</title>
</head>
<body>
<h1 style="text-align: center;color:blue;">All Tourist List</h1>
<f:choose>
   <f:when test="${!empty touristList}">
         <table style="background-color:pink;margin-left: auto;margin-right: auto;" border="1">
         <caption style="text-align: left;color: green; text-decoration: blink;">Tourist List</caption>
         <tr>
         <th>Sl_No</th>
         <th>Name</th>
         <th>City</th>
         <th>Package</th>
         <th>Price</th>
         <th>Operation</th>
         </tr>
        <f:forEach var="tst" items="${touristList}" varStatus="index">
          <tr>
            <td>${index.count}</td>
            <td>${tst.name}</td>
            <td>${tst.city}</td>
            <td>${tst.pakage}</td>
            <td>${tst.price}</td>
            <td><a href="edit?id=${tst.tid}"><button>Edit</button></a> &nbsp;&nbsp;
            <a href="delete?id=${tst.tid}" onclick= "return confirm('Are you sure want to delete the tourist name:: ${tst.name}')"><button>Delete</button></a>
            </td> 
          </tr>
        </f:forEach>
         </table>
   </f:when>
   <f:otherwise>
      <h1 style="text-align: center;color: red">Tourist List is Empty</h1>
   </f:otherwise>
</f:choose>
<br>
<h4 style="text-align: center;color: green;">${msg}</h4>
   <h1 style="text-align: center;"><a href="addtourist"><button>+Add Tourist</button></a></h1>
 <hr>
 <h1 style="text-align: center;"><a href="./"><button>Home</button></a></h1>
</body>
</html>