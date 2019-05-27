<%@ page import="DBAccess.ItemMapper" %>
<%@ page import="FunctionLayer.Wood" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="DBAccess.OrderMapper" %>
<%@ page import="FunctionLayer.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="FunctionLayer.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>requests page</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<jsp:include page="../include/header.jsp" />

     <% System.out.println("Er i requestpage.jsp"); %>

     <div class="container jumbotron">
        <div class="row">
            <div class="col">

            <%

                List<Order> tempOrderList = new ArrayList();
                tempOrderList = (ArrayList<Order>) session.getAttribute("order1List");
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
                    <th>SkurLængde</th>
                    <th>SkurBredde</th>
                    <th>Kommentar</th>
                    <th>Ship Dato</th>
                    <th>Order Pris</th>
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
                    <td> <%out.print(tempOrderList.get(i).getOrderShedLength()); %></td >
                    <td> <%out.print(tempOrderList.get(i).getOrderShedWidth()); %></td >
                    <td> <%out.print(tempOrderList.get(i).getOrderComment());  %></td >
                    <td> <%out.print(tempOrderList.get(i).getOrderShipDate()); %></td>
                    <td> <%out.print(tempOrderList.get(i).getOrderPrice()); %></td>

                    <td><a class="btn btn-primary form-control"
                           href="FrontController?command=showOrder&action=empOrder1&listNo=<%out.print(i);%>">Vis</a>
                    </td>

                    <!--
                    <td>
                        <form action="FrontController" method="POST">
                            <input type="hidden" name="command" value="showOrder">
                            <input type="hidden" name="listNo" value="<%//out.print(i);%>">
                            <input type="submit"  value="Vis" class="btn btn-primary form-control">
                        </form>
                    </td>
                    -->

                    <%
                        }
                    %>

                </tr>

            </table>

        </div>
    </div>

</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
