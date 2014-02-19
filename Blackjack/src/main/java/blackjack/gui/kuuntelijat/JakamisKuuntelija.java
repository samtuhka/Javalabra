package blackjack.gui.kuuntelijat;

import blackjack.domain.BlackjackKierros;
import blackjack.domain.BlackjackPeli;
import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;
import blackjack.gui.Kayttoliittyma;
import blackjack.gui.Paneeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JakamisKuuntelija implements ActionListener {

    private BlackjackPeli peli;
    private Kayttoliittyma liittyma;
    private Paneeli paneeli;

    public JakamisKuuntelija(Kayttoliittyma liittyma, Paneeli paneeli, BlackjackPeli peli) {
        this.paneeli = paneeli;
        this.peli = peli;
        this.liittyma = liittyma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BlackjackKierros kierros = peli.getKierros();

        Pelaaja pelaaja = kierros.getPelaaja();
        Jakaja jakaja = kierros.getJakaja();


        kierros.uusiKierros(peli.getSeuraavaPanos());

        kierros.lyo(pelaaja);
        kierros.lyo(pelaaja);

        kierros.lyo(jakaja);
        kierros.lyo(jakaja);
        
        liittyma.pelaajanKortit(0, pelaaja.getKasi(), true);
        liittyma.pelaajanKortit(1, jakaja.getKasi(), true);
        
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
