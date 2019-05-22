<%@ page import="FunctionLayer.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DBAccess.UserMapper" %><%--
<%@ page import="DBAccess.UserMapper" %>
<%--
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
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
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
            <%
                List<Order> userOrderList = (List<Order>) session.getAttribute("orderList");
            <%
            %>

            String userId = (String) session.getAttribute("id");
            System.out.println(userId);
            List<Order> userOrderList = OrderMapper.readUserOrders(userId);
            <table style="width:70%" align="center">
                <tr>
                    <th>OrderId</th>
                    <th>OrderDato</th>
                    <th>Status</th>
                    <th>Tagvinkel</th>
                    <th>TagMatr</th>
                    <th>Længde</th>
                    <th>Bredde</th>
                    <th>Skur ja/nej</th>
                    <th>SkurLængde</th>
                    <th>SkurBredde</th>
                    <th>Kommentar</th>
                </tr>
                    <%
                for (int i = 0; i <userOrderList.size() ; i++) {
            %>

                for (int i = 0; i < userOrderList.size() ; i++) {
                %>
                <tr >
                    <th scope = "row" > <%out.print(userOrderList.get(i).getUserId()); %> </th >
                    <td> <%out.print(userOrderList.get(i).getOrderStatus()); %> </td >
                    <td> <%out.print(userOrderList.get(i).getOrderRoofAngle()); %> </td >
                    <td> <%out.print(userOrderList.get(i).getOrderLength()); %></td >
                    <td> <%out.print(userOrderList.get(i).getOrderWidth()); %></td >
                    <td> <%out.print(userOrderList.get(i).getOrderShed());  %></td >
                    <td> <%out.print(userOrderList.get(i).getOrderComment());  %></td >
                </tr >
                    <%
                    }
                %>
                <tr>
                    <td> <%out.print(userOrderList.get(i).getOrderId()); %></td>
                    <td> <%out.print(userOrderList.get(i).getOrderDate());%></td>
                    <td> <%out.print(userOrderList.get(i).getOrderStatus()); %> </td >
                    <td> <%out.print(userOrderList.get(i).getOrderRoofAngle()); %> </td >
                    <td> <%out.print(userOrderList.get(i).getOrderRoofMaterial()); %></td>
                    <td> <%out.print(userOrderList.get(i).getOrderLength()); %></td >
                    <td> <%out.print(userOrderList.get(i).getOrderWidth()); %></td >
                    <td> <%out.print(userOrderList.get(i).getOrderShed());  %></td >
                    <td> <%out.print(userOrderList.get(i).getOrderShedLength()); %></td >
                    <td> <%out.print(userOrderList.get(i).getOrderShedWidth()); %></td >
                    <td> <%out.print(userOrderList.get(i).getOrderComment());  %></td >

                    <td>
                        <form action="FrontController" method="POST">
                            <input type="hidden" name="command" value="showOrder">
                            <input type="hidden" name="orderId" value="<%out.print(i);%>">
                            <input type="submit"  value="Vis" class="btn btn-primary form-control">
                        </form>
                    </td>

        </div>
        <%
            }
        %>

    </div>

</div>
</tr>

</table>

</div>

</body>
</html>
</html>
