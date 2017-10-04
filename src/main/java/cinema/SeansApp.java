package cinema;

import cinema.system.Seans;
import cinema.system.dao.SeansDAO;
import cinema.system.Util.HibernateUtil;

import java.time.LocalDateTime;


public class SeansApp {
    public static void main(String[] args) {
        SeansDAO seansDAO = new SeansDAO();
        Seans poniedziałek = new Seans();
        poniedziałek.setMovie_id(0);

        poniedziałek.setDateTime(LocalDateTime.parse("2017-09-30T12:00:00"));

        Integer seansID = seansDAO.addSeans(poniedziałek);

        Seans dbSeans = seansDAO.getSeans(seansID);
        System.out.println(dbSeans);

        HibernateUtil.getSessionFactory().close();
    }
}
