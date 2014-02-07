package blackjack.domain.pelaaja;

import blackjack.domain.Kortti;
import blackjack.domain.Maat;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BlackjackPelaajaTest {

    BlackjackPelaaja pelaaja;

    @Before
    public void setUp() {
        pelaaja = new BlackjackPelaaja("Pelaaja");
    }

    @Test
    public void nimi() {
        assertEquals("Pelaaja", pelaaja.getNimi());
    }

    @Test
    public void kasi() {
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 2));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Pata, 5));
        assertTrue(pelaaja.getKasi().getArvo() == 7);
    }

    @Test
    public void pisteet() {
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Pata, 5));
        assertTrue(pelaaja.getPisteet() == 16);
    }
}
