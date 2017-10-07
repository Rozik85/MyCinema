package gui;

import cinema.system.Movie;
import cinema.system.presenter.MoviePresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsunFilm {
    private JButton usuńFilmButton;
    private JTextField idFilmu;
    private JLabel idFilmuLabel;
    private JPanel panel1;
    private MoviePresenter moviePresenter;


    public UsunFilm() {
        moviePresenter = new MoviePresenter (null);

        usuńFilmButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie film = new Movie ();
                film.setMovie_id (Integer.valueOf (idFilmu.getText ()));
                moviePresenter.usunFilm (film);
            }
        });
    }
    public JPanel getPanel1() {
        return panel1;
    }

}
