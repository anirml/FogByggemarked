<%@ page import="FunctionLayer.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
    <jsp:include page="../include/header.jsp" />
        <h1>Hello <%=session.getAttribute( "email" )%> </h1>
        You are now logged in as an EMPLOYEE of our wonderful site.

    <%
        ArrayList<Order> tempOrderList = new ArrayList();
        tempOrderList = (ArrayList<Order>) session.getAttribute("orderList");
    %>

    <%
        for (int i = 0; i <tempOrderList.size() ; i++) {
    %>

    <tbody>
    <tr>
        <td><%out.print(tempOrderList.get(i).;%></td>
        <td align="right"><%out.print(tempOrderList.get(i).getItem().getLength());%></td>
        <td align="right"><%out.print(tempOrderList.get(i).getNumber());%> </td>
        <td align="right"><%out.print(tempOrderList.get(i).getItem().getUnit());%></td>
        <td><%out.print(tempOrderList.get(i).getComments());%></td>
    </tr>
        <%
    }
%>


    </body>
</html>
