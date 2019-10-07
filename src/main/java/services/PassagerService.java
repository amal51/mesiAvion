package services;

import config.Format;
import config.HibernateUtil;
import entity.Passagers;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class PassagerService {

    public static List<Passagers> getPassagers() {
        Session session = null;

        List<Passagers> passagersList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery (
                    "from Passagers as pas where pas.estActif = true");
            passagersList = (List<Passagers>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return passagersList;
    }

    public static Passagers creationPassager(Passagers passagers){
        Session session = null;
        try {
            if (passagers.numeroCNI.isEmpty()) {
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Passagers nouveaupassager = new Passagers();
            nouveaupassager.numeroCNI = passagers.numeroCNI;
            nouveaupassager.emailPassager = passagers.emailPassager;
            nouveaupassager.genrePassager = passagers.genrePassager;
            nouveaupassager.nomPassager = passagers.nomPassager;
            nouveaupassager.prenomPassager = passagers.prenomPassager;
            nouveaupassager.numeroTelephonePassager = passagers.numeroTelephonePassager;
            nouveaupassager.motDePassePassager = passagers.motDePassePassager;
            nouveaupassager.dateNaissancePassager = passagers.dateNaissancePassager;
            nouveaupassager.estActif = true;

            // Save DetailsVols dans la database
            session.persist(nouveaupassager);

            // Commit the transaction
            session.getTransaction().commit();

            return passagers;
        }catch (ParseException e){
            System.out.println(e.getMessage());
            return null;
        }catch (Exception e){
            System.out.println("e.getMessage()");
            return null;
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static Passagers updatePassager(Passagers passagers) {
        Session session = null;

        try {
            if (passagers.numeroCNI.isEmpty()) {
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Recherche les données du detail du vol choisi
            Passagers updatePassagers = passagers;

            // Update detailsVols to database
            session.update(updatePassagers);

            // Commit the transaction
            session.getTransaction().commit();

            return updatePassagers;
        } catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static Passagers suppressionPassager(String numeroCNI){
        Session session = null;
        String id = numeroCNI;
        try {
            if (id.isEmpty()) {
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Recherche les données de la reservation choisie
            Passagers passagers = session.find(Passagers.class, id);
            // Suppression du detail de la database
            passagers.estActif = false;
            session.update(passagers);
            // Commit the transaction
            session.getTransaction().commit();
            return passagers;
        } catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public static Passagers getIdPassager(String idPassager, Session session){
        Passagers id = session.find(Passagers.class,idPassager);
        return id;
    }

    public static Passagers getUnPassager(String id) {
        Session session = null;
        Passagers passagers = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            passagers = session.get(Passagers.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return passagers;
    }
}
