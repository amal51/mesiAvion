package servlet;

import config.APIFormat;
import entity.Passagers;
import services.PassagerService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "PassagerServlet")
public class PassagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        boolean err = false;
        switch (request.getServletPath()) {
            case "/passager/creation":
               try {
                    String numeroCNI = request.getParameter("numeroCNI");
                    String nomPassager = request.getParameter("nomPassager");
                    String prenomPassager = request.getParameter("prenomPassager");
                    String emailPassager = request.getParameter("emailPassager");
                    String genrePassager = request.getParameter("genrePassager");
                    String numeroTelephonePassager = request.getParameter("numeroTelephonePassager");
                    String motDePassePassager = request.getParameter("MotDePassePassager");
                    Date dateNaissancePassager = new Date();
                    dateNaissancePassager = APIFormat.DATE_NAISSANCE.parse(request.getParameter("dateNaissancePassager"));
                    Passagers passagers = new Passagers();
                    passagers.numeroCNI = numeroCNI;
                    passagers.nomPassager = nomPassager;
                    passagers.prenomPassager = prenomPassager;
                    passagers.emailPassager = emailPassager;
                    passagers.genrePassager = genrePassager.charAt(0);
                    passagers.dateNaissancePassager = dateNaissancePassager;
                    passagers.numeroTelephonePassager = numeroTelephonePassager;
                    passagers.motDePassePassager = motDePassePassager;
                    PassagerService.creationPassager(passagers);
                    message = "Le passager a bien été créé";
               } catch (ParseException e) {
                    e.printStackTrace();
               } catch (Exception e){
               message = "Une erreur est survenue lors de la création";
                   err = true;
               } finally {
                   response.sendRedirect("/passager?message=" + message + "&err=" + err);
               }
                break;
            case "/passager/edition":

                try {
                    String numeroCNIEdit = request.getParameter("numeroCNI");
                    String nomPassagerEdit = request.getParameter("nomPassager");
                    String prenomPassagerEdit = request.getParameter("prenomPassager");
                    String emailPassagerEdit = request.getParameter("emailPassager");
                    String genrePassagerEdit = request.getParameter("genrePassager");
                    String numeroTelephonePassagerEdit = request.getParameter("numeroTelephonePassager");
                    String motDePassePassagerEdit = request.getParameter("MotDePassePassager");
                    Date dateNaissancePassagerEdit = new Date();
                    dateNaissancePassagerEdit = APIFormat.DATE_NAISSANCE.parse(request.getParameter("dateNaissancePassager"));
                    Passagers passagersEdit = new Passagers();
                    passagersEdit.numeroCNI = numeroCNIEdit;
                    passagersEdit.nomPassager = nomPassagerEdit;
                    passagersEdit.prenomPassager = prenomPassagerEdit;
                    passagersEdit.emailPassager = emailPassagerEdit;
                    passagersEdit.genrePassager = genrePassagerEdit.charAt(0);
                    passagersEdit.dateNaissancePassager = dateNaissancePassagerEdit;
                    passagersEdit.numeroTelephonePassager = numeroTelephonePassagerEdit;
                    passagersEdit.motDePassePassager = motDePassePassagerEdit;
                    PassagerService.updatePassager(passagersEdit);
                    message = "Le passager a bien été modifié";
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (Exception e){
                    message = "Une erreur est survenue lors de l'édition";
                    err = true;
                } finally {
                    response.sendRedirect("/passager?message=" + message + "&err=" + err);
                 }

                //request.getRequestDispatcher("passagerListe.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        boolean err = false;
        switch (request.getServletPath()) {
            case "/passager":
                request.setAttribute("listePassager", PassagerService.getPassagers());
                request.getRequestDispatcher("passagerListe.jsp").forward(request, response);
                break;
            case "/passager/delete":
                try{
                    PassagerService.suppressionPassager(request.getParameter("id"));
                    response.sendRedirect("/passager");
                } catch (Exception e){
                    message = "Une erreur est survenue lors de la suppression";
                    err = true;
                }finally {
                    response.sendRedirect("/passager?message=" + message + "&err=" + err);
                }
                break;
            case "/passager/edition":
                System.out.println(request.getParameter("id"));
                if (request.getParameterMap().containsKey("id")){
                    request.setAttribute("passager", PassagerService.getUnPassager(request.getParameter("id")));
                    request.getRequestDispatcher("passagerModification.jsp").forward(request,response);
                    break;
                }
                break;
            case "/passager/creation":
                request.getRequestDispatcher("passagerCreation.jsp").forward(request,response);

        }
    }
}
