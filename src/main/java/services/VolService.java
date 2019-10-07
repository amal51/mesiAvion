package services;

import config.HibernateUtil;
import entity.Vol;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class VolService {

    public static List<Vol> getVol() {
        Session session = null;

        List<Vol> volList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery (
                    "from Vol as vol where vol.estActif = true order by villeDepartVol");
            volList = (List<Vol>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return volList;
    }

    public static Vol getUnVol(Long idvol){
        Session session = null;
        Vol vol = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            vol = session.get(Vol.class, idvol);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return vol;
    }

    public static Long getUnVol(String idvol){
        Session session = null;
        Vol vol = null;
        Long id = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            vol = session.get(Vol.class, idvol);
            id = vol.idVol;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return id;
    }

    public static Vol creationVol(Vol vol){
        Session session = null;
        Long id = vol.idVol;
        try{
            if( id.equals(null)){
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Vol nouveauvol = new Vol();
            nouveauvol.villeArriveeVol = vol.villeArriveeVol;
            nouveauvol.villeDepartVol = vol.villeDepartVol;
            nouveauvol.estActif = true;
            System.out.println("ville service :" + nouveauvol.villeArriveeVol);
            // Save Vol dans database
            session.persist(nouveauvol);

            // Commit the transaction
            session.getTransaction().commit();
            return nouveauvol;

        }catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static Vol updateVol(Vol vol) {
        Session session = null;
        Boolean estActif = false;
        Long id = vol.idVol;
        try {
            if(id.equals(null)){
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Vol nouveauvol = vol;
            //Formatage données
            if (vol.estActif){
                estActif = true;
            }
            else {
                estActif = false;
            }
            nouveauvol.estActif = estActif;

            // Update Vol dans database
            session.update(nouveauvol);

            // Commit the transaction
            session.getTransaction().commit();

            return vol;
        } catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static Vol suppressionVol(long id){
        Session session = null;
        Long idVol = id;
        try {
            if(idVol.equals(null)){
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Recherche les données du vol choisi
            Vol vol = session.find(Vol.class,idVol);
            // Suppression de l'Avion de la database
            vol.estActif=false;
            session.update(vol);
            // Commit the transaction
            session.getTransaction().commit();
            return vol;
        } catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public static Vol getVol(String idVol, Session session){
        Vol id = session.find(Vol.class,idVol);
        return id;
    }
}