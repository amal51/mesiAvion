<%--
  Created by IntelliJ IDEA.
  User: mickael.chartrer
  Date: 07/09/2019
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Liste des Avions - MESI AVION</title>
    <link rel="stylesheet" href="CSS/semantic.min.css">
    <link rel="stylesheet" href="CSS/Style.css">
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
            <a class="header item" href="<%=request.getContextPath()+"/index"%>">MESI AVION</a>
            <div class="right menu">
                <div class="item">
                    <button class="ui icon toggle basic inverted button">
                        <i class="content icon"></i>
                    </button>
                </div>
            </div>
            <div class="ui vertical borderless inverted fluid menu">
                <a class="item"href="<%=request.getContextPath()+"/index"%>">Dashboard</a>
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
                    <h1 class="ui huge dividing header">Liste des avions</h1>
                </div>
                <div class="row">
                    <table class="ui single line striped selectable unstackable table">
                        <thead>
                        <tr>
                            <th>ARN</th>
                            <th>Modèle d'Avion</th>
                            <th>Constructeur</th>
                            <th>Nombre de places affaires</th>
                            <th>Nombre de places éco</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listeAvion}" var="avion" varStatus="status">
                                <tr>
                                    <td>${avion.ARN}</td>
                                    <td>${avion.modeleAvion.nomAvion}</td>
                                    <td>${avion.modeleAvion.constructeur.nomConstructeur}</td>
                                    <td>${avion.modeleAvion.nombrePlaceAffaire}</td>
                                    <td>${avion.modeleAvion.nombrePlaceEco}</td>
                                    <td>
                                        <a href="/avion/edition?id=${avion.ARN}" ><i class="edit icon"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a href="<%=request.getContextPath()+"/avion/creation"%>">
                        <div class="ui animated fade blue basic button" tabindex="0">
                            <div class="visible content">Créer un nouvel avion</div>
                            <div class="hidden content">
                                <i class="plane icon"></i>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"></script>
<script>
    $(document).ready(function () {
        $(".ui.toggle.button").click(function () {
            $(".mobile.only.grid .ui.vertical.menu").toggle(100);
        });
    });
</script>
</body>
</html>
