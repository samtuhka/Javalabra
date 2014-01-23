package blackjack.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PakkaTest {

    Pakka pakka;

    @Before
    public void setUp() {
        pakka = new Pakka();
    }

    @Test
    public void oikeaMaraaKortteja() {
        assertEquals(52, pakka.getPakanKoko());
    }

    @Test
    public void sisaltaaKortin() {
        Kortti k = pakka.annaPaallimainen();

        assertTrue(pakka.sisaltaa(k));
    }

    @Test
    public void poistaKortteja() {
        Kortti k = pakka.annaPaallimainen();
        pakka.poistaKortti(k);
        k = pakka.annaPaallimainen();
        pakka.poistaKortti(k);

        assertTrue(!pakka.sisaltaa(k));
        assertEquals(50, pakka.getPakanKoko());
    }

    @Test
    public void uusiPakka() {
        pakka.uusiPakka();

        assertEquals(52, pakka.getPakanKoko());
    }
}
