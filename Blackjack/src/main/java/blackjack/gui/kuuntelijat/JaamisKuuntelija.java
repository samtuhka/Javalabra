package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackKierros;
import blackjack.domain.BlackjackPeli;
import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;
import blackjack.gui.Kayttoliittyma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Samuel
 */
public class JaamisKuuntelija implements ActionListener {
    
    BlackjackPeli peli;
    BlackjackKierros kierros;
    Kayttoliittyma ui;

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

        ui.pelaajanKortit(pelaaja.getKasi(), true, false);
        ui.pelaajanKortit(jakaja.getKasi(), false, false);

        this.kierros.kierroksenLoppu();
        ui.paneeli.nappulatPerustilaan();
        ui.paivitaPelia();
    }
}
