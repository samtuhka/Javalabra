package blackjack.gui.kuuntelijat;

import blackjack.gui.Kayttoliittyma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vastaa antautumis nappulan toiminnasta. 
 * Jos pelaaja painaa nappia, hän antautuu ja menettää puolet kierroksen panoksesta.
 */
public class AntautumisKuuntelija implements ActionListener {

    Kayttoliittyma ui;

    /**
     * Luo kuuntelijan.
     * @param ui käyttöliittymä.
     */
    public AntautumisKuuntelija(Kayttoliittyma ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.peli.getKierros().antaudu();

        ui.paneeli.nappulatPerustilaan();
        ui.paivitaPelia();
        ui.naytaPelaajanKortit(ui.peli.getJakaja().getKasi(), false, false);
    }
}
