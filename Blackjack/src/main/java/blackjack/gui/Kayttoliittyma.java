package blackjack.gui;

import blackjack.domain.BlackjackPeli;
import blackjack.domain.Kasi;
import blackjack.domain.Kortti;
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
    /**
     *
     */
    public BlackjackPeli peli;
    /**
     *
     */
    public Pelipaneeli paneeli;

    /**
     *
     */
    public Kayttoliittyma() {
        this.peli = new BlackjackPeli(new Pelaaja("Pelaaja", 1000));
        this.paneeli = new Pelipaneeli(this);
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

    /**
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     *
     */
    public void paivitaPelia() {
        Pelaaja pelaaja = peli.getPelaaja();
        Jakaja jakaja = peli.getJakaja();
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

    /**
     *
     */
    public void paivitaPanosNappulat() {
        Pelaaja pelaaja = peli.getPelaaja();
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

    /**
     * Mustaa panosnappulat, jotta pelaaja ei voi painaa niitä kesken
     * kierroksen. Mahdollisesti vähän turha metodi, koska panos ei kesken
     * kierroksen voi kuitenkaan vaihtua.
     */
    public void mustaaPanosNappulat() {
        paneeli.panos100.setEnabled(false);
        paneeli.panos200.setEnabled(false);
        paneeli.panos300.setEnabled(false);
        paneeli.panos400.setEnabled(false);
    }

    /**
     * Päivittää nappulat
     */
    public void paivitaVararikossa() {
        paneeli.jaaKortitNappula.setEnabled(false);
        paneeli.jaamisNappula.setEnabled(false);
        paneeli.lyomisNappula.setEnabled(false);
        paneeli.pelaaUudestaanNappula.setEnabled(true);
    }

    /**
     *
     * @param id
     * @param kasi
     * @param piilotaEka
     */
    public void pelaajanKortit(Kasi kasi, boolean pelaaja, boolean piilotaEka) {

        JPanel panel = null;
        paneeli.repaint();

        if (pelaaja) {
            panel = paneeli.pelaajanKortit;
        } else {
            panel = paneeli.vastustajanKortit;
        }
        panel.removeAll();

        KorttienKuvienLataaja lataaja = new KorttienKuvienLataaja();
        for (int i = 0; i < kasi.getKorttienMaara(); i++) {
            Kortti kortti = kasi.getKortit().get(i);
            Image kuva = lataaja.getKuva(kortti);
            if (i == 0 && pelaaja==false && piilotaEka == true) {
                kuva = lataaja.getKortinTakapuoli();
            }
            JLabel labeli = new JLabel();
            panel.add(labeli);
            if (kuva != null) {       
                ImageIcon icon = new ImageIcon(kuva);
                labeli.setIcon(icon);
            }
            if (kuva==null) {
                varaPelajaanKortit(labeli, kortti, i, pelaaja, piilotaEka);
            }
        }
    }

    public void varaPelajaanKortit(JLabel labeli, Kortti kortti, int i, boolean pelaaja, boolean piilotetaan) {
        System.out.println("Kuvien tiedostopolku väärin!!! Korjaa kuvaKansionPolku luokassa KorttienKuvienLataaja");
        System.out.println("Kuvat korvattu tekstillä");
        if (piilotetaan && i==0 && pelaaja==false) {
            labeli.setText("Piilotettu kortti");
        }
        else {
            labeli.setText(kortti.toString());
        }
       
    }
}