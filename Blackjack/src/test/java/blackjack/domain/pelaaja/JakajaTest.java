package blackjack.domain.pelaaja;

import blackjack.domain.Kortti;
import blackjack.domain.Maat;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JakajaTest {

    Jakaja jakaja;

    @Before
    public void setUp() {
        jakaja = new Jakaja();
    }

    @Test
    public void ottaaKortin() {
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 2));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Pata, 5));
        assertTrue(jakaja.ottaaKortin());
    }

    @Test
    public void ottaaKortin2() {
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Pata, 5));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Pata, 5));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Pata, 5));
        assertTrue(jakaja.ottaaKortin());
    }

    @Test
    public void eiOtaKorttia2() {
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Pata, 5));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Pata, 5));
        assertTrue(!jakaja.ottaaKortin());
    }

    @Test
    public void nakyvaKasi() {
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Pata, 5));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Pata, 5));
        assertTrue(jakaja.getNakyvaKasi().getKorttienMaara()==2);
    }

    @Test
    public void nakyvatPisteet() {
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Pata, 5));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Pata, 5));
        assertTrue(jakaja.getNakyvatPisteet() == 10);
    }
}
