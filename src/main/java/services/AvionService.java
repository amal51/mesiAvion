package services;

import config.HibernateUtil;
import entity.Avion;
import entity.ModeleAvion;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class AvionService {

    public static List<Avion> getAvion() {
        Session session = null;

        List<Avion> avionList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery (
                    "from Avion as avion where avion.estActif = true");
            avionList = (List<Avion>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return avionList;
    }

    public static Avion getUnAvion(String idAvion){
        Session session = null;
        Avion avion = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            avion = session.get(Avion.class, idAvion);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return avion;
    }

    public static Avion creationAvion(Avion avion){
        Session session = null;
        try{
            if(avion.ARN.isEmpty()){
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Avion nouveauavion = new Avion();
            nouveauavion.ARN = avion.ARN;
            nouveauavion.estActif = true;
            nouveauavion.estEnMaintenance = false;
            // Vérifier et récupérer le modèle de l'avion car on envoi du string et non un objet modeleAvion
            ModeleAvion modeleAvion = ModeleAvionService.getModeleAvion(avion.modeleAvion.idModele, session);
            if ( modeleAvion == null){
                System.out.println("modele null?");
                throw new Exception();
            }
            System.out.println(modeleAvion.idModele);
            nouveauavion.modeleAvion = modeleAvion;
            //TODO : Regarder pourquoi il n'insert pas le bon nombre de place, il recupère le nombre de place depuis le modele existant
            nouveauavion.modeleAvion.constructeur = avion.modeleAvion.constructeur;
            nouveauavion.modeleAvion.nombrePlaceAffaire = avion.modeleAvion.nombrePlaceAffaire;
            nouveauavion.modeleAvion.nombrePlaceEco = avion.modeleAvion.nombrePlaceEco;

            // Save Avion to database
            session.persist(nouveauavion);

            // Commit the transaction
            session.getTransaction().commit();

            return avion;

        }catch (Exception e){
            if (session != null && session.isOpen() && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                System.out.println("?");
            }
            return null;
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static Avion updateAvion(Avion avion) {
        Session session = null;

        try {
            if(avion.ARN.isEmpty()){
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Recherche les données de l'avion choisi
            Avion nouveauavion = avion;

            // Update Avion to database
            session.update(nouveauavion);

            // Commit the transaction
            session.getTransaction().commit();

            return avion;
        } catch (Exception e){
            if (session != null && session.isOpen() && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static Avion suppressionAvion(String idAvion){
        Session session = null;
        try {
            if(idAvion.isEmpty()){
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Recherche les données de l'avion choisi
            Avion avion = session.find(Avion.class,idAvion);
            // Suppression de l'Avion de la database
            avion.estActif=false;
            session.update(avion);
            // Commit the transaction
            session.getTransaction().commit();
            return avion;
        } catch (Exception e){
            if (session != null && session.isOpen() && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static Avion getAvion(String ARN, Session session){
        Avion id = session.find(Avion.class,ARN);
        return id;
    }

}
