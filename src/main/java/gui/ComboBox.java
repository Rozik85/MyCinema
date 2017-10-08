package gui;

import cinema.system.Movie;

import javax.swing.*;
import java.util.List;


public class ComboBox extends DefaultComboBoxModel<Movie>{

    private List<Movie> movies;
    @Override
    public int getSize() {
        return movies.size();
    }

    @Override
    public Movie getElementAt(int index) {
        return movies.get(index);
    }

    public ComboBox(List<Movie> movies) {
        this.movies = movies;
    }
}
