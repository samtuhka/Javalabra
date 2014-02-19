package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackKierros;
import blackjack.domain.BlackjackPeli;
import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;
import blackjack.gui.Kayttoliittyma;
import blackjack.gui.Paneeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JaamisKuuntelija implements ActionListener {

    Paneeli paneeli;
    BlackjackKierros kierros;
    ;
    Kayttoliittyma liittyma;

    public JaamisKuuntelija(Paneeli paneeli, BlackjackPeli peli, Kayttoliittyma liittyma) {
        this.paneeli = paneeli;
        this.kierros = peli.getKierros();
        this.liittyma = liittyma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Pelaaja pelaaja = this.kierros.getPelaaja();
        Jakaja jakaja = this.kierros.getJakaja();
        while (jakaja.ottaaKortin()) {
            this.kierros.lyo(jakaja);
        }
        liittyma.pelaajanKortit(0, pelaaja.getKasi(), false);
        liittyma.pelaajanKortit(1, jakaja.getKasi(), false);

        this.kierros.kierroksenLoppu();

        paneeli.lyomisNappula.setEnabled(false);
        paneeli.jaamisNappula.setEnabled(false);
        paneeli.jaaKortitNappula.setEnabled(true);
        paneeli.tuplausNappula.setEnabled(false);

        liittyma.paivitaPelia();

    }
}
