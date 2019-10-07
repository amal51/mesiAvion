package services;

import config.HibernateUtil;
import entity.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class ReservationService {
    public static List<Reservation> getReservation() {
        Session session = null;

        List<Reservation> reservationlist = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery (
                    "from Reservation as res where res.estActif = true");
            reservationlist = (List<Reservation>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return reservationlist;
    }

    public static Reservation creationReservation(Reservation reservation){
        Session session = null;
        Long id = reservation.idReservation;
        try {
            if (reservation.idDetailsVols.equals(null) || id.equals(null) || reservation.idPassager.equals(null)) {
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Reservation nouvellereservation = new Reservation();
            // Vérifier et récupérer l'id de l'avion et du vol car on envoi du string et non un objet modeleAvion
            DetailsVols idDetail = DetailVolService.getDetailVol(reservation.idDetailsVols.idDetailsVols, session);
            Passagers idPassager = PassagerService.getIdPassager(reservation.idPassager.numeroCNI, session);
            if (idDetail == null || idPassager == null) {
                throw new Exception();
            }
            nouvellereservation.idDetailsVols = idDetail;
            nouvellereservation.classe = reservation.classe;
            nouvellereservation.idPassager = idPassager;
            nouvellereservation.estActif = true;

            // Save DetailsVols dans la database
            session.persist(nouvellereservation);

            // Commit the transaction
            session.getTransaction().commit();

            return reservation;
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

    public static Reservation updateReservation(Reservation reservation) {
        Session session = null;
        Long id = reservation.idReservation;
        try {
            if (reservation.idDetailsVols.equals(null) || id.equals(null) || reservation.idPassager.equals(null)) {
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Recherche les données du detail du vol choisi
            Reservation nouvellereservation = reservation;
            // Update detailsVols to database
            session.update(nouvellereservation);

            // Commit the transaction
            session.getTransaction().commit();

            return reservation;
        } catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public static Reservation suppressionReservation(Long id){
        Session session = null;
        try {
            if (id.equals(null)) {
                throw new Exception();
            }
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Recherche les données de la reservation choisie
            Reservation suppressionReservation = session.find(Reservation.class, id);
            // Suppression du detail de la database
            suppressionReservation.estActif = false;
            session.update(suppressionReservation);
            // Commit the transaction
            session.getTransaction().commit();
            return suppressionReservation;
        } catch (Exception e){
            return null;
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public static Reservation getReservation(String idReservation, Session session){
        Reservation id = session.find(Reservation.class,idReservation);
        return id;
    }
    public static Reservation getUneReservation(Long id) {
        Session session = null;
        Reservation reservation = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            reservation = session.get(Reservation.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return reservation;
    }
}

