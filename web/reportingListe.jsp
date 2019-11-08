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
    <title>Liste des Vols - MESI AVION</title>
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
    <div class="sixteen wide mobile thirteen wide tablet thirteen wide computer right floated column" id="content">
        <div class="ui padded grid">
            <div class="row">
                <h1 class="ui huge dividing header">Liste des reporting</h1>
            </div>
            <div class="row">
                <div class="ui negative message">
                    <div class="header"></div>
                </div>
                <div class="ui positive message">
                    <div class="header"></div>
                </div>
            </div>
            <div class="row">
                <div class="ui middle aligned divided list">
                    <div class="item">
                        <div class="right floated content">
                            <a href="<%=request.getContextPath()+"/reporting/reservationPeriode"%>">
                                <div class="ui icon blue basic button">
                                    <i class="question circle outline icon"></i>
                                </div>
                            </a>
                        </div>
                        <div class="content">
                            Nombre de réservations sur une période donnée
                        </div>
                    </div>
                    <div class="item">
                        <div class="right floated content">
                            <a href="<%=request.getContextPath()+"/reporting/nombrePassager"%>">
                                <div class="ui icon blue basic button">
                                    <i class="question circle outline icon"></i>
                                </div>
                            </a>
                        </div>
                        <div class="content">
                            Nombre de passagers enregistrés dans la base
                        </div>
                    </div>
                    <div class="item">
                        <div class="right floated content">
                            <a href="<%=request.getContextPath()+"/reporting/nombrePassagerReservationPeriode"%>">
                                <div class="ui icon blue basic button">
                                    <i class="question circle outline icon"></i>
                                </div>
                            </a>
                        </div>
                        <div class="content">
                            Nombre de passagers ayant effectué une réservation sur une période donnée
                        </div>
                    </div>
                    <div class="item">
                        <div class="right floated content">
                            <a href="<%=request.getContextPath()+"/reporting/nombreAnnulationPeriode"%>">
                                <div class="ui icon blue basic button">
                                    <i class="question circle outline icon"></i>
                                </div>
                            </a>
                        </div>
                        <div class="content">
                            Nombre d'annulations sur une période donnée
                        </div>
                    </div>
                    <div class="item">
                        <div class="right floated content">
                            <a href="<%=request.getContextPath()+"/reporting/nombreAvionMaintenance"%>">
                                <div class="ui icon blue basic button">
                                    <i class="question circle outline icon"></i>
                                </div>
                            </a>
                        </div>
                        <div class="content">
                            Nombre d'avions actuellement en cours de maintenance
                        </div>
                    </div>
                    <div class="item">
                        <div class="right floated content">
                            <a href="<%=request.getContextPath()+"/reporting/avionPlusVolPeriode"%>">
                                <div class="ui icon blue basic button">
                                    <i class="question circle outline icon"></i>
                                </div>
                            </a>
                        </div>
                        <div class="content">
                            L'avion qui a effectué le plus de vols sur une période donnée
                        </div>
                    </div>
                    <div class="item">
                        <div class="right floated content">
                            <a href="<%=request.getContextPath()+"/reporting/PassagerPlusReservationPeriode"%>">
                                <div class="ui icon blue basic button">
                                    <i class="question circle outline icon"></i>
                                </div>
                            </a>
                        </div>
                        <div class="content">
                            Le passager qui a effectué le plus de réservations sur une période donnée
                        </div>
                    </div>
                    <div class="item">
                        <div class="right floated content">
                            <a href="<%=request.getContextPath()+"/reporting/pourcentageNombreAffaireEcoPeriode"%>">
                                <div class="ui icon blue basic button">
                                    <i class="question circle outline icon"></i>
                                </div>
                            </a>
                        </div>
                        <div class="content">
                            Le pourcentage et le nombre de classe affaire et de classe éco sur une période donnée
                            pour toutes les réservations
                        </div>
                    </div>
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
