<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />
<div class="container jumbotron">
    <div class="row">
        <div class="col">
            <h3>QUICK-BYG TILBUD - TILBUD</h3>
            <p>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport indenfor vores standardprogram.</p>
            <p>Tilbud og skitsetegning fremsendes med post hurtigst muligt. Standardbyggevejledning medfølger ved bestilling.</p>
            <p>Rekvirér tilbud - start med at vælge type: </p>
            <hr>
            <center><h5>Carport med fladt tag</h5></center>
                <a href="FrontController?command=nav&action=choice&action=flatroofstep1page">
                    <img style="display: block; margin-left: auto; margin-right: auto;" title="Carport med fladt tag" alt="Carport med fladt tag" src="img/quickurejs.gif" height="87" width="165" class="img-responsive">
                </a>
            <br>
            <hr>
            <center><h5>Carport med rejsning</h5></center>
            <a href="FrontController?command=choice&action=pitchedroofstep1page">
                <img style="display: block; margin-left: auto; margin-right: auto;" title="Carport med rejsning" alt="Carport med rejsning" src="img/quickmrejs.gif" height="87" width="165" class="img-responsive">
            </a>
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
