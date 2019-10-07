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
                    <a class="active item">Accueil</a>
                    <a class="item" href="<%=request.getContextPath()+"/avion"%>">Avion</a>
                    <a class="item">Vols</a>
                    <a class="item">Reservation</a>
                    <a class="item">Passagers</a>
                    <a class="item">Reporting</a>
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

                    <%--<div class="ui hidden section divider"></div>
                    <div class="row">
                        <h1 class="ui huge dividing header">Section title</h1>
                    </div>
                    <div class="row">
                        <table class="ui single line striped selectable unstackable table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Header</th>
                                <th>Header</th>
                                <th>Header</th>
                                <th>Header</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1,001</td>
                                <td>Lorem</td>
                                <td>ipsum</td>
                                <td>dolor</td>
                                <td>sit</td>
                            </tr>
                            <tr>
                                <td>1,002</td>
                                <td>amet</td>
                                <td>consectetur</td>
                                <td>adipiscing</td>
                                <td>elit</td>
                            </tr>
                            <tr>
                                <td>1,003</td>
                                <td>Integer</td>
                                <td>nec</td>
                                <td>odio</td>
                                <td>Praesent</td>
                            </tr>
                            <tr>
                                <td>1,003</td>
                                <td>libero</td>
                                <td>Sed</td>
                                <td>cursus</td>
                                <td>ante</td>
                            </tr>
                            <tr>
                                <td>1,004</td>
                                <td>dapibus</td>
                                <td>diam</td>
                                <td>Sed</td>
                                <td>nisi</td>
                            </tr>
                            <tr>
                                <td>1,005</td>
                                <td>Nulla</td>
                                <td>quis</td>
                                <td>sem</td>
                                <td>at</td>
                            </tr>
                            <tr>
                                <td>1,006</td>
                                <td>nibh</td>
                                <td>elementum</td>
                                <td>imperdiet</td>
                                <td>Duis</td>
                            </tr>
                            <tr>
                                <td>1,007</td>
                                <td>sagittis</td>
                                <td>ipsum</td>
                                <td>Praesent</td>
                                <td>mauris</td>
                            </tr>
                            <tr>
                                <td>1,008</td>
                                <td>Fusce</td>
                                <td>nec</td>
                                <td>tellus</td>
                                <td>sed</td>
                            </tr>
                            <tr>
                                <td>1,009</td>
                                <td>augue</td>
                                <td>semper</td>
                                <td>porta</td>
                                <td>Mauris</td>
                            </tr>
                            <tr>
                                <td>1,010</td>
                                <td>massa</td>
                                <td>Vestibulum</td>
                                <td>lacinia</td>
                                <td>arcu</td>
                            </tr>
                            <tr>
                                <td>1,011</td>
                                <td>eget</td>
                                <td>nulla</td>
                                <td>Class</td>
                                <td>aptent</td>
                            </tr>
                            <tr>
                                <td>1,012</td>
                                <td>taciti</td>
                                <td>sociosqu</td>
                                <td>ad</td>
                                <td>litora</td>
                            </tr>
                            <tr>
                                <td>1,013</td>
                                <td>torquent</td>
                                <td>per</td>
                                <td>conubia</td>
                                <td>nostra</td>
                            </tr>
                            <tr>
                                <td>1,014</td>
                                <td>per</td>
                                <td>inceptos</td>
                                <td>himenaeos</td>
                                <td>Curabitur</td>
                            </tr>
                            <tr>
                                <td>1,015</td>
                                <td>sodales</td>
                                <td>ligula</td>
                                <td>in</td>
                                <td>libero</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>--%>
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
