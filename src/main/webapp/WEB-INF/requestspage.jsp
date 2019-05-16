<%@ page import="DBAccess.OrderMapper" %>
<%@ page import="java.util.List" %>
<%@ page import="FunctionLayer.Roof" %>
<%@ page import="FunctionLayer.Order" %>
<%@ page import="FunctionLayer.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DBAccess.ItemMapper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />
<h1>Hello <%=session.getAttribute( "email" )%> </h1>
<div class="container jumbotron">
    <div class="row">
        <div class="col">
            <table class="table table-hover table-sm">
                <thead>
                <tr>
                    <th scope="col">Navn</th>
                    <th scope="col">Email</th>
                    <th scope="col">Adresse</th>
                    <th scope="col">Postnr</th>
                    <th scope="col">By</th>
                    <th scope="col">Tlf</th>
                    <th scope="col">Forspørg Dato</th>
                    <th scope="col">Status</th>
                    <th scope="col">Ordre Sendt Dato</th>
                    <th scope="col">Længde</th>
                    <th scope="col">Bredde</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Order> orderList = OrderMapper.readOrders();

                    for (int i = 0; i < orderList.size() ; i++) {
                %>

                <tr >
                    <th scope = "row" > <%out.print(orderList.get(i).getUserName());%> </th >
                    <td> <%out.print(orderList.get(i).getUserEmail());%> </td >
                    <td> <%out.print(orderList.get(i).getUserAddress());%> </td >
                    <td> <%out.print(orderList.get(i).getUserZipcode());%></td >
                    <td> <%out.print(orderList.get(i).getUserCity());%></td >
                    <td> <%out.print(orderList.get(i).getUserPhone());%></td >
                    <td> <%out.print(orderList.get(i).getOrderDate());%></td >
                    <td> <%out.print(orderList.get(i).getOrderStatus());%></td >
                    <td> <%out.print(orderList.get(i).getOrderShipDate());%></td >
                    <td> <%out.print(orderList.get(i).getOrderLength());%></td >
                    <td> <%out.print(orderList.get(i).getOrderWidth());%></td >
                    <td>
                        <form action="FrontController" method="POST">
                            <input type="hidden" name="command" value="nav"/>
                            <input type="hidden" name="action" value="editorder"/>
                            <input type="hidden" name="orderListId" value="<%out.print(i);%>"/>
                            <input type="submit" value="Rediger" class="btn btn-primary form-control"/>
                        </form>
                    </td>
                </tr >


                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

</div>
</br>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

