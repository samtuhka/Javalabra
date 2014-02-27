package blackjack.domain;

import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BlackjackPeliTest {

    BlackjackPeli peli;
    Pelaaja pelaaja;
    Jakaja jakaja;

    @Before
    public void setUp() {
        this.pelaaja = new Pelaaja("Pelaaja", 1000);
        this.peli = new BlackjackPeli(pelaaja);
        jakaja = this.peli.getJakaja();
    }

    @Test
    public void peliKierros() {
        BlackjackKierros kierros = new BlackjackKierros(pelaaja, new Jakaja(), 100);
        peli.setKierros(kierros);
        assertEquals(kierros, peli.getKierros());
    }

    @Test
    public void oikeaPelaaja() {
        assertEquals(peli.getPelaaja(), pelaaja);
    }

    @Test
    public void oikeaJakaja() {
        assertEquals(peli.getJakaja(), jakaja);
    }

    @Test
    public void oikeaSeuraavanKierroksenPanos() {
        peli.setSeuraavaPanos(400);
        assertTrue(peli.getSeuraavaPanos()==400);
    }
}
