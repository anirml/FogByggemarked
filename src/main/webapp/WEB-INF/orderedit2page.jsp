<%@ page import="FunctionLayer.User" %>
<%@ page import="FunctionLayer.Order" %>
<%@ page import="FunctionLayer.Roof" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: slamr
  Date: 09-06-2019
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />

<%
    System.out.println("Er i orderedit1page.jsp");
    Order tempOrder = (Order) session.getAttribute("order");
    String userEmail = (String) session.getAttribute("userEmail");

    boolean roofPitch = (boolean) session.getAttribute("roofPitch");
    boolean roofChange = (boolean) session.getAttribute("roofChange");
    String roofDesc = (String) session.getAttribute("roofDesc");

%>


<div class="container jumbotron">
    <div class="row">
        <div class="col-sm-10">
            <h3> Rediger Forespørgsel del02</h3>
            <p>Kunden : <% out.print(userEmail); %></p><br>
        </div>
    </div>
    <form action="FrontController" method="POST">
        <input type="hidden" name="command" value="editOrder0"/>

        <b></b>
        <b>OrderId: <% out.print(tempOrder.getOrderId()); %> </b>

        <%
            if (request.getAttribute("message") != null){

        %>
        <div class="alert alert-danger" role="alert">
            <%out.print(request.getAttribute("message")); %>
        </div>
        <% } %>

        <div class="col-md">
            <label><b>Tag</b></label>
            <select class="form-control" name="roof">
               <option value="0" disabled selected>Vælg tag</option>
               <%
                  List<Roof> menuList =null;
                  if (roofPitch) {
                      menuList = (List<Roof>) session.getAttribute("roofPitchMenu");
                  } else {
                      menuList = (List<Roof>) session.getAttribute("roofFlatMenu");
                  }

                  if (!roofChange) {
               %>

                <option value="<%out.print(tempOrder.getOrderRoofMaterial()); %>"
                        selected><%out.print(roofDesc); %> </option>

               <%
                  }
                  String roofSel;
                  for (int i = 0; i < menuList.size(); i++) {
                      roofSel = "<option value=\"_roofid_\">_roofdesc_</option>";

                      String roofid = Integer.toString(menuList.get(i).getRoofId());
                      String roofdesc= menuList.get(i).getRoofDesc();
                      roofSel = roofSel.replace("_roofid_",roofid);
                      roofSel = roofSel.replace("_roofdesc_",roofdesc);
                      out.print(roofSel);
                  }
               %>
            </select>

            <label><b>Redskabsrum bredde</b></label>
            <select class="form-control" name="toolShedWidth">
               <option selected="selected" value="0">Ønsker ikke redskabsrum</option>

               <%
                   List<String> shedWidthlist = new ArrayList<>();
                   shedWidthlist = (List<String>) session.getAttribute("toolshedWidthList");

                   if (tempOrder.getOrderShed()==1) {
               %>

                   <option value="<%out.print(tempOrder.getOrderShedWidth()); %>"
                           selected><%out.print(tempOrder.getOrderShedWidth()); %> cm </option>

               <%
                   }
                   String toolshedWidth;

                   for (int i = 0; i < shedWidthlist.size(); i++) {
                       toolshedWidth = "<option value=\"_shedwidthid_\">_shedwidthdesc_</option>";

                       String shedwidthid = shedWidthlist.get(i);
                       String shedwidthdesc = shedWidthlist.get(i) + " cm";
                       toolshedWidth = toolshedWidth.replace("_shedwidthid_",shedwidthid);
                       toolshedWidth = toolshedWidth.replace("_shedwidthdesc_",shedwidthdesc);
                       out.print(toolshedWidth);
                   }

               %>
            </select>
            <label><b>Redskabsrum længde</b></label>
            <select class="form-control" name="toolShedLength">
               <option selected="selected" value="0">Ønsker ikke redskabsrum</option>
               <%
                    List<String> shedLengthlist = new ArrayList<>();
                    shedLengthlist = (List<String>) session.getAttribute("toolshedLengthList");

                    if (tempOrder.getOrderShed()==1) {
               %>

               <option value="<%out.print(tempOrder.getOrderShedLength()); %>"
                       selected><%out.print(tempOrder.getOrderShedLength()); %> cm </option>

               <%
                    }

                    String toolshedLength;

                    for (int i = 0; i < shedLengthlist.size(); i++) {
                        toolshedLength = "<option value=\"_shedlengthid_\">_shedlengthdesc_</option>";

                        String shedlengthid = shedLengthlist.get(i);
                        String shedlenghtdesc = shedLengthlist.get(i) + " cm";
                        toolshedLength = toolshedLength.replace("_shedlengthid_",shedlengthid);
                        toolshedLength = toolshedLength.replace("_shedlengthdesc_",shedlenghtdesc);
                        out.print(toolshedLength);
                    }
               %>
            </select>

            <br>
            <div class="row">
                 <div class="col-md-2 text-center">
                   <a class="btn btn-secondary form-control" href="FrontController?command=editOrder0&action=back">Tilbage</a>
                 </div>

                 <div class="col-md-8 text-center">
                 </div>
                 <div class="col-md-2 text-center">
                      <input type="hidden" name="action" value="step2"/>
                      <input type="submit" value="videre" class="btn btn-secondary form-control"/>
                 </div>
            </div>
        </div>
    </form>
</div>
</br>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>