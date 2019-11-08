package services;

import config.HibernateUtil;
import entity.Messages;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class LangueService {
    public static List<Messages> getMessage() {
        Session session = null;

        List<Messages> messagesList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery (
                    "from Messages");
            messagesList = (List<Messages>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return messagesList;
    }
}
