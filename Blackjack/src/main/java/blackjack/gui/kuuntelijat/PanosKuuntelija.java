package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackPeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vastaa panos nappuloiden toiminnasta.
 * Pelaaja valitsee seuraavan kierroksen panoksen painamalla nappulaa. 
 */
public class PanosKuuntelija implements ActionListener {

    private BlackjackPeli peli;
    private int panos;

    /**
     * Luo kuuntelijan.
     * @param panos valitun nappulan panos.
     * @param peli 
     */
    public PanosKuuntelija(int panos, BlackjackPeli peli) {
        this.panos = panos;
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.setSeuraavaPanos(panos);
    }
}
