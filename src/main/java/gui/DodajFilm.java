package gui;

import cinema.system.Movie;
import cinema.system.presenter.MoviePresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class DodajFilm {
    private JPanel panel1;
    private JTextField textTitle;
    private JTextField textYear;
    private JTextField textDuration;
    private JTextField textDirector;
    private JButton dodajFilmButton;
    private JLabel tytul;
    private JLabel year;
    private JLabel duration;
    private JLabel director;
    private MoviePresenter moviePresenter;


    public DodajFilm() {
        moviePresenter = new MoviePresenter (null);
        dodajFilmButton.addActionListener (new ActionListener () {

            @Override
            public void actionPerformed(ActionEvent e) {
                Movie film = new Movie ();
                film.setTitle (textTitle.getText ());
                film.setDuration (Integer.valueOf (textDuration.getText ()));
                film.setYear (LocalDate.parse (textYear.getText ()));
                film.setDirector (textDirector.getText ());
                moviePresenter.dodajFilmDoBazy (film);
            }
        });
    }


    public JPanel getPanel1() {
        return panel1;
    }
}