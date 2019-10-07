package services;

import config.HibernateUtil;
import entity.Constructeur;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class ConstructeurAvionService {

    public static List<Constructeur> getConstructeur() {
        Session session = null;

        List<Constructeur> constructeurList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery (
                    "from Constructeur as constructeur where constructeur.estActif = true");
            constructeurList = (List<Constructeur>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return constructeurList;
    }

    public static Constructeur getConstructeurAvion(Long idConstructeur, Session session){
        Constructeur constructeurAvion = session.find(Constructeur.class,idConstructeur);
        return constructeurAvion;
    }

    public static Constructeur getUnConstructeur(Long idConstructeur){
        Session session = null;
        Constructeur constructeur = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            constructeur = session.get(Constructeur.class, idConstructeur);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return constructeur;
    }

    public static Constructeur creationConstructeur(Map<String, String[]> map){
        Session session = null;
        try{
            if(!map.containsKey("idConstructeur")){
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Constructeur constructeur = new Constructeur();
            constructeur.nomConstructeur = map.get("nomConstructeur")[0];
            constructeur.estActif = true;

            // Save Constructeur to database
            session.save(constructeur);

            // Commit the transaction
            session.getTransaction().commit();

            return constructeur;

        }catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static Constructeur updateConstructeur(Map<String, String[]> map) {
        Session session = null;
        Boolean estActif = false;

        try {
            if(!map.containsKey("idConstructeur")){
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Recherche les données du constructeur choisi
            Constructeur constructeur = session.find(Constructeur.class, map.get("idConstructeur")[0]);
            constructeur.nomConstructeur = map.get("nomConstructeur")[0];
            //Formatage données
            if (map.get("estActif")[0] == "true"){
                estActif = true;
            }

            constructeur.estActif = estActif;

            // Update Constructeur to database
            session.update(constructeur);

            // Commit the transaction
            session.getTransaction().commit();

            return constructeur;
        } catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }
//TODO :: Modifier la suppression pour faire un update de la valeur estActif pour Constructeur/Avion/Modele
    public static Constructeur suppressionConstructeur(Map<String, String[]> map){
        Session session = null;
        try {
            if(!map.containsKey("idConstructeur")){
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Recherche les données du constructeur choisi
            Constructeur constructeur = session.find(Constructeur.class, map.get("idConstructeur")[0]);
            // Suppression du constructeur de la database
            constructeur.estActif=false;
            session.update(constructeur);
            // Commit the transaction
            session.getTransaction().commit();
            return constructeur;
        } catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static Constructeur getConstructeurAvion(String idConstructeur, Session session){
        Constructeur constructeur = session.find(Constructeur.class,idConstructeur);
        return constructeur;
    }
}

