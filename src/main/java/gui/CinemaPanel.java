package gui;

import com.sun.xml.internal.ws.handler.HandlerException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CinemaPanel extends JFrame {
    public CinemaPanel() throws HandlerException {
        init ();
    }

    private void init() {
        createMenuBar ();
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setContentPane (new FirstPanel ().getCinema ());
        pack ();
        setVisible (true);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar ();
        ImageIcon icon = new ImageIcon ("exit.jpg");
        /**
         * zakłądka plik
         */
        JMenu fileMenu = new JMenu ("Plik");
        fileMenu.setMnemonic (KeyEvent.VK_P);
        JMenuItem fileMenuItem = new JMenuItem ("Exit", icon);
        fileMenuItem.setMnemonic (KeyEvent.VK_E);
        fileMenuItem.setToolTipText ("Exit application");
        fileMenuItem.addActionListener ((ActionEvent event) -> {
            System.exit (0);
        });
        fileMenu.add (fileMenuItem);

/**
 * zakłądka Film
 */
        JMenu filmMenu = new JMenu ("Film");
        filmMenu.setMnemonic (KeyEvent.VK_F);

        JMenuItem filmMenuItemWyswietl = new JMenuItem ("Wyświetl");
        filmMenuItemWyswietl.setMnemonic (KeyEvent.VK_W);
        filmMenuItemWyswietl.setToolTipText ("Wyświetl aplication");

        JMenuItem filmMenuItemDodaj = new JMenuItem ("Dodaj");
        filmMenuItemDodaj.setMnemonic (KeyEvent.VK_D);
        filmMenuItemDodaj.setToolTipText ("Dodaj aplication");
        filmMenuItemDodaj.addActionListener ((ActionEvent event) -> {
            JFrame dodawanieFilmu = new JFrame ("DodajFilm");
            dodawanieFilmu.setContentPane (new DodajFilm ().getPanel1 ());
            dodawanieFilmu.pack ();
            dodawanieFilmu.setVisible (true);
        });


        JMenuItem filmMenuItemUsun = new JMenuItem ("Usuń");
        filmMenuItemUsun.setMnemonic (KeyEvent.VK_U);
        filmMenuItemUsun.setToolTipText ("Usuń aplication");
        filmMenuItemUsun.addActionListener ((ActionEvent)->{
          JFrame usuwanieFilmu = new JFrame ("UsunFilm");
          usuwanieFilmu.setContentPane (new UsunFilm().getPanel1());
          usuwanieFilmu.pack ();
          usuwanieFilmu.setVisible (true);
        });



        filmMenu.add (filmMenuItemWyswietl);
        filmMenu.add (filmMenuItemDodaj);
        filmMenu.add (filmMenuItemUsun);

/**
 * menubar zadkładka Seans
 */
        JMenu seansMenu = new JMenu ("Seans");
        seansMenu.setMnemonic (KeyEvent.VK_S);

        /**
         * menubar zadkładka Help
         */
        JMenu helpMenu = new JMenu ("Help");
        helpMenu.setMnemonic (KeyEvent.VK_H);


        /**
         * menubar zadkładka Tools
         */
        JMenu toolsMenu = new JMenu ("Tools");
        toolsMenu.setMnemonic (KeyEvent.VK_T);

        menuBar.add (fileMenu);
        menuBar.add (filmMenu);
        menuBar.add (seansMenu);
        menuBar.add (Box.createHorizontalGlue ());
        menuBar.add (toolsMenu);
        menuBar.add (helpMenu);

        setJMenuBar (menuBar);
    }


    public static void main(String[] args) {
        CinemaPanel cinemaPanel = new CinemaPanel ();

    }
}
