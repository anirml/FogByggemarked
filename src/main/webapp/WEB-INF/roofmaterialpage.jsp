<%@ page import="DBAccess.ItemMapper" %>
<%@ page import="FunctionLayer.Wood" %>
<%@ page import="java.util.List" %>
<%@ page import="FunctionLayer.Roof" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />

<% System.out.println("Er i roofmaterialpage.jsp"); %>

<div class="container jumbotron">
    <div class="row">
        <div class="col">
            <table class="table table-hover table-sm">
                <thead>
                <tr>
                    <th scope="col">roofId</th>
                    <th scope="col">roofDesc</th>
                    <th scope="col">roofColor</th>
                    <th scope="col">roofLength</th>
                    <th scope="col">roofWidth</th>
                    <th scope="col">roofLenDeck</th>
                    <th scope="col">roofWidDeck</th>
                    <th scope="col">roofUnit</th>
                    <th scope="col">roofPrice</th>
                    <th scope="col">roofStatus</th>
                    <th scope="col">roofMenu</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Roof> roofList = ItemMapper.readRoofList();



                    for (int i = 0; i < roofList.size() ; i++) {
                %>

                <tr >
                    <th scope = "row" > <%out.print(roofList.get(i).getRoofId()); %> </th >
                    <td> <%out.print(roofList.get(i).getRoofDesc()); %> </td >
                    <td> <%out.print(roofList.get(i).getRoofColor()); %> </td >
                    <td> <%out.print(roofList.get(i).getRoofLength()); %></td >
                    <td> <%out.print(roofList.get(i).getRoofWidth()); %></td >
                    <td> <%out.print(roofList.get(i).getRoofLenDeck());  %></td >
                    <td> <%out.print(roofList.get(i).getRoofWidDeck());  %></td >
                    <td> <%out.print(roofList.get(i).getRoofUnit());  %></td >
                    <td> <%out.print(roofList.get(i).getRoofPrice());  %></td >
                    <td> <%out.print(roofList.get(i).getRoofStatus());  %></td >
                    <td> <%out.print(roofList.get(i).getRoofMenu());  %></td >
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
