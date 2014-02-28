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
 * Vastaa "jaa kortit" nappulan toiminnasta.
 * Nappia painatessa pelaajalle jaetaan kortit ja pelikierros alkaa.
 */
public class JakamisKuuntelija implements ActionListener {

    private BlackjackPeli peli;
    private Kayttoliittyma liittyma;
    private Pelipaneeli paneeli;

    /**
     * Luo kuuntelijan.
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

        liittyma.naytaPelaajanKortit(pelaaja.getKasi(), true, true);
        liittyma.naytaPelaajanKortit(jakaja.getKasi(), false, true);
        
        liittyma.mustaaPanosNappulat();
        
        paneeli.pelaajaLabel.setText("Pisteet:  " + pelaaja.getPisteet() + "   Kassa: " + pelaaja.getKassa());
        paneeli.jakajaLabel.setText("Jakajan pistemäärä:  " + jakaja.getNakyvaKasi().getArvo());

        paneeli.nappulat.jaaKortitNappula.setEnabled(false);
        paneeli.nappulat.jaamisNappula.setEnabled(true);
        if (pelaaja.getPisteet() != 21) {
            paneeli.nappulat.otaKorttiNappula.setEnabled(true);
        }
        if (pelaaja.voiTuplata(peli.getSeuraavaPanos())) {
            paneeli.nappulat.tuplausNappula.setEnabled(true);
        }
    }
}
