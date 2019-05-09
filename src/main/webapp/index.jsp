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


    <h1>Welcome to Sem 2</h1>
        
        <table>
                <td>
                    <form name="bestil" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="choice">
                        Bestil:
                        <input type="submit" value="Submit">

                    </form>
                </td>

                <td>
                    <form name="beregn" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="calculate">
                        Beregn:
                        <input type="submit" value="Submit">

                    </form>
                </td>

            </tr>
        </table>
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { 
               out.println("<H2>Error!!</h2>");
               out.println(error);
           }
        %>

    </body>
</html>
