package servlet;

import entity.Vol;
import services.LangueService;
import services.PassagerService;
import services.VolService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class VolServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        boolean err = false;
        switch (request.getServletPath()) {
            case "/vol/creation":
                try {
                    request.setAttribute("traduction", LangueService.getMessage());
                    String villeDepart = request.getParameter("villeDepart");
                    String villeArrive = request.getParameter("villeArrive");
                    Vol vol = new Vol();
                    vol.villeDepartVol = villeDepart;
                    vol.villeArriveeVol = villeArrive;
                    VolService.creationVol(vol);
                    message = "Le vol a bien été créé";
                } catch (Exception e) {
                    message = "Une erreur est survenue lors de la création";
                    err = true;
                } finally {
                    response.sendRedirect("/vol?message=" + message + "&err=" + err);
                }
                   // request.getRequestDispatcher("volCreation.jsp").forward(request, response);
                break;
            case "/vol/update":
                try {
                    request.setAttribute("traduction", LangueService.getMessage());
                    String villeDepartEdit = request.getParameter("villeDepart");
                    String villeArriveEdit = request.getParameter("villeArrive");
                    Vol volEdit = new Vol();
                    volEdit.villeDepartVol = villeDepartEdit;
                    volEdit.villeArriveeVol = villeArriveEdit;
                    VolService.creationVol(volEdit);
                    message = "Le vol a bien été modifié";
                } catch (Exception e) {
                    message = "Une erreur est survenue lors de la modification";
                    err = true;
                } finally {
                    response.sendRedirect("/vols?message=" + message + "&err=" + err);
                }
              //  request.getRequestDispatcher("volModification.jsp").forward(request, response);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        boolean err = false;
        // Affichage
        switch (request.getServletPath()) {
            case "/vol":
                request.setAttribute("listeVol", VolService.getVol());
                request.setAttribute("traduction", LangueService.getMessage());
                request.getRequestDispatcher("volListe.jsp").forward(request, response);
                break;
            case "/vol/delete":
                try {
                    VolService.suppressionVol(Long.parseLong(request.getParameter("id")));
                    message = "Le vol a bien été supprimé";
                } catch (Exception e){
                    message = "Une erreur est survenue lors de la suppression";
                    err = true;
                }finally {
                    response.sendRedirect("/vols?message=" + message + "&err=" + err);
                }
                break;
            case "/vol/edition":
                System.out.println(request.getParameter("id"));
                if (request.getParameterMap().containsKey("id")){
                    request.setAttribute("traduction", LangueService.getMessage());
                    request.setAttribute("vol", VolService.getUnVol(Long.parseLong(request.getParameter("id"))));
                    request.getRequestDispatcher("volModification.jsp").forward(request,response);
                    break;
                }
                break;
            case "/vol/creation":
                request.setAttribute("traduction", LangueService.getMessage());
                request.getRequestDispatcher("volCreation.jsp").forward(request,response);

        }
    }
}
