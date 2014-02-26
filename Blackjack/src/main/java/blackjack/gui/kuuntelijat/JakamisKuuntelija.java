package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackKierros;
import blackjack.domain.BlackjackPeli;
import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;
import blackjack.gui.Kayttoliittyma;
import blackjack.gui.Pelipaneeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Samuel
 */
public class JakamisKuuntelija implements ActionListener {

    private BlackjackPeli peli;
    private Kayttoliittyma liittyma;
    private Pelipaneeli paneeli;

    /**
     *
     * @param liittyma
     * @param paneeli
     */
    public JakamisKuuntelija(Kayttoliittyma liittyma, Pelipaneeli paneeli) {
        this.paneeli = paneeli;
        this.peli = liittyma.peli;
        this.liittyma = liittyma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BlackjackKierros kierros = peli.getKierros();

        Pelaaja pelaaja = peli.getPelaaja();
        Jakaja jakaja = peli.getJakaja();

        kierros.uusiKierros(peli.getSeuraavaPanos());

        liittyma.pelaajanKortit(pelaaja.getKasi(), true, true);
        liittyma.pelaajanKortit(jakaja.getKasi(), false, true);
        
        liittyma.mustaaPanosNappulat();
        
        paneeli.pelaajaLabel.setText("Pisteet:  " + pelaaja.getPisteet() + "   Kassa: " + pelaaja.getKassa());
        paneeli.jakajaLabel.setText("Jakajan pistemäärä:  " + jakaja.getNakyvaKasi().getArvo());

        paneeli.jaaKortitNappula.setEnabled(false);
        paneeli.jaamisNappula.setEnabled(true);
        if (pelaaja.getPisteet() != 21) {
            paneeli.lyomisNappula.setEnabled(true);
        }
        if (pelaaja.voiTuplata(peli.getSeuraavaPanos())) {
            paneeli.tuplausNappula.setEnabled(true);
        }
    }
}