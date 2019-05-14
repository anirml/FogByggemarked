<%@ page import="DBAccess.OrderMapper" %>
<%@ page import="FunctionLayer.Order" %>
<%@ page import="java.util.List" %><%--
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
    <jsp:include page="../include/header.jsp" />
    <div class="container-jumbotron">

        <div class="col text-center">
            <h1>Hello <%=session.getAttribute( "email" )%> </h1>
        </div>

        <div class="row">
            <div class="col-lg-4 col-md-3 text-center">
            </div>
            <div class="col-lg-4 col-md-6">


            </div>



        </div>




    </div>
    </body>
</html>
