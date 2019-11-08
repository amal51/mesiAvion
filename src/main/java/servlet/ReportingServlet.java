package servlet;

import config.APIFormat;
import services.ReportingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "ReportingServlet")
public class ReportingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        boolean err = false;
        Date debut, fin;
        switch (request.getServletPath()) {
            case "/reporting":
                //request.setAttribute("listeReservation", ReservationService.getReservation());
                request.getRequestDispatcher("reportingListe.jsp").forward(request, response);
                break;

            case "/reporting/reservationPeriode":
                try {
                    debut = APIFormat.DATE_NAISSANCE.parse(request.getParameter("debut"));
                    fin = APIFormat.DATE_NAISSANCE.parse(request.getParameter("fin"));
                    System.out.println(debut + " " + fin);
                    request.setAttribute("resultat", ReportingService.reservationPeriode(debut, fin));
                    request.getRequestDispatcher("reportingRequete.jsp").forward(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                    message = "Une erreur est survenue lors de la création";
                    err = true;
                    response.sendRedirect("/reporting?message=" + message + "&err=" + err);
                } catch (Exception e){
                    message = "Une erreur est survenue lors de la requête";
                    err = true;
                    response.sendRedirect("/reporting?message=" + message + "&err=" + err);
                }
            case "/reporting/nombrePassager":
                request.setAttribute("resultat", ReportingService.nombrePassager());
                request.getRequestDispatcher("reportingRequete.jsp").forward(request, response);
            case "/reporting/nombrePassagerReservationPeriode":
                try {
                    debut = APIFormat.DATE_FORMAT.parse(request.getParameter("debut"));
                    fin = APIFormat.DATE_FORMAT.parse(request.getParameter("fin"));
                    request.setAttribute("resultat", ReportingService.nombrePassagerPeriode(debut, fin));
                    request.getRequestDispatcher("reportingRequete.jsp").forward(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                    message = "Une erreur est survenue lors de la création";
                    err = true;
                    response.sendRedirect("/reporting?message=" + message + "&err=" + err);
                } catch (Exception e){
                    message = "Une erreur est survenue lors de la requête";
                    err = true;
                    response.sendRedirect("/reporting?message=" + message + "&err=" + err);
                }
            case "/reporting/nombreAnnulationPeriode":
                try {
                    debut = APIFormat.DATE_FORMAT.parse(request.getParameter("debut"));
                    fin = APIFormat.DATE_FORMAT.parse(request.getParameter("fin"));
                    request.setAttribute("resultat", ReportingService.nombreAnnulation(debut, fin));
                    request.getRequestDispatcher("reportingRequete.jsp").forward(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                    message = "Une erreur est survenue lors de la création";
                    err = true;
                    response.sendRedirect("/reporting?message=" + message + "&err=" + err);
                } catch (Exception e){
                    message = "Une erreur est survenue lors de la requête";
                    err = true;
                    response.sendRedirect("/reporting?message=" + message + "&err=" + err);
                }
            case "/reporting/nombreAvionMaintenance":
                request.setAttribute("resultat", ReportingService.nombreAvionMaintenance());
                request.getRequestDispatcher("reportingRequete.jsp").forward(request, response);
            case "/reporting/avionPlusVolPeriode":
                try {
                    debut = APIFormat.DATE_FORMAT.parse(request.getParameter("debut"));
                    fin = APIFormat.DATE_FORMAT.parse(request.getParameter("fin"));
                    request.setAttribute("resultat", ReportingService.AvionPlusVol(debut, fin));
                    request.getRequestDispatcher("reportingRequete.jsp").forward(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                    message = "Une erreur est survenue lors de la création";
                    err = true;
                    response.sendRedirect("/reporting?message=" + message + "&err=" + err);
                } catch (Exception e){
                    message = "Une erreur est survenue lors de la requête";
                    err = true;
                    response.sendRedirect("/reporting?message=" + message + "&err=" + err);
                }
            case "/reporting/PassagerPlusReservationPeriode":
                try {
                    debut = APIFormat.DATE_FORMAT.parse(request.getParameter("debut"));
                    fin = APIFormat.DATE_FORMAT.parse(request.getParameter("fin"));
                    request.setAttribute("resultat", ReportingService.PassagerPlusReservation(debut, fin));
                    request.getRequestDispatcher("reportingRequete.jsp").forward(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                    message = "Une erreur est survenue lors de la création";
                    err = true;
                    response.sendRedirect("/reporting?message=" + message + "&err=" + err);
                } catch (Exception e){
                    message = "Une erreur est survenue lors de la requête";
                    err = true;
                    response.sendRedirect("/reporting?message=" + message + "&err=" + err);
                }
            case "/reporting/pourcentageNombreAffaireEcoPeriode":
                try {
                    debut = APIFormat.DATE_FORMAT.parse(request.getParameter("debut"));
                    fin = APIFormat.DATE_FORMAT.parse(request.getParameter("fin"));
                    request.setAttribute("resultat", ReportingService.PourcentageNombreAffaireEcoPeriode(debut, fin));
                    request.getRequestDispatcher("reportingRequete.jsp").forward(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                    message = "Une erreur est survenue lors de la création";
                    err = true;
                    response.sendRedirect("/reporting?message=" + message + "&err=" + err);
                } catch (Exception e){
                    message = "Une erreur est survenue lors de la requête";
                    err = true;
                    response.sendRedirect("/reporting?message=" + message + "&err=" + err);
                }
        }
    }
}
