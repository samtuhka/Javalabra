package blackjack.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class KorttiTest {

    Kortti kortti;

    @Test
    public void oikeaArvo() {
        kortti = new Kortti(Maat.Hertta, 3);
        assertEquals(3, kortti.getArvo());
    }

    @Test
    public void oikeaMaa() {
        kortti = new Kortti(Maat.Pata, 10);
        assertEquals("Pata", kortti.getMaa());
    }

    @Test
    public void pistearvo1() {
        kortti = new Kortti(Maat.Pata, 8);
        assertEquals(8, kortti.getPisteArvo());
    }

    @Test
    public void pistearvo2() {
        kortti = new Kortti(Maat.Pata, 12);
        assertEquals(10, kortti.getPisteArvo());
    }

    @Test
    public void oikeaKortti() {
        kortti = new Kortti(Maat.Pata, 11);
        assertEquals("Pata J", kortti.toString());
    }
}
