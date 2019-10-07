package servlet;

import entity.Avion;
import entity.DetailsVols;
import entity.Reservation;
import entity.Vol;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReservationServlet")
public class ReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/reservation/creation":
                Reservation reservation = new Reservation();
                reservation.idDetailsVols = DetailVolService.getUnDetailVol(VolService.getUnVol(request.getParameter("ARN")));
                reservation.classe = request.getParameter("classe").charAt(0);
                reservation.idPassager = PassagerService.getUnPassager(request.getParameter("passager"));
                ReservationService.creationReservation(reservation);
                request.getRequestDispatcher("reservationCreation.jsp").forward(request, response);
                break;
            case "/reservation/edition":
                Reservation reservationEdit = new Reservation();
                reservationEdit.idReservation = Long.parseLong(request.getParameter("idReservation"));
                reservationEdit.idDetailsVols = DetailVolService.getUnDetailVol(VolService.getUnVol(request.getParameter("ARN")));
                reservationEdit.classe = request.getParameter("classe").charAt(0);
                reservationEdit.idPassager = PassagerService.getUnPassager(request.getParameter("passager"));
                ReservationService.creationReservation(reservationEdit);
                request.getRequestDispatcher("reservationEdition.jsp").forward(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/reservation":
                request.setAttribute("listeReservation", ReservationService.getReservation());
                request.getRequestDispatcher("reservationListe.jsp").forward(request, response);
                break;
            case "/reservation/delete":
                System.out.println(request.getParameter("id") + "delete reservation");
                ReservationService.suppressionReservation(Long.parseLong(request.getParameter("id")));
                response.sendRedirect("/reservation");
                break;
            case "/reservation/edition":
                System.out.println(request.getParameter("id"));
                if (request.getParameterMap().containsKey("id")){
                    request.setAttribute("listeVol", VolService.getVol());
                    request.setAttribute("listeDetailsVols", DetailVolService.getDetailVol());
                    request.setAttribute("listePassager", PassagerService.getPassagers());
                    request.setAttribute("listeAvion", AvionService.getAvion());
                    request.setAttribute("reservation", ReservationService.getUneReservation(Long.parseLong("id")));
                    request.getRequestDispatcher("reservationModification.jsp").forward(request,response);
                    break;
                }
                break;
            case "/reservation/creation":
                request.setAttribute("listeVol", VolService.getVol());
                request.setAttribute("listeDetailsVols", DetailVolService.getDetailVol());
                request.setAttribute("listePassager", PassagerService.getPassagers());
                request.setAttribute("listeAvion", AvionService.getAvion());
                request.getRequestDispatcher("reservationCreation.jsp").forward(request,response);

        }
    }
}
