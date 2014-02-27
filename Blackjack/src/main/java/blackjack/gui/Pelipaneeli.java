package blackjack.gui;

import blackjack.gui.kuuntelijat.JaamisKuuntelija;
import blackjack.gui.kuuntelijat.JakamisKuuntelija;
import blackjack.gui.kuuntelijat.LyomisKuuntelija;
import blackjack.gui.kuuntelijat.PanosKuuntelija;
import blackjack.gui.kuuntelijat.PelaaUudestaanKuuntelija;
import blackjack.gui.kuuntelijat.TuplaajaKuuntelija;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Vastaa pelipaneelin rakenteesta ja luomisesta.
 */
public class Pelipaneeli extends JPanel {

    private JPanel korttipaneeli = new JPanel(new GridLayout(4, 1));
    public JPanel pelaajanKortit = new JPanel();
    public JPanel vastustajanKortit = new JPanel();
    private JPanel valikko = new JPanel();
    private JPanel panosValikko = new JPanel();
    private JPanel jakajanPaneeli = new JPanel();
    private JPanel pelaajanPaneeli = new JPanel();
    public JButton lyomisNappula = new JButton();
    public JButton jaaKortitNappula = new JButton();
    public JButton jaamisNappula = new JButton();
    public JButton tuplausNappula = new JButton();
    public JButton pelaaUudestaanNappula = new JButton();
    public JLabel jakajaLabel = new JLabel();
    public JLabel pelaajaLabel = new JLabel();
    public JRadioButton panos100 = new JRadioButton("100");
    public JRadioButton panos200 = new JRadioButton("200");
    public JRadioButton panos300 = new JRadioButton("300");
    public JRadioButton panos400 = new JRadioButton("400");

    /**
     *  Luo pelipaneelin.
     * @param liittyma
     */
    public Pelipaneeli(Kayttoliittyma liittyma) {
        valikko.setBackground(new Color(0, 150, 0));
        jakajanPaneeli.setBackground(new Color(0, 150, 0));
        pelaajanPaneeli.setBackground(new Color(0, 150, 0));

        valikko.setLayout(new FlowLayout());

        paneelinTekstit();

        panosPaneeli();
        luoKuuntelijat(liittyma);

        valikko.add(panosValikko);
        valikko.add(jaaKortitNappula);
        valikko.add(lyomisNappula);
        valikko.add(jaamisNappula);
        valikko.add(tuplausNappula);
        valikko.add(pelaaUudestaanNappula);

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

        panosValikko.setLayout(new GridLayout(3, 2));
        ButtonGroup panosNappulat = new ButtonGroup();
        panosValikko.setBackground(new Color(0, 150, 0));

        panos100.setBackground(new Color(0, 100, 0));
        panos200.setBackground(new Color(0, 100, 0));
        panos300.setBackground(new Color(0, 100, 0));
        panos400.setBackground(new Color(0, 100, 0));

        panosNappulat.add(panos100);
        panosNappulat.add(panos200);
        panosNappulat.add(panos300);
        panosNappulat.add(panos400);

        panosValikko.add(panos100);
        panosValikko.add(panos200);
        panosValikko.add(panos300);
        panosValikko.add(panos400);

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
     * @param liittyma käyttöliittymä
     */
    public void luoKuuntelijat(Kayttoliittyma liittyma) {
        jaamisNappula.addActionListener(new JaamisKuuntelija(liittyma));
        jaaKortitNappula.addActionListener(new JakamisKuuntelija(liittyma, this));
        lyomisNappula.addActionListener(new LyomisKuuntelija(this, liittyma));
        pelaaUudestaanNappula.addActionListener(new PelaaUudestaanKuuntelija(liittyma));
        tuplausNappula.addActionListener(new TuplaajaKuuntelija(this, liittyma.peli));

        panos100.addActionListener(new PanosKuuntelija(100, liittyma.peli));
        panos200.addActionListener(new PanosKuuntelija(200, liittyma.peli));
        panos300.addActionListener(new PanosKuuntelija(300, liittyma.peli));
        panos400.addActionListener(new PanosKuuntelija(400, liittyma.peli));

    }

    /**
     * Luo paneelin tekstit.
     */
    public void paneelinTekstit() {
        jaaKortitNappula.setText("  Jaa kortit");
        lyomisNappula.setText("  Anna");
        jaamisNappula.setText("  Jää");
        pelaaUudestaanNappula.setText("  Pelaa uudestaan");
        tuplausNappula.setText("  Tuplaa");
        jakajaLabel.setText("  Jakaja  ");
        pelaajaLabel.setText("  Pelaaja  ");
    }

    /**
     *  Palauttaa nappulat perustilaan.
     */
    public void nappulatPerustilaan() {
        jaaKortitNappula.setEnabled(true);
        lyomisNappula.setEnabled(false);
        jaamisNappula.setEnabled(false);
        pelaaUudestaanNappula.setEnabled(false);
        tuplausNappula.setEnabled(false);

    }
}