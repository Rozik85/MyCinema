package gui;

import cinema.system.Movie;
import cinema.system.Seans;
import cinema.system.Util.MovieListModel;
import cinema.system.Util.SeansListModel;
import cinema.system.dao.MovieDAO;
import cinema.system.dao.SeansDAO;
import cinema.system.presenter.MoviePresenter;
import cinema.system.presenter.SeansPresenter;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private JTextField numerSaliTextField;
    private JTextField date_timeTextField;
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
    private JScrollBar scrollBar1;
    private JComboBox comboBox1;
    private JList list2;
    private JLabel wyswietlaczJLabel;

    private MoviePresenter moviePresenter;
    private SeansPresenter seansPresenter;
    private SeansDAO seansDAO;
    private MovieDAO movieDAO;

    public FirstPanel() {
        moviePresenter = new MoviePresenter (this);
        seansPresenter = new SeansPresenter (this);

        dodajFilmButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                Movie film = new Movie ();
                film.setTitle (tytulTextField.getText ());
                film.setDuration (Integer.valueOf (długośćTextField.getText ()));
                film.setYear (LocalDate.parse (rokProdukcjiTextField.getText ()));
                film.setDirector (reżyserTextField.getText ());
                moviePresenter.dodajFilmDoBazy (film);
                wyświetlTekst ("\nDodano film:");

            }
        });

        usunFilmButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie film = new Movie ();
                film.setMovie_id (Integer.valueOf (konsolaTextField.getText ()));
                moviePresenter.usunFilm (film);
                wyświetlTekst ("\n Usunięto film o ID:" + konsolaTextField.getText ());
            }
        });

        wyświetlFilmyButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {

                wyświetlTekst (String.valueOf (moviePresenter.pokażFilmyZBazy (Integer.valueOf (konsolaTextField.getText ()))));

            }
        });
        czyśćWyświetlaczButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText ("");
            }
        });
        tytulTextField.addMouseListener (new MouseAdapter () {
            @Override
            public void mouseClicked(MouseEvent e) {
                tytulTextField.setText ("");
            }
        });
        rokProdukcjiTextField.addMouseListener (new MouseAdapter () {
            @Override
            public void mouseClicked(MouseEvent e) {
                rokProdukcjiTextField.setText ("");
            }
        });
        długośćTextField.addMouseListener (new MouseAdapter () {
            @Override
            public void mouseClicked(MouseEvent e) {
                długośćTextField.setText ("");
            }
        });
        reżyserTextField.addMouseListener (new MouseAdapter () {
            @Override
            public void mouseClicked(MouseEvent e) {
                reżyserTextField.setText ("");
            }
        });

        date_timeTextField.addMouseListener (new MouseAdapter () {
            @Override
            public void mouseClicked(MouseEvent e) {
                date_timeTextField.setText ("");
            }
        });
        konsolaTextField.addMouseListener (new MouseAdapter () {
            @Override
            public void mouseClicked(MouseEvent e) {
                konsolaTextField.setText ("");
            }
        });
        numerSaliTextField.addMouseListener (new MouseAdapter () {
            @Override
            public void mouseClicked(MouseEvent e) {
                numerSaliTextField.setText ("");
            }
        });


        dodajSeansButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                seansDAO = new SeansDAO ();
                movieDAO = new MovieDAO ();
                Seans seans = new Seans ();
                Movie movie = (Movie) comboBox1.getSelectedItem ();
                Movie dbmovie = movieDAO.getMovie (movie.getMovie_id ());
                System.out.println ("comboselected movie" + movie);
                seans.setMovie (dbmovie);
                DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern ("yyyy-MM-dd HH:mm");
                seans.setDate_time (LocalDateTime.parse (date_timeTextField.getText (), dateTimeFormat));
                seans.setNrSala (Integer.valueOf (numerSaliTextField.getText ()));

                seansDAO.addSeans (seans);
                wyświetlTekst ("\nDodano seans:" + seans.getSeans_id ());
            }
        });

        initBox ();
        inity ();
        moviePresenter.wyswietlWszystkieFilmy ();
        seansPresenter.wyswietlWszystkieSeanse ();
    }

    public void wyświetlTekst(String text) {
        //dodaje tekst w kolejnych liniach
        textArea1.append ("\n" + text);
        //wypisuje na czystej JtextArenie
        // textArea1.setText(text);
    }

    private void initBox() {
        MovieDAO movieDAO = new MovieDAO ();
        comboBox1.setModel (new ComboBox (movieDAO.getMovieList ()));
        comboBox1.setSelectedItem (ListSelectionModel.SINGLE_SELECTION);
    }

    private void inity() {
        list1.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
        list1.setCellRenderer (new ListCellRenderer<Movie> () {
            @Override
            public Component getListCellRendererComponent(JList<? extends Movie> list, Movie value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel listItem = new JLabel (value.getTitle ());
                listItem.setOpaque (true);
                if (isSelected)

                {
                    listItem.setBackground (list.getSelectionBackground ());
                    listItem.setForeground (list.getSelectionForeground ());
                } else {
                    listItem.setBackground (list.getBackground ());
                    listItem.setForeground (list.getForeground ());
                }
                listItem.setFont (list.getFont ());
                listItem.setEnabled (list.isEnabled ());
                listItem.setMinimumSize (new Dimension (100, 20));
                return listItem;
            }
        });

        list2.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
        list2.setCellRenderer (new ListCellRenderer<Seans> () {
            @Override
            public Component getListCellRendererComponent(JList<? extends Seans> list, Seans value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel listItem = new JLabel (value.toString ());
                listItem.setOpaque (true);
                if (isSelected)

                {
                    listItem.setBackground (list.getSelectionBackground ());
                    listItem.setForeground (list.getSelectionForeground ());
                } else {
                    listItem.setBackground (list.getBackground ());
                    listItem.setForeground (list.getForeground ());
                }
                listItem.setFont (list.getFont ());
                listItem.setEnabled (list.isEnabled ());
                listItem.setMinimumSize (new Dimension (100, 20));
                return listItem;
            }
        });

        list1.addListSelectionListener (new ListSelectionListener () {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                JList<Movie> movieList = (JList<Movie>) e.getSource ();
                Movie selectedMovie = movieList.getSelectedValue ();


                textArea1.setText ("ID: " + selectedMovie.getMovie_id ());
                textArea1.append ("\nTytuł: " + selectedMovie.getTitle ());
                textArea1.append ("\nRok: " + selectedMovie.getYear ().toString ());
                textArea1.append ("\nDługość: " + selectedMovie.getDuration ());
                textArea1.append ("\nReżyser: " + selectedMovie.getDirector ());

            }
        });
        list2.addListSelectionListener (new ListSelectionListener () {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                JList<Seans> seansList = (JList<Seans>) e.getSource ();
                Seans selectedSeans = seansList.getSelectedValue ();
                textArea1.setText("\nSeans: "+selectedSeans.getSeans_id ());
                textArea1.append ("\nMovie: "+selectedSeans.getMovie ());
                textArea1.append ("\nData: " + selectedSeans.getDate_time ());
                textArea1.append ("\nSala: "+selectedSeans.getNrSala ());

            }
        });
    }

    public void setMovieList(List<Movie> movies) {
        list1.setModel (new MovieListModel (movies));
    }
    public void setSeansList(List<Seans> seans) {
        list2.setModel (new SeansListModel (seans));
    }


    public JPanel getCinema() {
        return cinema;
    }
}

