<%--
  Created by IntelliJ IDEA.
  User: mickael.chartrer
  Date: 12/09/2019
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <c:set var="reservation" value="${resersation}"></c:set>
    <title>Réservation - MESI AVION</title>
    <link rel="stylesheet" href="../CSS/semantic.min.css">
    <link rel="stylesheet" href="../CSS/Style.css">
</head>

<body id="root">
<%--header--%>
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
        <a class="header item" href="<%=request.getContextPath()+"/"%>">MESI AVION</a>
        <div class="right menu">
            <div class="item">
                <button class="ui icon toggle basic inverted button">
                    <i class="content icon"></i>
                </button>
            </div>
        </div>
        <div class="ui vertical borderless inverted fluid menu">
            <a class="item"href="<%=request.getContextPath()+"/"%>">Dashboard</a>
        </div>
    </div>
</div>
<%--Menu--%>
<div class="ui padded grid">
    <div class="three wide tablet only three wide computer only column" id="sidebar">
        <div class="ui vertical borderless fluid text menu">
            <a class="active item" href="<%=request.getContextPath()+"/"%>">Accueil</a>
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
    <%--Contenu de la page--%>
    <div class="sixteen wide mobile thirteen wide tablet thirteen wide computer right floated column" id="content">
        <div class="ui padded grid">
            <div class="row">
                <h1 class="ui huge dividing header">Création d'une réservation </h1>
            </div>
            <div class="row">
                <form class="ui form" method="post">
                    <div class="field">
                        <label>Classe : </label>
                        <select class="ui selection dropdown" name="classe">
                                <option value="A">Classe Affaire</option>
                                <option value="E">Classe économique</option>
                        </select>
                    </div>
                    <div class="field">
                        <label> Vol : </label>
                        <select class="ui selection dropdown" name="vol">
                            <c:forEach items="${listeVol}" var="listevol" varStatus="status">
                            <option value="${listevol.idVol}">${listevol.villeDepartVol} - ${listevol.villeArriveeVol}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="field">
                        <label>Date de voyage : </label>
                        <div class="ui calendar" id="date">
                            <div class="ui input left icon">
                                <i class="calendar icon"></i>
                                <input type="text" placeholder="Date/Time">
                            </div>
                        </div>
                    </div>
                    <div class="field">
                        <label>Modèle d'avion : </label>
                        <select class="ui selection dropdown" name="modele">
                            <c:forEach items="${listeAvion}" var="listeavion" varStatus="status">
                                <option value="${listeavion.ARN}">${listeavion.modeleAvion.nomAvion}, ${listeavion.ARN}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button class="ui green button" type="submit">Valider la création</button>
                </form>
            </div>
            <div class="row">
                <a href="<%=request.getContextPath()+"/reservation/creation"%>">
                    <div class="ui animated fade blue basic button" tabindex="0">
                        <div class="visible content">Créer une nouvelle réservation</div>
                        <div class="hidden content">
                            <i class="calendar plus icon"></i>
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
<script type="text/javascript" src="../JS/javascript.js"></script>
</body>
</html>
