package servlet;

import config.HibernateUtil;
import entity.Avion;
import entity.Constructeur;
import entity.ModeleAvion;
import org.hibernate.Session;
import services.AvionService;
import services.ConstructeurAvionService;
import services.LangueService;
import services.ModeleAvionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AvionServlet")
public class AvionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        boolean err = false;
        switch (request.getServletPath()) {
            case "/avion/creation":
                try {
                    request.setAttribute("traduction", LangueService.getMessage());
                    String ARN = request.getParameter("ARN");
                    Long modeleAvion = Long.parseLong(request.getParameter("modeleAvion"));
                    Long constructeur = Long.parseLong(request.getParameter("constructeur"));
                    Avion avion = new Avion();
                    avion.ARN = ARN;
                    avion.modeleAvion = ModeleAvionService.getUnModele(modeleAvion);
                    avion.modeleAvion.constructeur = ConstructeurAvionService.getUnConstructeur(constructeur);
                    AvionService.creationAvion(avion);
                    message = "L'avion a bien été créé";
                } catch (Exception e) {
                    message = "Une erreur est survenue lors de la création";
                    err = true;
                } finally {
                    response.sendRedirect("/avion?message=" + message + "&err=" + err);
                }
                break;
            case "/avion/edition":
                try {
                    request.setAttribute("traduction", LangueService.getMessage());
                    String ARNEdit = request.getParameter("ARN");
                    System.out.println("ARN " + request.getParameter("ARN"));
                    System.out.println("MODELE " + request.getParameter("modeleAvion"));
                    Long modeleAvionEdit = Long.parseLong(request.getParameter("modeleAvion"));
                    Long constructeurEdit = Long.parseLong(request.getParameter("constructeur"));
                    Avion avionEdit = new Avion();
                    avionEdit.ARN = ARNEdit;
                    avionEdit.modeleAvion = ModeleAvionService.getUnModele(modeleAvionEdit);
                    avionEdit.modeleAvion.constructeur = ConstructeurAvionService.getUnConstructeur(constructeurEdit);
                    AvionService.updateAvion(avionEdit);
                    message = "L'avion a bien été modifié";
                } catch (Exception e) {
                    message = "Une erreur est survenue lors de la modification";
                    err = true;
                } finally {
                    response.sendRedirect("/avion?message=" + message + "&err=" + err);
                }
                //request.getRequestDispatcher("avionCreation.jsp").forward(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        boolean err = false;
        switch (request.getServletPath()) {
            case "/avion":
                request.setAttribute("traduction", LangueService.getMessage());
                request.setAttribute("listeAvion", AvionService.getAvion());
                request.getRequestDispatcher("avionListe.jsp").forward(request, response);
                break;
            case "/avion/delete":
                try{
                    AvionService.suppressionAvion(request.getParameter("id"));
                    message = "L'avion' a bien été supprimé";
                } catch (Exception e){
                    message = "Une erreur est survenue lors de la suppression";
                    err = true;
                }finally {
                    response.sendRedirect("/avion?message=" + message + "&err=" + err);
                }
                break;
            case "/avion/edition":
                System.out.println(request.getParameter("id"));
                if (request.getParameterMap().containsKey("id")){
                    request.setAttribute("traduction", LangueService.getMessage());
                    request.setAttribute("avion", AvionService.getUnAvion(request.getParameter("id")));
                    request.getRequestDispatcher("avionModification.jsp").forward(request,response);
                    break;
                }
                break;
            case "/avion/creation":
                request.setAttribute("traduction", LangueService.getMessage());
                request.setAttribute("listeModele", ModeleAvionService.getModeleAvion());
                request.setAttribute("listeConstructeur", ConstructeurAvionService.getConstructeur());
                request.getRequestDispatcher("avionCreation.jsp").forward(request,response);

        }
    }
}
