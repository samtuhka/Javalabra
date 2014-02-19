package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackKierros;
import blackjack.domain.BlackjackPeli;
import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;
import blackjack.gui.Kayttoliittyma;
import blackjack.gui.Paneeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LyomisKuuntelija implements ActionListener {

    public BlackjackKierros kierros;
    private Paneeli paneeli;
    Kayttoliittyma liittyma;

    public LyomisKuuntelija(Paneeli paneeli, BlackjackPeli peli, Kayttoliittyma liittyma) {
        this.paneeli = paneeli;
        this.kierros = peli.getKierros();
        this.liittyma = liittyma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Pelaaja pelaaja = kierros.getPelaaja();
        Jakaja jakaja = kierros.getJakaja();

        kierros.lyo(pelaaja);
        liittyma.pelaajanKortit(0, pelaaja.getKasi(), true);
        liittyma.pelaajanKortit(1, jakaja.getKasi(), true);
         paneeli.tuplausNappula.setEnabled(false);
        if (pelaaja.getKasi().busted()) {
            kierros.kierroksenLoppu();
            liittyma.pelaajanKortit(0, pelaaja.getKasi(), false);
            liittyma.pelaajanKortit(1, jakaja.getKasi(), false);
            paneeli.jaaKortitNappula.setEnabled(true);
            paneeli.lyomisNappula.setEnabled(false);
            paneeli.jaamisNappula.setEnabled(false);
            liittyma.paivitaPelia();
            
            return;
        }   
        if (pelaaja.getPisteet()==21) {
             paneeli.lyomisNappula.setEnabled(false);
        }
        
        paneeli.pelaajaLabel.setText("Pisteet:  " + pelaaja.getPisteet() + "   Kassa: " + pelaaja.getKassa());
        paneeli.jakajaLabel.setText("Jakajan pistemäärä:  " + jakaja.getNakyvaKasi().getArvo());
    }
}
