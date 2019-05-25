<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<jsp:include page="../include/header.jsp" />

<% System.out.println("Er i registerpage.jsp"); %>

<div class="container jumbotron">
    <div class="row">
        <div class="col text-center">
            <h2>Log ind</h2>
            </br>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-3 text-center">
        </div>
        <div class="col-lg-4 col-md-6">
            <center><h5>Indtast e-mail og kodeord</h5></center>
            <form name="login" action="FrontController" method="POST">
                <input type="hidden" name="command" value="login">
                <div class="input-group mb-2 mr-md-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text"><i class="fas fa-envelope"></i></div>
                    </div>
                    <input type="text" class="form-control" name="email" placeholder="e-mail">
                </div>
                <div class="input-group mb-2 mr-sm-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text"><i class="fas fa-lock"></i></div>
                    </div>
                    <input type="password" class="form-control" name="password" placeholder="kodeord">
                </div>
                <div class="input-group mb-2 mr-sm-2 justify-content-center">
                    <input type="submit" name="loginknap" value="Log ind" class="btn btn-success btn-block"/>
                </div>
            </form>
        </div>
        <div class="col-lg-4 col-md-3 text-center">
        </div>
    </div>

    <div class="row">
        <div class="col text-center">
            <h2>Opret</h2>
            </br>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-3 text-center">
        </div>
        <div class="col-lg-4 col-md-6">
            <center><h5>Indtast oplysninger</h5></center>
            <form name="register" action="FrontController" method="POST">
                <input type="hidden" name="command" value="register">
                <div class="input-group mb-2 mr-md-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text"><i class="fas fa-user"></i></div>
                    </div>
                    <input type="text" class="form-control" name="name" placeholder="navn">
                </div>
                <div class="input-group mb-2 mr-md-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text"><i class="fas fa-envelope"></i></div>
                    </div>
                    <input type="text" class="form-control" name="email" placeholder="e-mail">
                </div>
                <div class="input-group mb-2 mr-sm-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text"><i class="fas fa-lock"></i></div>
                    </div>
                    <input type="password" class="form-control" name="password1" placeholder="kodeord">
                </div>
                <div class="input-group mb-2 mr-sm-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text"><i class="fas fa-lock"></i></div>
                    </div>
                    <input type="password" class="form-control" name="password2" placeholder="gentag kodeord">
                </div>
                <div class="input-group mb-2 mr-md-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text"><i class="fas fa-home"></i></div>
                    </div>
                    <input type="text" class="form-control" name="address" placeholder="addresse">
                </div>
                <div class="input-group mb-2 mr-md-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text"><i class="fas fa-map-marker-alt"></i></div>
                    </div>
                    <input type="number" class="form-control" name="zipcode" placeholder="postnummer">
                </div>
                <div class="input-group mb-2 mr-md-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text"><i class="fas fa-industry"></i></div>
                    </div>
                    <input type="text" class="form-control" name="city" placeholder="by">
                </div>
                <div class="input-group mb-2 mr-md-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text"><i class="fas fa-phone"></i></div>
                    </div>
                    <input type="number" class="form-control" name="phone" placeholder="telefon">
                </div>
                <div class="input-group mb-2 mr-sm-2 justify-content-center">
                    <input type="submit" name="opretknap" value="Opret" class="btn btn-success btn-block"/>
                </div>
            </form>
        </div>
        <div class="col-lg-4 col-md-3 text-center">
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
