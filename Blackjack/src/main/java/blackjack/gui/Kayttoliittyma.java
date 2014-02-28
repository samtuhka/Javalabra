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
 * Vastaa käyttöliittymästä.
 * 
 */
public class Kayttoliittyma implements Runnable {

    private KorttienKuvienLataaja lataaja;
    private JFrame frame;
    /**
     * Blackjack peli jota käyttöliittymä käyttää.
     */
    public BlackjackPeli peli;
    /**
     * Pelipaneeli joka on osa käyttöliittymää.
     */
    public Pelipaneeli paneeli;

    /**
     * Luo käyttöliittymän.
     */
    public Kayttoliittyma() {
        this.peli = new BlackjackPeli(new Pelaaja("Pelaaja", 1000));
        this.paneeli = new Pelipaneeli(this);
        this.lataaja = new KorttienKuvienLataaja();
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

    /**
     * Päivittää pelin käyttöliittymää pelitilanteen mukaan.
     */
    public void paivitaPelia() {
        Pelaaja pelaaja = peli.getPelaaja();
        Jakaja jakaja = peli.getJakaja();
        paivitaPanosNappulat();
        if (pelaaja.getKassa() < peli.getSeuraavaPanos()) {
            paneeli.nappulat.panos100.doClick();
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
     * Päivittää panosnappuloiden tilat.
     */
    public void paivitaPanosNappulat() {
        Pelaaja pelaaja = peli.getPelaaja();
        mustaaPanosNappulat();

        if (pelaaja.getKassa() >= 100) {
            paneeli.nappulat.panos100.setEnabled(true);
        }
        if (pelaaja.getKassa() >= 200) {
            paneeli.nappulat.panos200.setEnabled(true);
        }
        if (pelaaja.getKassa() >= 300) {
            paneeli.nappulat.panos300.setEnabled(true);
        }
        if (pelaaja.getKassa() >= 400) {
            paneeli.nappulat.panos400.setEnabled(true);
        }
    }

    /**
     * Mustaa panosnappulat, jotta pelaaja ei voi painaa niitä kesken
     * kierroksen. Mahdollisesti vähän turha metodi, koska panos ei kesken
     * kierroksen voi kuitenkaan vaihtua.
     */
    public void mustaaPanosNappulat() {
        paneeli.nappulat.panos100.setEnabled(false);
        paneeli.nappulat.panos200.setEnabled(false);
        paneeli.nappulat.panos300.setEnabled(false);
        paneeli.nappulat.panos400.setEnabled(false);
    }

    /**
     * Päivittää nappulat kun pelaaja vararikossa.
     */
    public void paivitaVararikossa() {
        paneeli.nappulat.jaaKortitNappula.setEnabled(false);
        paneeli.nappulat.jaamisNappula.setEnabled(false);
        paneeli.nappulat.otaKorttiNappula.setEnabled(false);
        paneeli.nappulat.pelaaUudestaanNappula.setEnabled(true);
    }

    /**
     * Sijoittaa pelikorttien kuvia pelipaneeliin.
     *
     * @param kasi käsi jonka kortit halutaan näyttää.
     * @param pelaaja määrittää onko kyseessä ihmispelaaja vai jakaja, jonka
     * kortteja näytetään.
     * @param piilotaEka määrittää piilotetaanko jakajan ensimmäinen kortti.
     */
    public void naytaPelaajanKortit(Kasi kasi, boolean pelaaja, boolean piilotaEka) {

        JPanel panel = null;
        paneeli.repaint();

        if (pelaaja) {
            panel = paneeli.pelaajanKortit;
        } else {
            panel = paneeli.vastustajanKortit;
        }
        panel.removeAll();


        for (int i = 0; i < kasi.getKorttienMaara(); i++) {
            Kortti kortti = kasi.getKortit().get(i);
            Image kuva = lataaja.getKuva(kortti);
            if (i == 0 && pelaaja == false && piilotaEka == true) {
                kuva = lataaja.getKortinTakapuoli();
            }
            JLabel labeli = new JLabel();
            panel.add(labeli);
            if (kuva != null) {
                ImageIcon icon = new ImageIcon(kuva);
                labeli.setIcon(icon);
            }
            if (kuva == null) {
                varaPelajaanKortit(labeli, kortti, i, pelaaja, piilotaEka);
            }
        }
    }

    /**
     * Varametodi, jota naytaPelaajanKortit metodi kutsuu, jos korttien kuvat
     * palautuu nulleina. Kuvien sijasta kortit representoituu tekstinä.
     *
     * @param labeli pelipaneelin osa johon teksti sijoitetaan.
     * @param kortti mitä korttia kuvataan.
     * @param i kortin indeksi.
     * @param pelaaja määrittää onko kyseessä jakaja vai ihmispelaaja.
     * @param piilotetaan piilotetaanko ensimmäinen kortti vai ei.
     */
    public void varaPelajaanKortit(JLabel labeli, Kortti kortti, int i, boolean pelaaja, boolean piilotetaan) {
        System.out.println("Polkua " + lataaja.getPolku() + "ei löydy. Kuvakansion tiedostopolku väärin!!!");
        System.out.println("Korjaa kuvaKansionPolku luokassa KorttienKuvienLataaja!");
        System.out.println("Kuvat korvattu tekstillä");
        if (piilotetaan && i == 0 && pelaaja == false) {
            labeli.setText("Piilotettu kortti");
        } else {
            labeli.setText(kortti.toString());
        }

    }
}