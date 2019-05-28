<%@ page import="FunctionLayer.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="FunctionLayer.User" %><%--
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


        <%
            System.out.println("Er i employeepage.jsp");
            ArrayList<Order> tempOrderList = new ArrayList();
            tempOrderList = (ArrayList<Order>) session.getAttribute("order0List");
            List<User> tempUserList = (List<User>) session.getAttribute("userList");
        %>


        <table style="width:70%" align="center">
            <tr>
                <th>OrderId</th>
                <th>OrderDato</th>
                <th>UserEmail</th>
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
                for (int i = 0; i <tempOrderList.size() ; i++) {
            %>

            <tr>
                <td> <%out.print(tempOrderList.get(i).getOrderId()); %></td>
                <td> <%out.print(tempOrderList.get(i).getOrderDate());%></td>
                <td> <%
                    for (int j = 0; j <tempUserList.size() ; j++) {
                        if (tempOrderList.get(i).getUserId()==tempUserList.get(j).getIdInt()){
                            out.print(tempUserList.get(j).getEmail());
                        }
                    }
                %>
                </td>
                <td> <%out.print(tempOrderList.get(i).getOrderStatus()); %> </td >
                <td> <%out.print(tempOrderList.get(i).getOrderRoofAngle()); %> </td >
                <td> <%out.print(tempOrderList.get(i).getOrderRoofMaterial()); %></td>
                <td> <%out.print(tempOrderList.get(i).getOrderLength()); %></td >
                <td> <%out.print(tempOrderList.get(i).getOrderWidth()); %></td >
                <td> <%out.print(tempOrderList.get(i).getOrderShed());  %></td >
                <td> <%out.print(tempOrderList.get(i).getOrderShedLength()); %></td >
                <td> <%out.print(tempOrderList.get(i).getOrderShedWidth()); %></td >
                <td> <%out.print(tempOrderList.get(i).getOrderComment());  %></td >


                <td><a class="btn btn-primary form-control"
                       href="FrontController?command=showOrder&action=empOrder0&listNo=<%out.print(i);%>">Vis</a>
                </td>


                <td><a class="btn btn-primary form-control"
                       href="FrontController?command=showOrder&action=delete&listNo=<%out.print(i);%>">Fjern</a>
                </td>

                <!--
                <td>
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="finishOrder">
                        <input type="hidden" name="listNo" value="<%out.print(i);%>">
                        <input type="submit"  value="Send Order" class="btn btn-primary form-control">
                    </form>
                </td>
                -->

                <%
                    }
                %>

            </tr>

        </table>




    </div>

    </body>
</html>
