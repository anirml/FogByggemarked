<%@ page import="FunctionLayer.OrderLine" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: slamr
  Date: 02-05-2019
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CALCULATE</title>
</head>
<body>


<td>
    <form name="beregn" action="FrontController" method="POST">
        <input type="hidden" name="command" value="calculate">
        VIS TEGNING:
        <input type="submit" value="Submit">

    </form>
</td>
</body>
</html>
