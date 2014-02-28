package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackKierros;
import blackjack.domain.BlackjackPeli;
import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;
import blackjack.gui.Kayttoliittyma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vastaa "jäämis" nappulan toiminnasta.
 * Pelaaja ei ota enää lisää kortteja painaessaan nappulaa ja kierros loppuu;
 */
public class JaamisKuuntelija implements ActionListener {
    
    BlackjackPeli peli;
    BlackjackKierros kierros;
    Kayttoliittyma ui;

    /**
     * Luo kuuntelijan.
     * @param ui käyttöliittymä
     */
    public JaamisKuuntelija(Kayttoliittyma ui) {
        this.peli = ui.peli;
        this.kierros = ui.peli.getKierros();
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Pelaaja pelaaja = peli.getPelaaja();
        Jakaja jakaja = peli.getJakaja();
        
        this.kierros.jakajaOttaaKortteja();

        ui.naytaPelaajanKortit(pelaaja.getKasi(), true, false);
        ui.naytaPelaajanKortit(jakaja.getKasi(), false, false);

        this.kierros.kierroksenLoppu();
        ui.paneeli.nappulatPerustilaan();
        ui.paivitaPelia();
    }
}
