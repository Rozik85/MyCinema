package cinema.system.dao;

import cinema.system.Seans;
import cinema.system.Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SeansDAO {
    public Integer addSeans(Seans seans) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer seansID = null;
        try{
            tx = session.beginTransaction();
            seansID = (Integer) session.save(seans);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return seansID;
    }

//    public void deleteSeans (Seans seans) {
//        if (seans.getSeans_id() == 0) {
//            return;
//        }
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//        Integer seansID = null;
//        try{
//            tx = session.beginTransaction();
//            session.delete(seans);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }

    public Seans getSeans(Integer seansId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Seans seans = null;
        try{
            tx = session.beginTransaction();
            seans = session.get(Seans.class, seansId);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return seans;
    }

    public List<Seans> getSeansList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Seans> seans = null;
        try{
            tx = session.beginTransaction();
            seans = session.createQuery("FROM Seans").list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return seans;
    }
}
