package services;

import config.Format;
import config.HibernateUtil;
import entity.Avion;
import entity.DetailsVols;
import entity.Vol;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class DetailVolService {
    public static List<DetailsVols> getDetailVol() {
        Session session = null;

        List<DetailsVols> detailList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery (
                    "from DetailsVols as detail where detail.estActif = true");
            detailList = (List<DetailsVols>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return detailList;
    }

    public static DetailsVols creationDetail(DetailsVols detailsVols){
        Session session = null;
        try {
            if (detailsVols.equals(null)) {
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            DetailsVols nouveaudetailsVols = new DetailsVols();
            nouveaudetailsVols.idVol = detailsVols.idVol;
            nouveaudetailsVols.ARN = detailsVols.ARN;
            nouveaudetailsVols.dateArrivee = detailsVols.dateArrivee;
            nouveaudetailsVols.dateDepart= detailsVols.dateDepart;
            nouveaudetailsVols.estActif = true;

            // Save DetailsVols dans la database
            session.save(nouveaudetailsVols);

            // Commit the transaction
            session.getTransaction().commit();

            return detailsVols;
        }catch (ParseException e){
            System.out.println(e.getMessage());
            return null;
        }catch (Exception e){
            return null;
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static DetailsVols updateDetail(DetailsVols detailsVols) {
        Session session = null;
        Boolean estActif = false;

        try {
            if (detailsVols.equals(null)) {
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Recherche les données du detail du vol choisi
            DetailsVols nouveaudetailsVols = session.find(DetailsVols.class, detailsVols.idDetailsVols);
            //Recherche idVol et ARN
            nouveaudetailsVols.ARN = detailsVols.ARN;
            nouveaudetailsVols.idVol = detailsVols.idVol;
            nouveaudetailsVols.dateArrivee = detailsVols.dateArrivee;
            nouveaudetailsVols.dateDepart = detailsVols.dateDepart;
            //Formatage données
            if (detailsVols.estActif){
                estActif = true;
            }
            nouveaudetailsVols.estActif = estActif;

            // Update detailsVols to database
            session.update(nouveaudetailsVols);

            // Commit the transaction
            session.getTransaction().commit();

            return detailsVols;
        } catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static DetailsVols suppressionDetailsVols(Long idDetail){
        Session session = null;
        try {
            if (idDetail.equals(null)) {
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Recherche les données du vol choisi
            DetailsVols detailsVols = session.find(DetailsVols.class, idDetail);
            // Suppression du detail de la database
            detailsVols.estActif = false;
            session.update(detailsVols);
            // Commit the transaction
            session.getTransaction().commit();
            return detailsVols;
        } catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public static DetailsVols getDetailVol(Long idDetail, Session session){
        DetailsVols id = session.find(DetailsVols.class,idDetail);
        return id;
    }
    public static  DetailsVols getUnDetailVol(Long idDetail){
        Session session = null;
        DetailsVols detailsVols = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            detailsVols = session.get(DetailsVols.class, idDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return detailsVols;
    }
    public static  Long getUnIdDetailVol(Vol vol){
        Long idVol = vol.idVol;
        Session session = null;
        DetailsVols detailsVols = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "FROM DetailsVols WHERE idVol = :idVol";
            Query query = session.createQuery(sql);
            List<DetailsVols> result = query.list();
            idVol = result.get(0).getIdDetailsVols();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return idVol;
    }
}
