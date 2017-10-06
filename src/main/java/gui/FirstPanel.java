package gui;

import cinema.system.Movie;
import cinema.system.dao.MovieDAO;
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
    private JTextField date_timeTextField;
    private JTextField movieIdTextField;
    private JPanel wyswietlaczJPanel;
    private JPanel dodawanieFilmuJPanel;
    private JPanel dodawanieSeansuJPanel;
    private JPanel przyciskiPanel;
    private JButton wyświetlFilmyButton;
    private JButton wyświetlSeanseButton;
    private JTextArea textArea1;
    private JTextField konsolaTextField;
    private JButton czyśćWyświetlaczButton;
    private JLabel wyswietlaczJLabel;

    private MoviePresenter moviePresenter;


    public FirstPanel() {
        moviePresenter = new MoviePresenter(this);

        dodajFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Movie film = new Movie();
                film.setTitle(tytulTextField.getText());
                film.setDuration(Integer.valueOf(długośćTextField.getText()));
                film.setYear(LocalDate.parse(rokProdukcjiTextField.getText()));
                film.setDirector(reżyserTextField.getText());
                moviePresenter.dodajFilmDoBazy(film);
                wyświetlTekst("Dodano film:");

            }
        });

        usunFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie film = new Movie();
                film.setMovie_id(Integer.valueOf(konsolaTextField.getText()));
                moviePresenter.usunFilm(film);
                wyświetlTekst("Usunięto film o ID:"+konsolaTextField.getText());
            }
        });

        wyświetlFilmyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                wyświetlTekst(String.valueOf(moviePresenter.pokażFilmyZBazy(Integer.valueOf(konsolaTextField.getText()))));
            }
        });
        czyśćWyświetlaczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
            }
        });
    }

    public void wyświetlTekst(String text ){
        //dodaje tekst w kolejnych liniach
        textArea1.append(text);
        //wypisuje na czystej JtextArenie
        // textArea1.setText(text);
    }

    public JPanel getCinema() {
        return cinema;
    }
}

