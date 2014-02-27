package blackjack.domain.pelaaja;

import blackjack.domain.Kortti;
import blackjack.domain.Maat;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    Pelaaja pelaaja;

    @Before
    public void setUp() {
        pelaaja = new Pelaaja("Pelaaja", 100);
    }

    @Test
    public void lisaaKassaan() {
        pelaaja.lisaaKassaan(50);
        assertTrue(pelaaja.getKassa() == 150);
    }

    @Test
    public void poistaKassasta() {
        pelaaja.poistaKassasta(50);
        assertTrue(pelaaja.getKassa() == 50);
    }

    @Test
    public void voiBetata() {
        assertTrue(pelaaja.voiBetata(100));
    }

    @Test
    public void eiVoiBetata() {
        assertTrue(!pelaaja.voiBetata(120));
    }

    @Test
    public void vararikossa() {
        pelaaja.poistaKassasta(100);
        assertTrue(pelaaja.vararikko());
    }

    @Test
    public void eiVararikossa() {
        pelaaja.poistaKassasta(50);
        assertTrue(!pelaaja.vararikko());
    }

    @Test
    public void eiVoiTuplata() {
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        assertTrue(!pelaaja.voiTuplata(50));
    }

    @Test
    public void eiVoiTuplata2() {
        
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 8));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        assertTrue(!pelaaja.voiTuplata(200));
    }

    @Test
    public void voiTuplata() {
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 8));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 2));
        assertTrue(pelaaja.voiTuplata(50));
    }

    @Test
    public void voiTuplata2() {
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 7));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 2));
        assertTrue(pelaaja.voiTuplata(50));
    }
}
