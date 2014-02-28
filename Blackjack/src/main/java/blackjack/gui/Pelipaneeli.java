package blackjack.gui;

import blackjack.gui.kuuntelijat.JaamisKuuntelija;
import blackjack.gui.kuuntelijat.JakamisKuuntelija;
import blackjack.gui.kuuntelijat.OtaKorttiKuuntelija;
import blackjack.gui.kuuntelijat.PanosKuuntelija;
import blackjack.gui.kuuntelijat.PelaaUudestaanKuuntelija;
import blackjack.gui.kuuntelijat.TuplaajaKuuntelija;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Vastaa pelipaneelin rakenteesta ja luomisesta.
 */
public final class Pelipaneeli extends JPanel {

    private Kayttoliittyma ui;
    private JPanel korttipaneeli = new JPanel(new GridLayout(4, 1));
    private JPanel valikko = new JPanel();
    private JPanel panosValikko = new JPanel();
    private JPanel jakajanPaneeli = new JPanel();
    private JPanel pelaajanPaneeli = new JPanel();
    /**
     * paneeli joka sisältää pelaajan kortit.
     */
    public static final JPanel pelaajanKortit = new JPanel();
    /**
     * paneeli joka sisältää jakajan kortit
     */
    public static final JPanel vastustajanKortit = new JPanel();
    /**
     * sisältää pelissä käytetyt nappulat.
     */
    public static final Nappulat nappulat = new Nappulat();
    /**
     * labeli jakajalle, käytetään jakajan pisteiden esittämiseen tekstinä
     */
    public static final JLabel jakajaLabel = new JLabel();
    /**
     * labeli jakajalle, käytetään pelaajan pisteiden esittämiseen tekstinä
     */
    public static final JLabel pelaajaLabel = new JLabel();

    /**
     * Luo pelipaneelin.
     *
     * @param liittyma käyttöliittymä
     */
    public Pelipaneeli(Kayttoliittyma ui) {
        this.ui = ui;
        luoPelipaneeli();
    }

    public void luoPelipaneeli() {
        valikko.setBackground(new Color(0, 150, 0));
        jakajanPaneeli.setBackground(new Color(0, 150, 0));
        pelaajanPaneeli.setBackground(new Color(0, 150, 0));

        valikko.setLayout(new FlowLayout());

        paneelinTekstit();
        panosPaneeli();
        luoKuuntelijat();

        valikko.add(panosValikko);
        valikko.add(nappulat.jaaKortitNappula);
        valikko.add(nappulat.otaKorttiNappula);
        valikko.add(nappulat.jaamisNappula);
        valikko.add(nappulat.tuplausNappula);
        valikko.add(nappulat.pelaaUudestaanNappula);

        pelaajanPaneeli.add(pelaajaLabel);
        jakajanPaneeli.add(jakajaLabel);

        korttiPaneeli();
        nappulatPerustilaan();

        setLayout(new BorderLayout());

        add(korttipaneeli, BorderLayout.CENTER);
        add(valikko, BorderLayout.SOUTH);
    }

    /**
     * Luo panospaneelin.
     */
    public void panosPaneeli() {
        panosValikko.add(new JLabel("Valitse panos:"));
        panosValikko.add(new JLabel(""));

        panosValikko.setLayout(new GridLayout(4, 2));
        ButtonGroup panosNappulat = new ButtonGroup();
        panosValikko.setBackground(new Color(0, 150, 0));

        for (JRadioButton panos : nappulat.panokset) {
            panos.setBackground(new Color(0, 100, 0));
            panosNappulat.add(panos);
            panosValikko.add(panos);
        }

    }

    /**
     * Luo korttipaneelin.
     */
    public void korttiPaneeli() {
        pelaajanKortit.setBackground(new Color(0, 150, 0));
        vastustajanKortit.setBackground(new Color(0, 150, 0));

        korttipaneeli.setBackground(new Color(0, 150, 0));

        korttipaneeli.add(jakajanPaneeli);
        korttipaneeli.add(vastustajanKortit);

        korttipaneeli.add(pelaajanKortit);
        korttipaneeli.add(pelaajanPaneeli);
    }

    /**
     * Luo nappuloiden kuuntelijat.
     *
     * @param liittyma käyttöliittymä
     */
    public void luoKuuntelijat() {
        nappulat.jaamisNappula.addActionListener(new JaamisKuuntelija(ui));
        nappulat.jaaKortitNappula.addActionListener(new JakamisKuuntelija(ui, this));
        nappulat.otaKorttiNappula.addActionListener(new OtaKorttiKuuntelija(this, ui));
        nappulat.pelaaUudestaanNappula.addActionListener(new PelaaUudestaanKuuntelija(ui));
        nappulat.tuplausNappula.addActionListener(new TuplaajaKuuntelija(this, ui.peli));

        nappulat.panos1.addActionListener(new PanosKuuntelija(1, ui.peli));
        nappulat.panos5.addActionListener(new PanosKuuntelija(5, ui.peli));
        nappulat.panos10.addActionListener(new PanosKuuntelija(10, ui.peli));
        nappulat.panos25.addActionListener(new PanosKuuntelija(25, ui.peli));
        nappulat.panos100.addActionListener(new PanosKuuntelija(100, ui.peli));
        nappulat.panos200.addActionListener(new PanosKuuntelija(200, ui.peli));


    }

    /**
     * Luo paneelin tekstit.
     */
    public void paneelinTekstit() {
        nappulat.jaaKortitNappula.setText("  Jaa kortit");
        nappulat.otaKorttiNappula.setText("  Ota kortti");
        nappulat.jaamisNappula.setText("  Jää");
        nappulat.pelaaUudestaanNappula.setText("  Pelaa uudestaan");
        nappulat.tuplausNappula.setText("  Tuplaa");
        jakajaLabel.setText("  Jakaja  ");
        pelaajaLabel.setText("  Pelaajan  kassa: " + ui.aloitusKassa);
    }

    /**
     * Palauttaa Nappulat perustilaan.
     */
    public void nappulatPerustilaan() {
        nappulat.jaaKortitNappula.setEnabled(true);
        nappulat.otaKorttiNappula.setEnabled(false);
        nappulat.jaamisNappula.setEnabled(false);
        nappulat.pelaaUudestaanNappula.setEnabled(false);
        nappulat.tuplausNappula.setEnabled(false);

    }
}