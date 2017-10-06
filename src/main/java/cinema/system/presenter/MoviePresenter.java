package cinema.system.presenter;

import cinema.system.Movie;
import cinema.system.dao.MovieDAO;
import gui.DodajFilm;
import gui.FirstPanel;

public class MoviePresenter {
    private final FirstPanel dodajFilmWidok;

    private MovieDAO movieDAO = new MovieDAO();

    public MoviePresenter(FirstPanel movieDetails) {
        this.dodajFilmWidok = movieDetails;
    }
//    private DodajFilm dodajFilmWidok;
    //  private FirsPanel wyświetlanieFilmów;

//    public MoviePresenter(DodajFilm movieDetails) {
//        this.dodajFilmWidok = movieDetails;
//    }
//
//    public MoviePresenter(FirsPanel movieDetails) {
//        this.wyświetlanieFilmów = movieDetails;
//    }

    //        public void showMovie(Integer movieID) {
//        Movie movieDetails = new Movie();
//        Movie movie = movieDAO.getMovie(movieID);
//        movieDetails.setMovieTitle(movie.getTitle());
//        movieDetails.setMovieDirector(movie.getDirector());
//        movieDetails.setMovieDuration("" + movie.getDuration());
//
//    }
    public void dodajFilmDoBazy(Movie movie) {
        movieDAO.addMovie(movie);

    }

    public Movie pokażFilmyZBazy(Integer movieId) {

        Movie movieDetails = new Movie();
        Movie movie = movieDAO.getMovie(movieId);
        movieDetails.setTitle(movie.getTitle());
        movieDetails.setYear(movie.getYear());
        movieDetails.setDuration(movie.getDuration());
        movieDetails.setDirector(movie.getDirector());

        return movie;
    }

    public void usunFilm(Movie movieId) {
        movieDAO.deleteMove(movieId);
    }
}
