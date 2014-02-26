package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackPeli;
import blackjack.gui.Kayttoliittyma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vastaa pelaa uudestaan nappulan toiminnasta.
 * Kun pelaaja klikkaa nappulaa, pelin voi aloittaa uudestaan täydellä kassalla.
 */
public class PelaaUudestaanKuuntelija implements ActionListener {

    private Kayttoliittyma ui;
    private BlackjackPeli peli;

    /**
     * Luo kuuntelijan.
     * @param ui pelin kayttöliittymä.
     */
    public PelaaUudestaanKuuntelija(Kayttoliittyma ui) {
        this.ui = ui;
        this.peli = ui.peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ui.peli.getPelaaja().lisaaKassaan(1000);

        ui.paivitaPelia();
        ui.paneeli.pelaajanKortit.removeAll();
        ui.paneeli.vastustajanKortit.removeAll();
        ui.paneeli.repaint();
        
        ui.paneeli.paneelinTekstit();
        ui.paneeli.nappulatPerustilaan();
    }
}
