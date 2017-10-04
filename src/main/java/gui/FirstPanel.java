package gui;

import cinema.system.Movie;
import cinema.system.presenter.MoviePresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class FirstPanel {
    private JPanel cinema;
    private JButton dodajFilmButton;
    private JTextField tytulTextField;
    private JTextField rokProdukcjiTextField;
    private JTextField długośćTextField;
    private JTextField reżyserTextField;
    private JButton usunFilmButton;
    private JButton usunSeansButton;
    private JButton dodajSeansButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    private MoviePresenter moviePresenter;


    public FirstPanel() {
        moviePresenter = new MoviePresenter (this);

        dodajFilmButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                Movie film = new Movie();
                film.setTitle(tytulTextField.getText());
                film.setDuration(Integer.valueOf(długośćTextField.getText()));
                film.setYear(LocalDate.parse(rokProdukcjiTextField.getText()));
                film.setDirector(reżyserTextField.getText());
                moviePresenter.dodajFilmDoBazy(film);

            }
        });
        usunFilmButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie film = new Movie();
                film.setMovie_id (Integer.valueOf (tytulTextField.getText ()));
                moviePresenter.usunFilm (film);
            }
        });
    }
    public JPanel getCinema() {
        return cinema;
    }

}
