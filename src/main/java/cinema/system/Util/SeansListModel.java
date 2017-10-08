package cinema.system.Util;

import cinema.system.Seans;

import javax.swing.*;
import java.util.List;

public class SeansListModel extends AbstractListModel<Seans>{

    private List<Seans> seanses;

    public SeansListModel(List<Seans> seanses) {
        this.seanses = seanses;
    }

    @Override
    public int getSize() {
        return seanses.size();
    }

    @Override
    public Seans getElementAt(int index) {
        return seanses.get(index);
    }
}
