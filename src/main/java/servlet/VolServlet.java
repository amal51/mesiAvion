package servlet;

import entity.Vol;
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
        switch (request.getServletPath()) {
            case "/vol/creation":
                String villeDepart = request.getParameter("villeDepart");
                String villeArrive = request.getParameter("villeArrive");
                Vol vol = new Vol();
                vol.villeDepartVol = villeDepart;
                vol.villeArriveeVol = villeArrive;
                VolService.creationVol(vol);
                request.getRequestDispatcher("volCreation.jsp").forward(request, response);
                break;
            case "/vol/update":
                String villeDepartEdit = request.getParameter("villeDepart");
                String villeArriveEdit = request.getParameter("villeArrive");
                Vol volEdit = new Vol();
                volEdit.villeDepartVol = villeDepartEdit;
                volEdit.villeArriveeVol = villeArriveEdit;
                VolService.creationVol(volEdit);
                request.getRequestDispatcher("volModification.jsp").forward(request, response);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération des infos de la requête
        System.out.println(request.getServletPath());

        // Affichage
        switch (request.getServletPath()) {
            case "/vol":
                request.setAttribute("listeVol", VolService.getVol());
                request.getRequestDispatcher("volListe.jsp").forward(request, response);
                break;
            case "/vol/delete":
                System.out.println(request.getParameter("id") + "delete vol");
                VolService.suppressionVol(Long.parseLong(request.getParameter("id")));
                response.sendRedirect("/vol");
                break;
            case "/vol/edition":
                System.out.println(request.getParameter("id"));
                if (request.getParameterMap().containsKey("id")){
                    request.setAttribute("vol", VolService.getUnVol(Long.parseLong(request.getParameter("id"))));
                    request.getRequestDispatcher("volModification.jsp").forward(request,response);
                    break;
                }
                break;
            case "/vol/creation":
                request.getRequestDispatcher("volCreation.jsp").forward(request,response);

        }
    }
}
