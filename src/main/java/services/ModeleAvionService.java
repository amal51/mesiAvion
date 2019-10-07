package services;

import config.HibernateUtil;
import entity.Constructeur;
import entity.ModeleAvion;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class ModeleAvionService {

    public static ModeleAvion getModeleAvion(String idModele, Session session){
        ModeleAvion modeleAvion = session.find(ModeleAvion.class,idModele);
        return modeleAvion;
    }

    public static ModeleAvion getModeleAvion(Long idModele, Session session){
        ModeleAvion modeleAvion = session.find(ModeleAvion.class,idModele);
        return modeleAvion;
    }
    public static List<ModeleAvion> getModeleAvion() {
        Session session = null;

        List<ModeleAvion> modeleAvionsList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery (
                    "from ModeleAvion as modelsavion where modelsavion.estActif = true");
            modeleAvionsList = (List<ModeleAvion>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return modeleAvionsList;
    }

    public static ModeleAvion getUnModele(Long idModele){
        Session session = null;
        ModeleAvion modeleAvion = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            modeleAvion = session.get(ModeleAvion.class, idModele);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return modeleAvion;
    }

    public static ModeleAvion creationModeleAvion(ModeleAvion modeleAvion){
        Session session = null;
        Long idModele = modeleAvion.idModele;
        Long idConstructeur = modeleAvion.constructeur.idConstructeur;
        try{
            if(idConstructeur.equals(null) || idModele.equals(null)){
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            ModeleAvion nouveaumodeleAvion = new ModeleAvion();
            // Vérifier et récupérer le modéle de l'avion car on envoi du string et non un objet modeleAvion
            Constructeur constructeur = ConstructeurAvionService.getConstructeurAvion(modeleAvion.constructeur.idConstructeur, session);
            if ( constructeur == null){
                throw new Exception();
            }
            nouveaumodeleAvion.constructeur = constructeur;
            nouveaumodeleAvion.estActif = true;
            nouveaumodeleAvion.nomAvion = modeleAvion.nomAvion;
            nouveaumodeleAvion.nombrePlaceAffaire = modeleAvion.nombrePlaceAffaire;
            nouveaumodeleAvion.nombrePlaceEco = modeleAvion.nombrePlaceEco;

            // Save modeleAvion dans la database
            session.save(nouveaumodeleAvion);

            // Commit the transaction
            session.getTransaction().commit();

            return modeleAvion;

        }catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static ModeleAvion updateModeleAvion(ModeleAvion modeleAvion) {
        Session session = null;
        Boolean estActif = false;
        Long id = modeleAvion.idModele;
        Long idConstructeur = modeleAvion.constructeur.idConstructeur;
        try {
            if(id.equals(null) || idConstructeur.equals(null)){
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Recherche les données de l'avion choisi
            ModeleAvion nouveaumodeleAvion = session.find(ModeleAvion.class, id);
            //Recherche constructeur
            nouveaumodeleAvion.constructeur = ConstructeurAvionService.getConstructeurAvion(idConstructeur, session);
            //Formatage données
            if (modeleAvion.estActif){
                estActif = true;
            }
            nouveaumodeleAvion.estActif = estActif;
            nouveaumodeleAvion.nombrePlaceEco = modeleAvion.nombrePlaceEco;
            nouveaumodeleAvion.nombrePlaceAffaire = modeleAvion.nombrePlaceAffaire;

            // Update ModeleAvion dans la database
            session.update(nouveaumodeleAvion);

            // Commit the transaction
            session.getTransaction().commit();

            return modeleAvion;
        } catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static ModeleAvion suppressionModeleAvion(Long idModele){
        Session session = null;
        Long id = idModele;
        try {
            if(id.equals(null)){
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Recherche les données de l'avion choisi
            ModeleAvion modeleAvion = session.find(ModeleAvion.class, id);
            // Suppression du modele dans la database
            modeleAvion.estActif=false;
            session.update(modeleAvion);
            // Commit the transaction
            session.getTransaction().commit();
            return modeleAvion;
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
}
