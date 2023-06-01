<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.*" %>
    <%
    String[] image = new String[]{"lord2.jpeg","lord3.jpeg","lord4.jpeg"};
    
    int addNumber = new Random().nextInt(3);
    %>
    
   <img src="images/<%=image[addNumber]%>">