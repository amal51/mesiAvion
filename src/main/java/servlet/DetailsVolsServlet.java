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
        String message = null;
        boolean err = false;
        switch (request.getServletPath()) {
            case "/detailsVols/creation":
                try {
                    DetailsVols detailsVols = new DetailsVols();
                    detailsVols.ARN = AvionService.getUnAvion(request.getParameter("ARN"));
                    detailsVols.idVol = VolService.getUnVol(Long.parseLong(request.getParameter("vol")));
                    detailsVols.dateDepart = APIFormat.FORMAT_API.parse(request.getParameter("dateDepart"));
                    detailsVols.dateArrivee = APIFormat.FORMAT_API.parse(request.getParameter("dateArrivee"));
                    DetailVolService.creationDetail(detailsVols);
                    message = "Le détail de vol a bien été créé";
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    message = "Une erreur est survenue lors de la création";
                    err = true;
                } finally {
                    response.sendRedirect("/detailsVols?message=" + message + "&err=" + err);
                }
                break;
            case "/detailsVols/edition":
                DetailsVols detailsVolsEdit = new DetailsVols();
                try {
                    detailsVolsEdit.ARN = AvionService.getUnAvion(request.getParameter("ARN"));
                    detailsVolsEdit.idVol = VolService.getUnVol(Long.parseLong(request.getParameter("vol")));
                    detailsVolsEdit.dateDepart = APIFormat.FORMAT_API.parse(request.getParameter("dateDepart"));
                    detailsVolsEdit.dateArrivee = APIFormat.FORMAT_API.parse(request.getParameter("dateArrivee"));
                    DetailVolService.updateDetail(detailsVolsEdit);
                    message = "Le détail de vol a bien été modifié";
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    message = "Une erreur est survenue lors de la modification";
                    err = true;
                } finally {
                    response.sendRedirect("/detailsVols?message=" + message + "&err=" + err);
                }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        boolean err = false;
        switch (request.getServletPath()) {
            case "/detailsVols":
                request.setAttribute("listeDetailsVols", DetailVolService.getDetailVol());
                request.getRequestDispatcher("detailsVolsListe.jsp").forward(request, response);
                break;
            case "/detailsVols/delete":
                try{
                    DetailVolService.suppressionDetailsVols(Long.parseLong(request.getParameter("id")));
                    message = "Le détail de vol a bien été supprimé";
                } catch (Exception e){
                    message = "Une erreur est survenue lors de la suppression";
                    err = true;
                }finally {
                    response.sendRedirect("/detailsVols?message=" + message + "&err=" + err);
                }
                break;
            case "/detailsVols/edition":
                System.out.println(request.getParameter("id"));
                if (request.getParameterMap().containsKey("id")){
                    request.setAttribute("listeDetailsVols", DetailVolService.getUnDetailVol(Long.parseLong(request.getParameter("id"))));
                    request.setAttribute("listeVol", VolService.getVol());
                    request.setAttribute("listeAvion", AvionService.getAvion());
                    request.getRequestDispatcher("detailsVolsModification.jsp").forward(request,response);
                    break;
                }
                break;
            case "/detailsVols/creation":
                request.setAttribute("listeDetailsVols", DetailVolService.getDetailVol());
                request.setAttribute("listeVol", VolService.getVol());
                request.setAttribute("listeAvion", AvionService.getAvion());
                request.getRequestDispatcher("detailsVolsCreation.jsp").forward(request,response);
                break;
        }
    }
}
