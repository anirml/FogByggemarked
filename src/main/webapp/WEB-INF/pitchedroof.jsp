<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />
<div class="container jumbotron">
        <div class="row">
            <div class="col-sm-10">
                <h3>QUICK-BYG TILBUD - CARPORT MED REJSNING</h3>
                <p>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en carport indenfor vores standardprogram.</p><br>
                <p>Tilbud og skitsetegning fremsendes med post hurtigst muligt. Standardbyggevejledning medfølger ved bestilling.</p>
                <b>Udfyld nedenstående omhyggeligt og klik på "Bestil tilbud"</b><br>
                <p>Felter markeret * SKAL udfyldes!</p>
            </div>
            <div class="col-sm-2">
                <img src="../img/quickmrejs.gif">
            </div>
            </div>
    <form action="FrontController" method="POST">
        <input type="hidden" name="command" value="getRequest"/>
    <div class="col-md">
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
            <option value="720">720 cm</option>
            <option value="750">750 cm</option>

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

        </select>
        <label><b>Tag</b></label>
        <select class="form-control" name="roof">
            <option value="0" disabled selected>Vælg tag
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>
        <label><b>Tag hældning</b></label>
        <select class="form-control" name="angle">
            <option value="15" selected>15 grader</option>
            <option value="20">20 grader</option>
            <option value="25">25 grader</option>
            <option value="30">30 grader</option>
            <option value="35">35 grader</option>
            <option value="40">40 grader</option>
            <option value="45">45 grader</option>

        </select>
        <br>
        <p><b>Redskabsrum:</b><br>
            NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet*</p>
        <label><b>Redskabsrum bredde</b></label>
        <select class="form-control" name="toolShedWidth">
            <option selected="selected" value="0">Ønsker ikke redskabsrum</option>
            <option value="210">210 cm</option>
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

        </select>
        <label><b>Redskabsrum længde</b></label>
        <select class="form-control" name="toolShedLenght">
            <option selected="selected" value="0">Ønsker ikke redskabsrum</option>
            <option value="150">150 cm</option>
            <option value="180">180 cm</option>
            <option value="210">210 cm</option>
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
        <br>
        <hr>
        <br>
        <div class="form-group">
            <label for="inputName"><b>Navn</b></label>
            <input type="text" class="form-control" id="inputName" name="name">
        </div>
        <div class="form-group">
            <label for="inputAddress"><b>Adresse</b></label>
            <input type="text" class="form-control" id="inputAddress" name="address">
        </div>
        <div class="form-group">
            <label for="inputZipcode"><b>Postnummer og By</b></label>
            <input type="text" class="form-control" id="inputZipcode" name="zipcode">
        </div>
        <div class="form-group">
            <label for="inputPhone"><b>Telefon nummer</b></label>
            <input type="text" class="form-control" id="inputPhone" name="phone">
        </div>
        <div class="form-group">
            <label for="inputEmail"><b>E-mail adresse</b></label>
            <input type="text" class="form-control" id="inputEmail" name="email">
        </div>
        <div class="form-group">
            <label for="Comment"><b>Evt. bemærkninger</b></label>
            <textarea class="form-control" name="comment" id="Comment" rows="2"></textarea>
        </div>
        <div class="col-md-3 text-center">
            <input type="submit" name="sendRequest" value="Send Forespørgsel" class="btn btn-secondary form-control"/>
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