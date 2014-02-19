package blackjack.gui;


import blackjack.domain.Kasi;
import blackjack.domain.Kortti;
import blackjack.domain.pelaaja.BlackjackPelaaja;
import blackjack.gui.kuuntelijat.JaamisKuuntelija;
import blackjack.gui.kuuntelijat.JakamisKuuntelija;
import blackjack.gui.kuuntelijat.LyomisKuuntelija;
import blackjack.gui.kuuntelijat.PanosKuuntelija;
import blackjack.gui.kuuntelijat.PelaaUudestaanKuuntelija;
import blackjack.gui.kuuntelijat.TuplaajaKuuntelija;
import blackjack.gui.util.KorttienKuvienLataaja;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Paneeli extends JPanel {

    JPanel korttipaneeli = new JPanel(new GridLayout(2, 1));
    public JPanel pelaajanKortit = new JPanel();
    public JPanel vastustajanKortit = new JPanel();
    JPanel valikko = new JPanel();
    JPanel panosValikko = new JPanel();
    public JPanel jakajanPaneeli = new JPanel();
    public JPanel pelaajanPaneeli = new JPanel();
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

    public Paneeli(Kayttoliittyma liittyma) {


        valikko.setBackground(new Color(0, 150, 0));
        jakajanPaneeli.setBackground(new Color(0, 150, 0));
        pelaajanPaneeli.setBackground(new Color(0, 150, 0));

        valikko.setLayout(new FlowLayout());


        jaaKortitNappula.setText("  Jaa kortit");
        jaaKortitNappula.addActionListener(new JakamisKuuntelija(liittyma, this, liittyma.peli));


        lyomisNappula.setText("  Anna");
        lyomisNappula.addActionListener(new LyomisKuuntelija(this, liittyma.peli, liittyma));
        lyomisNappula.setEnabled(false);


        jaamisNappula.setText("  Jää");
        jaamisNappula.addActionListener(new JaamisKuuntelija(this, liittyma.peli, liittyma));
        jaamisNappula.setEnabled(false);

        pelaaUudestaanNappula.setText("  Pelaa uudestaan");
        pelaaUudestaanNappula.addActionListener(new PelaaUudestaanKuuntelija(liittyma));
        pelaaUudestaanNappula.setEnabled(false);

        tuplausNappula.setText("  Tuplaa");
        tuplausNappula.addActionListener(new TuplaajaKuuntelija(this, liittyma.peli));
        tuplausNappula.setEnabled(false);

        jakajaLabel.setText("  Jakaja:  ");
        pelaajaLabel.setText("  Pelaaja:  ");

        panosPaneeli();
        panos100.addActionListener(new PanosKuuntelija(100, liittyma.peli));
        panos200.addActionListener(new PanosKuuntelija(200, liittyma.peli));
        panos300.addActionListener(new PanosKuuntelija(300, liittyma.peli));
        panos400.addActionListener(new PanosKuuntelija(400, liittyma.peli));

        valikko.add(panosValikko);
        valikko.add(jaaKortitNappula);
        valikko.add(lyomisNappula);
        valikko.add(jaamisNappula);
        valikko.add(tuplausNappula);
        valikko.add(pelaaUudestaanNappula);


        pelaajanPaneeli.add(pelaajaLabel);
        jakajanPaneeli.add(jakajaLabel);

        korttiPaneeli();

        setLayout(new BorderLayout());
        add(valikko, BorderLayout.SOUTH);
        add(jakajanPaneeli, BorderLayout.EAST);
        add(pelaajanPaneeli, BorderLayout.NORTH);
        add(korttipaneeli, BorderLayout.CENTER);
    }

    public void panosPaneeli() {



        panosValikko.setLayout(new GridLayout(3, 2));

        ButtonGroup buttonGroup = new ButtonGroup();
        panosValikko.setBackground(new Color(0, 150, 0));


        panos100.setBackground(new Color(0, 100, 0));
        panos200.setBackground(new Color(0, 100, 0));
        panos300.setBackground(new Color(0, 100, 0));
        panos400.setBackground(new Color(0, 100, 0));

        panosValikko.add(new JLabel("                 Valitse panos:"));
        panosValikko.add(new JLabel(""));

        buttonGroup.add(panos100);
        buttonGroup.add(panos200);
        buttonGroup.add(panos300);
        buttonGroup.add(panos400);
        panosValikko.add(panos100);
        panosValikko.add(panos200);
        panosValikko.add(panos300);
        panosValikko.add(panos400);

    }

    public void korttiPaneeli() {   
        
        pelaajanKortit.setBackground(new Color(0, 150, 0));
        vastustajanKortit.setBackground(new Color(0, 150, 0));

        korttipaneeli.setBackground(new Color(0, 150, 0));

        korttipaneeli.add(vastustajanKortit);

        korttipaneeli.add(pelaajanKortit);

    }
    
}