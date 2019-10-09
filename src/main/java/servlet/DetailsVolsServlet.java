package servlet;

import config.APIFormat;
import entity.DetailsVols;
import entity.Vol;
import services.AvionService;
import services.DetailVolService;
import services.VolService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "DetailsVolsServlet")
public class DetailsVolsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/detailsVols/creation":
                DetailsVols detailsVols = new DetailsVols();
                detailsVols.ARN = AvionService.getUnAvion(request.getParameter("ARN"));
                try {
                    detailsVols.dateDepart = APIFormat.DATE_FORMAT.parse(request.getParameter("dateDepart"));
                    detailsVols.dateArrivee = APIFormat.DATE_FORMAT.parse(request.getParameter("dateArrivee"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                DetailVolService.creationDetail(detailsVols);
                request.getRequestDispatcher("detailsVolsListe.jsp").forward(request, response);
                break;
            case "/detailsVols/update":
                DetailsVols detailsVolsEdit = new DetailsVols();
                detailsVolsEdit.ARN = AvionService.getUnAvion(request.getParameter("ARN"));
                try {
                    detailsVolsEdit.dateDepart = APIFormat.DATE_FORMAT.parse(request.getParameter("dateDepart"));
                    detailsVolsEdit.dateArrivee = APIFormat.DATE_FORMAT.parse(request.getParameter("dateArrivee"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                DetailVolService.creationDetail(detailsVolsEdit);
                request.getRequestDispatcher("detailsVolsModification.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/detailsVols":
                request.setAttribute("listeDetailsVols", DetailVolService.getDetailVol());
                request.getRequestDispatcher("detailsVolsListe.jsp").forward(request, response);
                break;
            case "/detailsVols/delete":
                System.out.println(request.getParameter("id") + "delete reservation");
                DetailVolService.suppressionDetailsVols(Long.parseLong(request.getParameter("id")));
                response.sendRedirect("/reservation");
                break;
            case "/detailsVols/edition":
                System.out.println(request.getParameter("id"));
                if (request.getParameterMap().containsKey("id")){
                    request.setAttribute("listeDetailsVols", DetailVolService.getDetailVol());
                    request.getRequestDispatcher("detailsVolsModification.jsp").forward(request,response);
                    break;
                }
                break;
            case "/reservation/creation":
                request.setAttribute("listeDetailsVols", DetailVolService.getDetailVol());
                request.getRequestDispatcher("detailsVolsCreation.jsp").forward(request,response);

        }
    }
}
