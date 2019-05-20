<%@ page import="DBAccess.ItemMapper" %>
<%@ page import="FunctionLayer.Wood" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />

<% System.out.println("Er i woodmaterialpage.jsp"); %>

<div class="container jumbotron">
    <div class="row">
        <div class="col">
            <a class="btn btn-primary form-control" href="FrontController?command=nav&action=makewood">Indsæt nyt træ i tabel</a>
            <br>
            <br>
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
                    <th scope="col">Edit</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Wood> woodList = ItemMapper.readWoodList();

                    for (int i = 0; i < woodList.size() ; i++) {
                %>

                <tr >
                    <th scope = "row" > <%out.print(woodList.get(i).getWoodId()); %> </th >
                    <td> <%out.print(woodList.get(i).getWoodDim1()); %> </td >
                    <td> <%out.print(woodList.get(i).getWoodDim2()); %> </td >
                    <td> <%out.print(woodList.get(i).getWoodDesc()); %></td >
                    <td> <%out.print(woodList.get(i).getWoodLength()); %></td >
                    <td> <%out.print(woodList.get(i).getWoodUnit());  %></td >
                    <td> <%out.print(woodList.get(i).getWoodPrice());  %></td >
                    <td><a class="btn btn-primary form-control" href="FrontController?command=nav&action=editwood&woodListId=<%out.print(i+1);%>">Rediger</a></td>
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
