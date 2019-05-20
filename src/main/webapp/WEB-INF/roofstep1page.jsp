<%@ page import="FunctionLayer.Roof" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />
<div class="container jumbotron">
        <div class="row">
            <div class="col-sm-10">
                <h3>Step 1</h3>
                <p>Vælg længde og bredde.</p><br>
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


        <label><b>Carport bredde</b></label>
        <select class="form-control" name="width">
            <option value="0" disabled selected>Vælg bredde
            <option value="240">240 cm</option>
            <option value="270">270 cm</option>
            <option value="300">300 cm</option>
            <option value="330">330 cm</option>
            <option value="360">360 cm</option>
            <option value="390">390 cm</option>
            <option value="420">420 cm</option>
            <option value="450">450 cm</option>
            <option value="480">480 cm</option>
            <option value="510">510 cm</option>
            <option value="540">540 cm</option>
            <option value="570">570 cm</option>
            <option value="600">600 cm</option>
            <option value="630">630 cm</option>
            <option value="660">660 cm</option>
            <option value="690">690 cm</option>


        </select>
        <label><b>Carport længde</b></label>
        <select class="form-control" name="lenght">
            <option value="0" disabled selected>Vælg længde
            <option value="240">240 cm</option>
            <option value="270">270 cm</option>
            <option value="300">300 cm</option>
            <option value="330">330 cm</option>
            <option value="360">360 cm</option>
            <option value="390">390 cm</option>
            <option value="420">420 cm</option>
            <option value="450">450 cm</option>
            <option value="480">480 cm</option>
            <option value="510">510 cm</option>
            <option value="540">540 cm</option>
            <option value="570">570 cm</option>
            <option value="600">600 cm</option>
            <option value="630">630 cm</option>
            <option value="660">660 cm</option>
            <option value="690">690 cm</option>
            <option value="720">720 cm</option>
            <option value="750">750 cm</option>
            <option value="780">780 cm</option>
            <option value="810">810 cm</option>
            <option value="840">840 cm</option>
            <option value="870">870 cm</option>
            <option value="900">900 cm</option>
        </select>
        <br>
        <div class="row">
        <div class="col-md-10 text-center">
        </div>
        <div class="col-md-2 text-center">
            <input type="hidden" name="action" value="step2"/>
            <input type="submit" value="Step 2" class="btn btn-secondary form-control"/>
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