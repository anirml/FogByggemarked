<%@ page import="FunctionLayer.Roof" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />
<div class="container jumbotron">
        <div class="row">
            <div class="col-sm-10">
                <h3>Step 2</h3>
                <p>Vælg tagtype og hældning.</p><br>
            </div>
            <div class="col-sm-2">
                <img src="../img/quickmrejs.gif">
            </div>
            </div>
    <form action="FrontController" method="POST">
        <input type="hidden" name="command" value="makeRequest"/>
    <div class="col-md">

        <%
            if (request.getAttribute("message") != null){

        %>
        <div class="alert alert-danger" role="alert">
            <%out.print(request.getAttribute("message")); %>
        </div>
        <% } %>

        <label><b>Tag</b></label>
        <select class="form-control" name="roof">
            <option value="0" disabled selected>Vælg tag</option>
                    <%
            List<Roof> menuList = (List<Roof>) session.getAttribute("roofPitchMenu");
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

        <label><b>Tag hældning</b></label>
        <select class="form-control" name="angle">
            <option value="0" disabled selected>Vælg hældning</option>
            <option value="15">15 grader</option>
            <option value="20">20 grader</option>
            <option value="25">25 grader</option>
            <option value="30">30 grader</option>
            <option value="35">35 grader</option>
            <option value="40">40 grader</option>
            <option value="45">45 grader</option>

        </select>
        <br>
        <div class="row">
            <div class="col-md-2 text-center">
                <a class="btn btn-secondary form-control" href="FrontController?command=makeRequestBack&action=bstep1">Step 1</a>
            </div>
        <div class="col-md-8 text-center">
        </div>
        <div class="col-md-2 text-center">
            <input type="hidden" name="action" value="step3"/>
            <input type="submit" value="Step 3" class="btn btn-secondary form-control"/>
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