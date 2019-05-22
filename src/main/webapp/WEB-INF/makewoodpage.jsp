<%@ page import="FunctionLayer.Wood" %>
<%@ page import="DBAccess.ItemMapper" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />

<% System.out.println("Er i makewoodpage.jsp"); %>

<div class="container jumbotron">
    <div class="row">
        <div class="col">
            <div class="form-group">
                <form action="FrontController" method="post">
                    <input type="hidden" name="command" value="makewood"/>

                <label for="woodDim1">WoodDim1 i mm</label>
                <input type="number" class="form-control" id="woodDim1" name="woodDim1">
                <label for="woodDim2">WoodDim2 i mm</label>
                <input type="number" class="form-control" id="woodDim2" name="woodDim2">
                <label for="woodDesc">WoodDesc</label>
                <input type="text" class="form-control" id="woodDesc" name="woodDesc">
                <label for="woodLength">WoodLength</label>
                <input type="number" class="form-control" id="woodLength" name="woodLength">
                <label for="woodUnit">WoodUnit</label>
                <input type="text" class="form-control" id="woodUnit" name="woodUnit">
                <label for="woodPrice">WoodPrice</label>
                <input type="number" class="form-control" id="woodPrice" name="woodPrice">
                    <br>
                    <input type="hidden" name="action" value="makewood"/>
                    <input type="submit" value="Indsæt" class="btn btn-secondary form-control"/>
                </form>
            </div>
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
