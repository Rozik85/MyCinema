package cinema.system.presenter;

import cinema.system.Movie;
import cinema.system.dao.MovieDAO;
import gui.FirstPanel;

public class MoviePresenter {
    private Movie movieDetails;
    private final FirstPanel dodajFilmWidok;

    private MovieDAO movieDAO = new MovieDAO();

    public MoviePresenter(FirstPanel movieDetails) {
        this.dodajFilmWidok = movieDetails;
    }

    public void dodajFilmDoBazy(Movie movie) {
        movieDAO.addMovie(movie);

    }

    public Movie pokażFilmyZBazy(Integer movieId) {

        movieDetails = new Movie();
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

    public void wyswietlWszystkieFilmy() {
        dodajFilmWidok.setMovieList(movieDAO.getMovieList());
    }
}
