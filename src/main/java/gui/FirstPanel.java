package gui;

import cinema.system.Movie;
import cinema.system.Util.MovieListModel;
import cinema.system.dao.MovieDAO;
import cinema.system.presenter.MoviePresenter;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.List;

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
    private JList list1;
    private JPanel listJPanel;
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
                wyświetlTekst("\nDodano film:");

            }
        });

        usunFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie film = new Movie();
                film.setMovie_id(Integer.valueOf(konsolaTextField.getText()));
                moviePresenter.usunFilm(film);
                wyświetlTekst("\n Usunięto film o ID:"+konsolaTextField.getText());
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
        tytulTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tytulTextField.setText("");
            }
        });
        rokProdukcjiTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rokProdukcjiTextField.setText("");
            }
        });
        długośćTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                długośćTextField.setText("");
            }
        });
        reżyserTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reżyserTextField.setText("");
            }
        });
        movieIdTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                movieIdTextField.setText("");
            }
        });
        date_timeTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                date_timeTextField.setText("");
            }
        });
        konsolaTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                konsolaTextField.setText("");
            }
        });
        init();
        moviePresenter.wyswietlWszystkieFilmy();
    }

    public void     wyświetlTekst(String text ){
        //dodaje tekst w kolejnych liniach
        textArea1.append("\n" +text);
        //wypisuje na czystej JtextArenie
        // textArea1.setText(text);
    }


    private void init() {
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setCellRenderer(new ListCellRenderer<Movie>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Movie> list, Movie value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel listItem = new JLabel(value.getTitle());
                listItem.setOpaque(true);
                if (isSelected)

                {
                    listItem.setBackground(list.getSelectionBackground());
                    listItem.setForeground(list.getSelectionForeground());
                }
                else
                {
                    listItem.setBackground(list.getBackground());
                    listItem.setForeground(list.getForeground());
                }
                listItem.setFont(list.getFont());
                listItem.setEnabled(list.isEnabled());
                listItem.setMinimumSize(new Dimension(100, 20));
                return listItem;
            }
        });

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                JList<Movie> movieList = (JList<Movie>) e.getSource();
                Movie selectedMovie = movieList.getSelectedValue();

               // selectedMovie.setMovie_id();
            }
        });
    }
    public void setMovieList(List<Movie> movies) {
        list1.setModel(new MovieListModel(movies));
    }
    public JPanel getCinema() {
        return cinema;
    }
}

