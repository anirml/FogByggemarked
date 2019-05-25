<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="FunctionLayer.OrderLine" %>
<%@ page import="FunctionLayer.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />
<div class="container jumbotron">
    <div class="row">
        <div class="col">

        <%
        System.out.println("Er i drawpage.jsp");

        List<String> orderInput = new ArrayList<>();
        orderInput = (List<String>) session.getAttribute("list");

        String showStykList= (String) session.getAttribute("showStykList");
        String carportWidS = (String) session.getAttribute("width");
        String carportLenS = (String) session.getAttribute("lenght");
        double carportWid = Double.parseDouble(carportWidS)/100;
        double carportLen = Double.parseDouble(carportLenS)/100;

        %>
        <h1> Carport Fladt tag <%out.print(carportLen+" m  x "+carportWid+" m");%>;</h1>

        <%String svg_fil= (String) session.getAttribute("svg_drawing");
                out.print(svg_fil);%>

        </div>
    </div>


    <%
        if (showStykList.equals("1")) {
    %>
    <td>

        <div class="row">
            <%
                User user = (User) session.getAttribute("user");
                String userType = user.getType();
                ArrayList<OrderLine> tempStykList = new ArrayList();
                tempStykList = (ArrayList<OrderLine>) session.getAttribute("styklist");
                String totalPrice = "";
                String totalPriceKorr = "";
                String procentS = (String) session.getAttribute("procent");
                if (userType.equals("employee")) {
                    totalPrice = (String) session.getAttribute("totalPrice");
                    totalPriceKorr = (String) session.getAttribute("totalPriceKorr");
                    //if (totalPriceKorr.equals(null)) totalPriceKorr.equals(totalPrice);
                }
            %>

            <table class="table table-sm table-striped table-bordered">
                <thead>
                <tr>
                    <th>Beskrivelse</th>
                    <th>Længde</th>
                    <th>Antal</th>
                    <th>Enhed</th>
                    <th>Montering</th>
                    <%
                        if (userType.equals("employee")) {
                    %>
                    <th>EnhedsPris</th>
                    <th>SamletPris</th>
                    <%
                        }
                    %>
                </tr>
                </thead>
                <tbody>

                <%
                    for (int i = 0; i < tempStykList.size(); i++) {
                %>

                <tr>
                    <td scope="row"><%out.print(tempStykList.get(i).getItem().getDesc());%></td>
                    <td><%out.print(tempStykList.get(i).getItem().getLength());%></td>
                    <td><%out.print(tempStykList.get(i).getNumber());%></td>
                    <td><%out.print(tempStykList.get(i).getItem().getUnit());%></td>
                    <td><%out.print(tempStykList.get(i).getComments());%></td>
                    <%
                        if (userType.equals("employee")) {
                    %>
                    <td><%out.print(tempStykList.get(i).getItem().getPrice());%></td>
                    <td><%out.print(tempStykList.get(i).getSumPrice());%></td>
                    <%
                        }
                    %>
                </tr>
                <%
                    }
                %>
                <tr>
                    <th>Samlet Pris</th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <%
                        if (userType.equals("employee")) {
                    %>
                    <th></th>
                    <th><%out.print(totalPrice);%></th>
                    <%
                        }
                    %>

                </tr>

                <%
                    if (userType.equals("employee")) {
                %>

                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <td>
                        <form name="beregn" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="showOrder">
                            <input type="hidden" name="action" value="beregn">
                            <label for="procent">procent +/-</label>
                            <input type="number" class="form-control" id="procent" name="procent"
                                   value="<%out.print(procentS); %>">
                            <input type="submit" value="beregn">
                        </form>
                    </td>
                </tr>



                <tr>
                    <th>Samlet korr. Pris</th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th><%out.print(totalPriceKorr);%></th>

                </tr>

                <%
                    }
                %>

                </tbody>
            </table>
        </div>


        <form name="return" action="FrontController" method="POST">
            <input type="hidden" name="command" value="mypage">
            RETURN:
            <input type="submit" value="Submit">

        </form>
    </td>
    <%
    } else {
    %>
    <td>
        <form name="return" action="FrontController" method="POST">
            <input type="hidden" name="command" value="sendRequest">
            SEND FORESPØRGSEL:
            <input type="submit" value="Submit">

        </form>
    </td>
    <%
        }
    %>



</div>
</br>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
