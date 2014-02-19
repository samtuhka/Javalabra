package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackPeli;
import blackjack.gui.Paneeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TuplaajaKuuntelija implements ActionListener {

    private BlackjackPeli peli;
    private Paneeli paneeli;

    public TuplaajaKuuntelija(Paneeli paneeli, BlackjackPeli peli) {
        this.peli = peli;
        this.paneeli = paneeli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        peli.getKierros().tuplaa();
        paneeli.jaamisNappula.doClick();

    }
}
