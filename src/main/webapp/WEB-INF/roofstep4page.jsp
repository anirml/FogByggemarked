<%@ page import="FunctionLayer.Roof" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />
<div class="container jumbotron">
        <div class="row">
            <div class="col-sm-10">
                <h3>Step 4</h3>
                <p>Evt. bemærkninger</p><br>
            </div>
            <div class="col-sm-2">
                <img src="../img/quickmrejs.gif">
            </div>
            </div>
    <form action="FrontController" method="POST">
        <input type="hidden" name="command" value="makeRequest"/>
    <div class="col-md">
        <br>
        <div class="form-group">
            <label for="Comment"><b>Evt. bemærkninger</b></label>
            <textarea class="form-control" name="comment" id="Comment" rows="3"></textarea>
        </div>
        <div class="row">
            <div class="col-md-2 text-center">
                <a class="btn btn-secondary form-control" href="FrontController?command=makeRequestBack&action=bstep3">Step 3</a>
            </div>
        <div class="col-md-8 text-center">
        </div>
        <div class="col-md-2 text-center">
            <input type="hidden" name="action" value="step5"/>
            <input type="submit" value="Vis tegning" class="btn btn-secondary form-control"/>
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