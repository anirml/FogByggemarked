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

        String showStykList= (String) session.getAttribute("showStykList");
        String orderIdS = (String) session.getAttribute("orderId");
        User customUser = (User) session.getAttribute("customUser");
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

    <div class="row">
        <div class="col">
            <%String svg_fil1= (String) session.getAttribute("svg_drawing1");
                out.print(svg_fil1);%>
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
                tempStykList = (ArrayList<OrderLine>) session.getAttribute("stykList");
                String totalPrice = "";
                String totalPriceKorr = "";
                String orderPrice = "";
                String finishOrder = "";
                String procentS = (String) session.getAttribute("procent");
                System.out.println("Er i drawpage under showStykList = 1");
                if (userType.equals("employee")) {
                    totalPrice = (String) session.getAttribute("totalPrice");
                    totalPriceKorr = (String) session.getAttribute("totalPriceKorr");
                    orderPrice = (String) session.getAttribute("orderPrice");
                    finishOrder = (String) session.getAttribute("finishOrder");
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

                <%
                if (userType.equals("employee")) {
                %>
                    <tr>
                       <th>Samlet Pris</th>
                       <th></th>
                       <th></th>
                       <th></th>
                       <th></th>
                       <th></th>
                       <th><%out.print(totalPrice);%></th>
                    </tr>
                    <tr>
                        <% if (finishOrder.equals("0")) { %>
                        <form name="beregn" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="showOrder">
                            <input type="hidden" name="action" value="beregn">
                        <th>
                            <label for="procent">procent +/-</label>
                        </th>
                        <th>
                            <input type="number" class="form-control" id="procent" name="procent"
                                   value="<%out.print(procentS); %>">
                        </th>
                        <th>
                            <input type="submit" value="beregn" class="btn btn-secondary">
                        </th>
                        </form>
                        <%
                            }
                        %>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>

                    </tr>
                    <tr>
                       <th>Samlet korr. Pris</th>
                       <th></th>
                       <th></th>
                       <th></th>
                       <th></th>
                       <th></th>
                        <% if (finishOrder.equals("1")) { %>
                              <th><%out.print(orderPrice);%></th>
                        <% } else { %>
                              <th><%out.print(totalPriceKorr);%></th>
                        <%
                            }
                        %>
                    </tr>
                <%
                }
                %>
                </tbody>
            </table>

        </div>


        <%
        if (userType.equals("employee")) {
        %>
            KUNDE: <%out.print(customUser.getName()+" "+customUser.getEmail()+" "+customUser.getPhone());
            if (finishOrder.equals("0")) {
            %>
        <div class="row" style="margin-top: 15px">
            <div class="col-2">
                <form name="return" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="mypage">
                    <input type="submit" value="Return" class="btn btn-danger form-control">
                </form>
            </div>

            <div class="col-2">
                <form action="FrontController" method="POST">
                    <input type="hidden" name="command" value="finishOrder">
                    <input type="hidden" name="listNo" value="<%out.print(Integer.valueOf(orderIdS));%>">
                    <input type="submit"  value="Send Order" class="btn btn-primary form-control">
                </form>
            </div>
        </div>
        <%
            }
        }
        %>

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

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
