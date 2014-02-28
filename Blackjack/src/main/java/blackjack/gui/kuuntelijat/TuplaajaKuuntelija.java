package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackPeli;
import blackjack.gui.Pelipaneeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vastaa tuplaus nappulan toiminnasta. 
 * Kun pelaaja painaa nappulaa, pelaaja tuplaa ja "painaa" jäämin nappulaa.
 */
public class TuplaajaKuuntelija implements ActionListener {

    private BlackjackPeli peli;
    private Pelipaneeli paneeli;

    /**
     * Luo kuuntelijan.
     * @param paneeli
     * @param peli
     */
    public TuplaajaKuuntelija(Pelipaneeli paneeli, BlackjackPeli peli) {
        this.peli = peli;
        this.paneeli = paneeli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        peli.getKierros().tuplaa();
        paneeli.nappulat.jaamisNappula.doClick();
    }
}
