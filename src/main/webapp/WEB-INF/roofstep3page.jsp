<%@ page import="FunctionLayer.Roof" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />
<div class="container jumbotron">
        <div class="row">
            <div class="col-sm-10">
                <h3>Step 3</h3>
                <p>Vælg tagtype og hældning på redskabsrum.</p><br>
            </div>
            <div class="col-sm-2">
                <img src="../img/quickmrejs.gif">
            </div>
            </div>
    <form action="FrontController" method="POST">
        <input type="hidden" name="command" value="makeRequest"/>
    <div class="col-md">
        <br>
        <p><b>Redskabsrum:</b><br>
            NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet*</p>
        <label><b>Redskabsrum bredde</b></label>
        <select class="form-control" name="toolShedWidth">
            <option selected="selected" value="0">Ønsker ikke redskabsrum</option>

        <%
            List<String> shedWidthlist = new ArrayList<>();
            shedWidthlist = (List<String>) session.getAttribute("toolshedWidthList");

            System.out.println(shedWidthlist);

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

                System.out.println(shedLengthlist);

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
                <a class="btn btn-secondary form-control" href="FrontController?command=makeRequestBack&action=bstep2">Step 2</a>
            </div>
        <div class="col-md-8 text-center">
        </div>
        <div class="col-md-2 text-center">
            <input type="hidden" name="action" value="step4"/>
            <input type="submit" value="Step 4" class="btn btn-secondary form-control"/>
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