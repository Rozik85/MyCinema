package gui;

import cinema.system.Movie;
import cinema.system.presenter.MoviePresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WyswietlanieFilmu {
    private JTextField podajIdFilmuTextField;
    private JPanel panel1;
    private JButton wyswietlDaneFilmuButton;
    private JTextArea wyswietlaczTextArea;
    private JTextArea wyświetlaczTextArea;
    private MoviePresenter moviePresenter;


    public WyswietlanieFilmu() {
        moviePresenter = new MoviePresenter(null);

        wyswietlDaneFilmuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                wyswietlaczTextArea(String.valueOf(moviePresenter.pokażFilmyZBazy(Integer.valueOf(podajIdFilmuTextField.getText()))));
            }
        });
    }

    private void wyswietlaczTextArea(String hallo) {
        wyswietlaczTextArea.append(hallo);
    }

    public JPanel getPanel1() {
        return panel1;
    }


}
