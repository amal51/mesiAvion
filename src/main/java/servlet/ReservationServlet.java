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
        String message = null;
        boolean err = false;
        switch (request.getServletPath()) {
            case "/reservation/creation":
                try {
                    Reservation reservation = new Reservation();
                    reservation.idDetailsVols = DetailVolService.getUnDetailVol(Long.parseLong(request.getParameter("idDetailVol")));
                    reservation.classe = request.getParameter("classe").charAt(0);
                    reservation.idPassager = PassagerService.getUnPassager(request.getParameter("passager"));
                    ReservationService.creationReservation(reservation);
                    message = "La réservation a bien été crée";
                } catch (Exception e){
                    message = "Une erreur est survenue lors de la création";
                    err = true;
                } finally {
                    response.sendRedirect("/reservation?message=" + message + "&err=" + err);
                }
                break;
            case "/reservation/edition":
                try {
                    Reservation reservationEdit = new Reservation();
                    reservationEdit.idDetailsVols = DetailVolService.getUnDetailVol(Long.parseLong(request.getParameter("idDetailVol")));
                    reservationEdit.classe = request.getParameter("classe").charAt(0);
                    reservationEdit.idPassager = PassagerService.getUnPassager(request.getParameter("passager"));
                    ReservationService.updateReservation(reservationEdit);
                    message = "La réservation a bien été modifiée";
                } catch (Exception e){
                    message = "Une erreur est survenue lors de la création";
                    err = true;
                } finally {
                    response.sendRedirect("/reservation?message=" + message + "&err=" + err);
                }
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        boolean err = false;
        switch (request.getServletPath()) {
            case "/reservation":
                request.setAttribute("listeReservation", ReservationService.getReservation());
                request.getRequestDispatcher("reservationListe.jsp").forward(request, response);
                break;
            case "/reservation/delete":
                try{
                    ReservationService.suppressionReservation(Long.parseLong(request.getParameter("id")));
                    message = "La reservation a bien été supprimée";
                } catch (Exception e){
                    message = "Une erreur est survenue lors de la suppression";
                    err = true;
                }finally {
                    response.sendRedirect("/reservation?message=" + message + "&err=" + err);
                }
                break;
            case "/reservation/edition":
                System.out.println(request.getParameter("id"));
                if (request.getParameterMap().containsKey("id")){
                    request.setAttribute("listeDetailsVols", DetailVolService.getDetailVol());
                    request.setAttribute("listePassager", PassagerService.getPassagers());
                    request.setAttribute("reservation", ReservationService.getUneReservation(Long.parseLong(request.getParameter("id"))));
                    request.getRequestDispatcher("reservationModification.jsp").forward(request,response);
                    break;
                }
                break;
            case "/reservation/creation":
                request.setAttribute("listeDetailsVols", DetailVolService.getDetailVol());
                request.setAttribute("listePassager", PassagerService.getPassagers());
                request.getRequestDispatcher("reservationCreation.jsp").forward(request,response);

        }
    }
}
