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


    <div class="container jumbotron">
        <div class="row">
            <div class="col">
            <%
                String error = (String) request.getAttribute( "error");
            if (( error != null)){

        %>
        <div class="alert alert-danger" role="alert">
            <%out.println("<H2>Error!!</h2>");
            out.println(error); %>
        </div>
            <% } %>
            </div>
        </div>
        <div class="row">
            <div class="col-4">
                <img style="display: block; margin-left: auto; margin-right: auto;" title="Carport" alt="Carport" width="100%" height="100%" src="img/frontimg.png"class="img-responsive">
            </div>
            <div class="col-8">
                <center>
                    <h2>CARPORT I TILPASSEDE MÅL?</h2>
                </center>
                    <p>Med et specialudviklet computerprogram kan vi lynhurtigt beregne
                        prisen og udskrive en skitsetegning på en carport indenfor vores
                        standardprogram - i de mål du ønsker.<br>
                        Tilbud og skitsetegning fremsendes med post hurtigst muligt.</p>
                <center>
                    <%
                        String userType = (String)session.getAttribute("type");
                        if (userType == null){
                            out.print("<a class=\"btn btn-success\" href=\"FrontController?command=nav&action=register\">Log ind</a>");
                        } else if(userType.equals("customer") || userType.equals("employee")){
                            out.print("<a class=\"btn btn-success\" href=\"FrontController?command=nav&action=quickbyg\">Quick-byg</a>");
                        }
                    %>
                </center>
            </div>
        </div>
    </div>

        
<%--        <% String error = (String) request.getAttribute( "error");--%>
<%--           if ( error != null) {--%>
<%--               out.println("<H2>Error!!</h2>");--%>
<%--               out.println(error);--%>
<%--           }--%>
<%--        %>--%>

    </body>
</html>
