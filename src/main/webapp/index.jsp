<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>

    <jsp:include page="include/header.jsp" />


    <div class="container-jumbotron">

        <div class="col text-center">
            <h1>Welcome to Sem 2</h1>
        </div>

        <div class="row">
            <div class="col-lg-4 col-md-3 text-center">
            </div>
            <div class="col-lg-4 col-md-6">


            </div>



        </div>




    </div>

        
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { 
               out.println("<H2>Error!!</h2>");
               out.println(error);
           }
        %>

    </body>
</html>
