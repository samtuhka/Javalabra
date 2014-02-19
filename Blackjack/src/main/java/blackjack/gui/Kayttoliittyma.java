package blackjack.gui;

import blackjack.domain.BlackjackPeli;
import blackjack.domain.Kasi;
import blackjack.domain.Kortti;
import blackjack.domain.pelaaja.BlackjackPelaaja;
import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;
import blackjack.gui.util.KorttienKuvienLataaja;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Ei tee yhtään mitään viellä.
 *
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    public BlackjackPeli peli;
    public Paneeli paneeli;

    /**
     *
     */
    public Kayttoliittyma() {
        this.peli = new BlackjackPeli(new Pelaaja("Pelaaja", 1000));
        this.paneeli = new Paneeli(this);
    }

    @Override
    public void run() {
        frame = new JFrame("Blackjack");
        frame.setPreferredSize(new Dimension(800, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(paneeli);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void paivitaPelia() {
        Pelaaja pelaaja = peli.getKierros().getPelaaja();
        Jakaja jakaja = peli.getKierros().getJakaja();
        paivitaPanosNappulat();
        if (pelaaja.getKassa() < peli.getSeuraavaPanos()) {
            paneeli.panos100.doClick();
        }
        if (pelaaja.vararikko()) {
            paivitaVararikossa();
        } else {
            paivitaPanosNappulat();
        }
        paneeli.pelaajaLabel.setText("Pisteet:  " + pelaaja.getPisteet() + "   Kassa: " + pelaaja.getKassa());
        paneeli.jakajaLabel.setText("Jakajan pistemäärä:  " + jakaja.getPisteet());
    }

    public void paivitaPanosNappulat() {
        Pelaaja pelaaja = peli.getKierros().getPelaaja();
        mustaaPanosNappulat();

        if (pelaaja.getKassa() >= 100) {
            paneeli.panos100.setEnabled(true);
        }
        if (pelaaja.getKassa() >= 200) {
            paneeli.panos200.setEnabled(true);
        }
        if (pelaaja.getKassa() >= 300) {
            paneeli.panos300.setEnabled(true);
        }
        if (pelaaja.getKassa() >= 400) {
            paneeli.panos400.setEnabled(true);
        }
    }

    public void mustaaPanosNappulat() {
        paneeli.panos100.setEnabled(false);
        paneeli.panos200.setEnabled(false);
        paneeli.panos300.setEnabled(false);
        paneeli.panos400.setEnabled(false);
    }

    public void paivitaVararikossa() {

        paneeli.jaaKortitNappula.setEnabled(false);
        paneeli.jaamisNappula.setEnabled(false);
        paneeli.lyomisNappula.setEnabled(false);
        paneeli.pelaaUudestaanNappula.setEnabled(true);


    }

    public void pelaajanKortit(int id, Kasi kasi, boolean piilotaEka) {
        paneeli.korttiPaneeli();
        JPanel panel = null;
        paneeli.repaint();

        if (id == 0) {
            panel = paneeli.pelaajanKortit;
        } else {
            panel = paneeli.vastustajanKortit;
        }
        panel.removeAll();
        KorttienKuvienLataaja l = new KorttienKuvienLataaja();
        for (int i = 0; i < kasi.getKorttienMaara(); i++) {
            Kortti k = kasi.getKortit().get(i);
            Image kuva = l.getKuva(k);
            if (i == 0 && id != 0 && piilotaEka == true) {
                kuva = l.getKortinTakapuoli();
            }
            JLabel labeli = new JLabel();
            panel.add(labeli);
            ImageIcon icon = new ImageIcon(kuva);
            labeli.setIcon(icon);

        }
    }
}