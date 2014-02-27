package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackKierros;
import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;
import blackjack.gui.Kayttoliittyma;
import blackjack.gui.Pelipaneeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vastaa lyömis/anna kortti nappulan toiminnasta.
 * Pelaaja ottaa yhden kortin lisää painaessaan nappulaa. 
 */
public class LyomisKuuntelija implements ActionListener {

    private BlackjackKierros kierros;
    private Pelipaneeli paneeli;
    Kayttoliittyma ui;

    /**
     * Luo kuuntelijan.
     * @param paneeli 
     * @param liittyma
     */
    public LyomisKuuntelija(Pelipaneeli paneeli, Kayttoliittyma ui) {
        this.paneeli = paneeli;
        this.kierros = ui.peli.getKierros();
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Pelaaja pelaaja = ui.peli.getPelaaja();
        Jakaja jakaja =  ui.peli.getJakaja();

        kierros.lyo(pelaaja);
        ui.pelaajanKortit(pelaaja.getKasi(), true, false);
        ui.pelaajanKortit(jakaja.getKasi(), false, true);
        paneeli.tuplausNappula.setEnabled(false);
        if (pelaaja.getKasi().busted()) {
            kierros.kierroksenLoppu();
            ui.pelaajanKortit(jakaja.getKasi(), false, false);
            paneeli.nappulatPerustilaan();
            ui.paivitaPelia();
            return;
        }
        if (pelaaja.getPisteet() == 21) {
            paneeli.lyomisNappula.setEnabled(false);
        }

        paneeli.pelaajaLabel.setText("Pisteet:  " + pelaaja.getPisteet() + "   Kassa: " + pelaaja.getKassa());
        paneeli.jakajaLabel.setText("Jakajan pistemäärä:  " + jakaja.getNakyvaKasi().getArvo());
    }
}
