package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackPeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanosKuuntelija implements ActionListener {

    private BlackjackPeli peli;
    private int panos;

    public PanosKuuntelija(int panos, BlackjackPeli peli) {
        this.panos = panos;
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.setSeuraavaPanos(panos);
    }
}
