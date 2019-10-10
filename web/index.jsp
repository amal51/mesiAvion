<%--
  Created by IntelliJ IDEA.
  User: mickael.chartrer
  Date: 05/09/2019
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MESI AVION - APPLICATION "Gestion des réservations de billets d'avion</title>
    <link rel="stylesheet" href="../CSS/semantic.min.css">
    <link rel="stylesheet" href="../CSS/Style.css">
    <link rel="stylesheet" type="text/css" href="../CSS/jquery.datetimepicker.min.css" />
</head>
<body id="root">
        <div class="ui tablet computer only padded grid">
            <div class="ui inverted borderless top fixed fluid menu">
                <a class="header item">MESI AVION</a>
                <div class="right menu">
                    <a class="item">Dashboard</a>
                </div>
            </div>
        </div>
        <div class="ui mobile only padded grid">
            <div class="ui top fixed borderless fluid inverted menu">
                <a class="header item">MESI AVION</a>
                <div class="right menu">
                    <div class="item">
                        <button class="ui icon toggle basic inverted button">
                            <i class="content icon"></i>
                        </button>
                    </div>
                </div>
                <div class="ui vertical borderless inverted fluid menu">
                    <a class="item">Dashboard</a>
                </div>
            </div>
        </div>
        <div class="ui padded grid">
            <div class="three wide tablet only three wide computer only column" id="sidebar">
                <div class="ui vertical borderless fluid text menu">
                    <a class="active item" href="<%=request.getContextPath()+"/index"%>">Accueil</a>
                    <a class="item" href="<%=request.getContextPath()+"/avion"%>">Avion</a>
                    <a class="item" href="<%=request.getContextPath()+"/vol"%>">Vols</a>
                    <a class="item" href="<%=request.getContextPath()+"/detailsVols"%>">Détails des Vols</a>
                    <a class="item" href="<%=request.getContextPath()+"/reservation"%>">Reservation</a>
                    <a class="item" href="<%=request.getContextPath()+"/passager"%>">Passagers</a>
                    <a class="item" href="<%=request.getContextPath()+"/reporting"%>">Reporting</a>
                    <div class="ui hidden divider"></div>
                    <a class="item">Français</a>
                    <a class="item">Anglais</a>
                </div>
            </div>
            <div class="sixteen wide mobile thirteen wide tablet thirteen wide computer right floated column" id="content">
                <div class="ui padded grid">
                    <div class="row">
                        <h1 class="ui huge dividing header">Dashboard</h1>
                    </div>
                    <div class="center aligned row">
                        <div class="eight wide mobile four wide tablet four wide computer column">
                            <img class="ui centered small circular image" src="./img/square-image.png"
                            />
                            <div class="ui large basic label">Label</div>
                            <p>Something else</p>
                        </div>
                        <div
                                        class="eight wide mobile four wide tablet four wide computer column"
                        >
                            <img class="ui centered small circular image" src="./img/square-image.png"/>
                            <div class="ui large basic label">Label</div>
                            <p>Something else</p>
                        </div>
                        <div class="eight wide mobile four wide tablet four wide computer column">
                            <img class="ui centered small circular image" src="./img/square-image.png"/>
                            <div class="ui large basic label">Label</div>
                            <p>Something else</p>
                        </div>
                        <div class="eight wide mobile four wide tablet four wide computer column">
                            <img class="ui centered small circular image" src="./img/square-image.png"/>
                            <div class="ui large basic label">Label</div>
                            <p>Something else</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="../JS/jquery.js"></script>
        <script src="../JS/jquery.datetimepicker.full.min.js"></script>
        <script src="../JS/semantic.min.js"></script>
        <script type="text/javascript" src="../JS/javascript.js"></script>
</body>
</html>
