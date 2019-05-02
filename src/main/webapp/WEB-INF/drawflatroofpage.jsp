<%--
  Created by IntelliJ IDEA.
  User: slamr
  Date: 30-04-2019
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1> Carport Fladt tag</h1>

<!--
<img src="../svg/carport_test.svg" width="500" />
-->
<%String svg_fil= (String) session.getAttribute("svg_drawing");
out.print(svg_fil);%>

<p>
    Dette skulle ende med at blive en tegning af en carport med fladt tag.
</p>

</body>
</html>
