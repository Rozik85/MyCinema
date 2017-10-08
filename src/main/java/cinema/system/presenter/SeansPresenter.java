package cinema.system.presenter;

import cinema.system.Seans;
import cinema.system.dao.MovieDAO;
import cinema.system.dao.SeansDAO;
import gui.FirstPanel;

public class SeansPresenter {
    private Seans seansDetals;
    private final FirstPanel dodajSeansWidok;

    private SeansDAO seansDAO = new SeansDAO ();


    public SeansPresenter(FirstPanel seansDetals) {
        this.dodajSeansWidok = seansDetals;
    }

    public void wyswietlWszystkieSeanse() {
        dodajSeansWidok.setSeansList (seansDAO.getSeansList ());
    }
}
