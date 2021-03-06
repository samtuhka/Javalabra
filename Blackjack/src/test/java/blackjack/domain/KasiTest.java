package blackjack.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KasiTest {

    Kasi kasi;
    Pakka pakka;

    @Before
    public void setUp() {
        kasi = new Kasi();
        pakka = new Pakka();
    }

    @Test
    public void lisaaAssa() {
        Kortti k = new Kortti(Maat.Hertta, 1);
        kasi.lisaaKortti(k);
        assertEquals(11, kasi.getArvo());
    }

    @Test
    public void blackjack() {
        Kortti k1 = new Kortti(Maat.Hertta, 1);
        Kortti k2 = new Kortti(Maat.Hertta, 10);
        kasi.lisaaKortti(k1);
        kasi.lisaaKortti(k2);
        assertEquals(21, kasi.getArvo());
        assertTrue(kasi.onBlackjack());
    }

    @Test
    public void lisaaKortteja() {
        Kortti k1 = new Kortti(Maat.Hertta, 1);
        Kortti k2 = new Kortti(Maat.Hertta, 10);
        Kortti k3 = new Kortti(Maat.Hertta, 10);
        kasi.lisaaKortti(k1);
        kasi.lisaaKortti(k2);
        kasi.lisaaKortti(k3);
        assertEquals(21, kasi.getArvo());
        assertTrue(!kasi.onBlackjack());
    }

    @Test
    public void onBusted() {
        Kortti k1 = new Kortti(Maat.Hertta, 1);
        Kortti k2 = new Kortti(Maat.Hertta, 10);
        Kortti k3 = new Kortti(Maat.Hertta, 10);
        Kortti k4 = new Kortti(Maat.Hertta, 10);
        kasi.lisaaKortti(k1);
        kasi.lisaaKortti(k2);
        kasi.lisaaKortti(k3);
        kasi.lisaaKortti(k4);
        assertEquals(31, kasi.getArvo());
        assertTrue(kasi.busted());
    }

    @Test
    public void eiBusted() {
        Kortti k1 = new Kortti(Maat.Hertta, 1);
        Kortti k2 = new Kortti(Maat.Hertta, 10);
        Kortti k3 = new Kortti(Maat.Hertta, 10);
        kasi.lisaaKortti(k1);
        kasi.lisaaKortti(k2);
        kasi.lisaaKortti(k3);
        assertTrue(!kasi.busted());
    }

    @Test
    public void otaKorttiPakasta() {
        kasi.otaPakastaKortti(pakka);
        assertEquals(1, kasi.getKorttienMaara());
        assertEquals(51, pakka.getPakanKoko());
    }

    @Test
    public void otaKorttejaPakasta() {
        kasi.otaPakastaKortti(pakka);
        kasi.otaPakastaKortti(pakka);
        kasi.otaPakastaKortti(pakka);
        assertEquals(3, kasi.getKorttienMaara());
        assertEquals(49, pakka.getPakanKoko());
    }

    @Test
    public void poistaKortti() {
        Kortti kortti = new Kortti(Maat.Pata, 2);
        kasi.lisaaKortti(kortti);
        kasi.poistaKortti(kortti);
        assertTrue(!kasi.getKortit().contains(kortti));
    }

    @Test
    public void samaKasi() {
        kasi.otaPakastaKortti(pakka);
        kasi.otaPakastaKortti(pakka);
        assertTrue(kasi.getKortit().size()==2);
    }
}
