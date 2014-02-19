package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackPeli;
import blackjack.gui.Kayttoliittyma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PelaaUudestaanKuuntelija implements ActionListener {

    private Kayttoliittyma ui;
    private BlackjackPeli peli;

    public PelaaUudestaanKuuntelija(Kayttoliittyma ui) {
        this.ui = ui;
        this.peli = ui.peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.peli.getKierros().getPelaaja().lisaaKassaan(1000);

        ui.paivitaPelia();
        ui.paneeli.pelaajanKortit.removeAll();
        ui.paneeli.vastustajanKortit.removeAll();
        ui.paneeli.repaint();

        ui.paneeli.jakajaLabel.setText("  Jakaja:  ");
        ui.paneeli.pelaajaLabel.setText("  Pelaaja:  ");
        ui.paneeli.pelaaUudestaanNappula.setEnabled(false);
        ui.paneeli.jaaKortitNappula.setEnabled(true);
    }
}
