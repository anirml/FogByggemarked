<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="FunctionLayer.OrderLine" %><%--
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
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

    </style>
    <title>Document</title>
</head>
<body>
<%
    List<String> orderInput = new ArrayList<>();
    orderInput = (List<String>) session.getAttribute("list");

    String carportWidS = orderInput.get(0);
    String carportLenS = orderInput.get(1);
    double carportWid = Double.parseDouble(carportWidS)/100;
    double carportLen = Double.parseDouble(carportLenS)/100;


%>

<h1> Carport Fladt tag <%out.print(carportLen+" m  x "+carportWid+" m");%>;</h1>




<!--
<img src="../svg/carport_test.svg" width="500" />
-->
<%String svg_fil= (String) session.getAttribute("svg_drawing");
out.print(svg_fil);%>
<br/>
<%
    ArrayList<OrderLine> tempStykList = new ArrayList();
    tempStykList = (ArrayList<OrderLine>) session.getAttribute("styklist");
%>

<table>
    <thead>
    <tr>
        <th>Beskrivelse</th>
        <th>Længde</th>
        <th>Antal</th>
        <th>Enhed</th>
        <th>Montering</th>
    </tr>
    </thead>

<%
    for (int i = 0; i <tempStykList.size() ; i++) {
%>

    <tbody>
    <tr>
        <td><%out.print(tempStykList.get(i).getItem().getDesc());%></td>
        <td align="right"><%out.print(tempStykList.get(i).getItem().getLength());%></td>
        <td align="right"><%out.print(tempStykList.get(i).getNumber());%> </td>
        <td align="right"><%out.print(tempStykList.get(i).getItem().getUnit());%></td>
        <td><%out.print(tempStykList.get(i).getComments());%></td>
    </tr>
<%
    }
%>

    </tbody>
</table>



<div class="collapse navbar-collapse" id="navbarMenu">
    <ul class="nav navbar-nav">

        <li class="nav-item">
            <a href="FrontController?command=nav&action=pitchedroof" class="nav-link ">Quick-Byg</a>
        </li>


    </ul>

</div>



<p>
    Dette skulle ende med at blive en tegning af en carport med fladt tag.
</p>

</body>
</html>
