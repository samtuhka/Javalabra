package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackKierros;
import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;
import blackjack.gui.Kayttoliittyma;
import blackjack.gui.Pelipaneeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * 
 */
public class LyomisKuuntelija implements ActionListener {

    /**
     *
     */
    public BlackjackKierros kierros;
    private Pelipaneeli paneeli;
    Kayttoliittyma liittyma;

    /**
     *
     * @param paneeli
     * @param liittyma
     */
    public LyomisKuuntelija(Pelipaneeli paneeli, Kayttoliittyma liittyma) {
        this.paneeli = paneeli;
        this.kierros = liittyma.peli.getKierros();
        this.liittyma = liittyma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Pelaaja pelaaja = liittyma.peli.getPelaaja();
        Jakaja jakaja =  liittyma.peli.getJakaja();

        kierros.lyo(pelaaja);
        liittyma.pelaajanKortit(pelaaja.getKasi(), true, false);
        liittyma.pelaajanKortit(jakaja.getKasi(), false, true);
        paneeli.tuplausNappula.setEnabled(false);
        if (pelaaja.getKasi().busted()) {
            kierros.kierroksenLoppu();
            liittyma.pelaajanKortit(jakaja.getKasi(), false, false);
            paneeli.nappulatPerustilaan();
            liittyma.paivitaPelia();
            return;
        }
        if (pelaaja.getPisteet() == 21) {
            paneeli.lyomisNappula.setEnabled(false);
        }

        paneeli.pelaajaLabel.setText("Pisteet:  " + pelaaja.getPisteet() + "   Kassa: " + pelaaja.getKassa());
        paneeli.jakajaLabel.setText("Jakajan pistemäärä:  " + jakaja.getNakyvaKasi().getArvo());
    }
}
