<%@ page import="DBAccess.ItemMapper" %>
<%@ page import="FunctionLayer.Wood" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="DBAccess.OrderMapper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />

<% System.out.println("Er i requestpage.jsp"); %>

<div class="container jumbotron">
    <div class="row">
        <div class="col">
            <table class="table table-hover table-sm">
                <thead>
                <tr>
                    <th scope="col">woodID</th>
                    <th scope="col">woodDim1</th>
                    <th scope="col">woodDim2</th>
                    <th scope="col">woodDesc</th>
                    <th scope="col">woodLength</th>
                    <th scope="col">woodUnit</th>
                    <th scope="col">woodPrice</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<String> requestList = OrderMapper.readOrders();

                    for (int i = 0; i < requestList.size() ; i++) {
                %>

                <tr >
                    <th scope = "row" > <%out.print(requestList.get(i)); %> </th >
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
