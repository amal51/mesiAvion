package services;

import config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ReportingService {
    public static List<String> reservationPeriode(Date debut, Date fin){
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT COUNT(idReservation) as NombreDeReservationSurPeriode FROM Reservation as R, DetailsVols as D WHERE R.idDetailsVols= D.idDetailsVols AND D.dateDepart BETWEEN :debut AND :fin");
        query.setParameter("debut", debut);
        query.setParameter("fin", fin);
        List results = query.list();
        return results;
    }

    public static List<String> nombrePassager(){
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT COUNT(numeroCNI) as NombreDePassagers FROM Passagers");
        List results = query.list();
        return results;
    }

    public static List<String> nombrePassagerPeriode(Date debut, Date fin){
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT COUNT(idPassager) as NombrePassagerReserve FROM Reservation as R, DetailsVols as D WHERE R.idDetailsVols= D.idDetailsVols AND D.dateDepart BETWEEN :debut AND :fin");
        query.setParameter("debut", debut);
        query.setParameter("fin", fin);
        List results = query.list();
        return results;
    }

    public static List<String> nombreAnnulation(Date debut, Date fin){
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT COUNT(idReservation) as NombreAnnulation FROM Reservation as R, DetailsVols as D WHERE R.idDetailsVols= D.idDetailsVols AND D.dateDepart BETWEEN :debut AND :fin AND R.estActif = false");
        query.setParameter("debut", debut);
        query.setParameter("fin", fin);
        List results = query.list();
        return results;
    }

    public static List<String> nombreAvionMaintenance(){
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT COUNT(ARN) as NombreAvionMaintenance FROM Avion WHERE estActif = false");
        List results = query.list();
        return results;
    }

    public static List<String> AvionPlusVol(Date debut, Date fin){
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT ARN FROM Avion WHERE ARN = (SELECT MAX(nombre) FROM (SELECT COUNT(ARN) AS nombre FROM DetailsVols WHERE dateDepart BETWEEN :debut AND :fin) AS nombre_count) ");
        query.setParameter("debut", debut);
        query.setParameter("fin", fin);
        List results = query.list();
        return results;
    }

    public static List<String> PassagerPlusReservation(Date debut, Date fin){
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT COUNT (DISTINCT idPassager) as PassagerPlusDeReservation FROM Reservation WHERE idDetailsVols.dateDepart BETWEEN :debut AND :fin ");
        query.setParameter("debut", debut);
        query.setParameter("fin", fin);
        List results = query.list();
        return results;
    }

    public static List<String> PourcentageNombreAffaireEcoPeriode(Date debut, Date fin){
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT COUNT (DISTINCT idPassager) as PassagerPlusDeReservation FROM Reservation WHERE idDetailsVols.dateDepart BETWEEN :debut AND :fin ");
        query.setParameter("debut", debut);
        query.setParameter("fin", fin);
        List results = query.list();
        return results;
    }
}
