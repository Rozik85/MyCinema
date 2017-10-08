package cinema;

import cinema.system.Movie;
import cinema.system.Util.HibernateUtil;
import cinema.system.dao.MovieDAO;

import java.time.LocalDate;

public class  MovieApp {
    public static void main(String[] args) {
        MovieDAO movieDAO = new MovieDAO();
        Movie matrix = new Movie();
        matrix.setTitle("Matrix");
        matrix.setDuration(120);
        matrix.setYear(LocalDate.parse("1990-01-01"));
        matrix.setDirector("Wachowsky Brothers");

        Integer movieID = movieDAO.addMovie(matrix);

        Movie dbMovie = movieDAO.getMovie(movieID);
        System.out.println(dbMovie);
/**
 * poniżej opcja kasowania z bazy danych filmów
 */
   //     movieDAO.deleteMove(dbMovie);

        HibernateUtil.getSessionFactory().close();
    }
}
