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
        switch (request.getServletPath()) {
            case "/passager/creation":
                String numeroCNI = request.getParameter("numeroCNI");
                String nomPassager = request.getParameter("nomPassager");
                String prenomPassager = request.getParameter("prenomPassager");
                String emailPassager = request.getParameter("emailPassager");
                String genrePassager = request.getParameter("genrePassager");
                String numeroTelephonePassager = request.getParameter("numeroTelephonePassager");
                String motDePassePassager = request.getParameter("MotDePassePassager");
                Date dateNaissancePassager = new Date();
                try {
                     dateNaissancePassager = APIFormat.DATE_NAISSANCE.parse(request.getParameter("dateNaissancePassager"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
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
                request.getRequestDispatcher("passagerCreation.jsp").forward(request, response);
                break;
            case "/passager/edition":
                String numeroCNIEdit = request.getParameter("numeroCNI");
                String nomPassagerEdit = request.getParameter("nomPassager");
                String prenomPassagerEdit = request.getParameter("prenomPassager");
                String emailPassagerEdit = request.getParameter("emailPassager");
                String genrePassagerEdit = request.getParameter("genrePassager");
                String numeroTelephonePassagerEdit = request.getParameter("numeroTelephonePassager");
                String motDePassePassagerEdit = request.getParameter("MotDePassePassager");
                Date dateNaissancePassagerEdit = new Date();
                try {
                    dateNaissancePassagerEdit = APIFormat.DATE_NAISSANCE.parse(request.getParameter("dateNaissancePassager"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
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
                request.getRequestDispatcher("passagerListe.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        switch (request.getServletPath()) {
            case "/passager":
                request.setAttribute("listePassager", PassagerService.getPassagers());
                request.getRequestDispatcher("passagerListe.jsp").forward(request, response);
                break;
            case "/passager/delete":
                System.out.println(" sqd" + request.getParameter("id") + "delete passager");
                PassagerService.suppressionPassager(request.getParameter("id"));
                response.sendRedirect("/passager");
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
