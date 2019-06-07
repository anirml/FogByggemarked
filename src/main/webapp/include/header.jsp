<%--
  Created by IntelliJ IDEA.
  User: Jeppe
  Date: 25-04-2019
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Fog Byggemarked</title>
    <link rel="icon" href="img/favicon.ico" type="image/gif" sizes="16x16">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
</head>
<body>
<div class="container" id="navbar">
    <img src="img/banner.png" class="img-fluid" alt="Responsive image">
    <nav class="navbar navbar-expand-md navbar-light bg-light">
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarMenu">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarMenu">
            <ul class="nav navbar-nav">
                <li class="nav-item">
                    <a href="index.jsp" class="nav-link navbar-custom">Forside</a>
                </li>

                <%
                    String userEmail = (String)session.getAttribute("email");
                    String userType = (String)session.getAttribute("type");
                    if (userType == null){
                        userType = "";
                    } else if(userType.equals("customer") || userType.equals("employee")){
                %>
                <li class="nav-item">
                    <a href="FrontController?command=nav&action=quickbyg" class="nav-link ">Quick-Byg</a>
                </li>
                <%
                    } if (userType.equals("employee")){
                %>
                <li class="nav-item">
                    <a href="FrontController?command=nav&action=woodmaterial" class="nav-link ">Wood list</a>
                </li>
                <li class="nav-item">
                    <a href="FrontController?command=nav&action=roofmaterial" class="nav-link ">Roof list</a>
                </li>
                <li class="nav-item">
                    <a href="FrontController?command=nav&action=requests" class="nav-link ">Vis færdig ordre</a>
                </li>



                <%
                    }
                %>

            </ul>
            <ul class="nav navbar-nav ml-auto">
                <%
                    if (userType.equals("")) {
                %>

                <li class="nav-item"><a href="FrontController?command=nav&action=register" class="nav-link">
                    <span class="fas fa-user"></span> Log Ind</a></li>

                <%
                    }

                    if (userType.equals("employee") || userType.equals("customer")) {
                %>

                <li id="mypage_button">
                            <a href="FrontController?command=nav&action=<%=userType%>" class="nav-link ">
                                <span class="fas fa-envelope"></span>  <%=userEmail%></a>
                </li>

                <form name="command" value="login" action="FrontController" method="POST">
                    <li id="logout_button">
                        <input type="hidden" name="command" value="logout">
                        <input type="submit" name="logoutknap" value="Log ud" class="btn btn-success btn-block"/>
                    </li>
                </form>

                <%
                    }
                %>

            </ul>
        </div>
    </nav>
</div>
</body>
</html>