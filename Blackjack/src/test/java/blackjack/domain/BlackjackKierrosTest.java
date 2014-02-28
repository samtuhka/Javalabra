package blackjack.domain;

import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BlackjackKierrosTest {

    BlackjackKierros kierros;
    Pelaaja pelaaja;
    Jakaja jakaja;

    @Before
    public void setUp() {
        this.jakaja = new Jakaja();
        this.pelaaja = new Pelaaja("Pelaaja", 1000);
        this.kierros = new BlackjackKierros(pelaaja, jakaja, 100);
    }

    @Test
    public void ensimmainenKierros() {
        assertTrue(pelaaja.getKasi().getKorttienMaara() == 2);
        assertTrue(kierros.getPakka().getPakanKoko() == 48);

    }

    @Test
    public void uusiKierros() {
        kierros.uusiKierros(200);
        assertTrue(jakaja.getKasi().getKorttienMaara() == 2);
        assertTrue(pelaaja.getKasi().getKorttienMaara() == 2);
        assertTrue(kierros.getPakka().getPakanKoko() == 48);

    }

    @Test
    public void lyo() {
        kierros.lyo(pelaaja);
        assertTrue(pelaaja.getKasi().getKorttienMaara() == 3);
        assertTrue(kierros.getPakka().getPakanKoko() == 47);
    }

    @Test
    public void tuplaa() {
        kierros.tuplaa();
        assertTrue(kierros.getPanos() == 200);
        assertTrue(kierros.getPakka().getPakanKoko() == 47);
    }

    @Test
    public void haviaa() {
        while (kierros.getPakka().getPakanKoko() >= 1) {
            kierros.lyo(pelaaja);
        }
        assertTrue(!kierros.pelaajaVoittaa());
    }

    @Test
    public void voittaa() {
        while (kierros.getPakka().getPakanKoko() >= 1) {
            kierros.lyo(jakaja);
        }
        assertTrue(kierros.pelaajaVoittaa());
    }

    @Test
    public void jakajaOttaaKortteja() {
        kierros.jakajaOttaaKortteja();
        assertTrue(jakaja.getKasi().getKorttienMaara()>=2);
        assertTrue(jakaja.ottaaKortin() == false);
    }

    @Test
    public void tasaPeli() {
        pelaaja.uusiKasi();
        jakaja.uusiKasi();
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 12));

        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 12));

        assertTrue(kierros.tasaPeli());
    }

    @Test
    public void tasaPeli2() {
        pelaaja.uusiKasi();
        jakaja.uusiKasi();
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 13));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 12));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));

        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 12));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 13));

        assertTrue(kierros.tasaPeli());
    }

    @Test
    public void eiTasaPelia() {
        pelaaja.uusiKasi();
        jakaja.uusiKasi();
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 13));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 12));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));

        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 12));

        assertTrue(!kierros.tasaPeli());
    }

    @Test
    public void tasaPeliKierroksenLoppu() {
        pelaaja.uusiKasi();
        jakaja.uusiKasi();
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 12));

        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 12));

        kierros.kierroksenLoppu();
        assertTrue(pelaaja.getKassa() == 1000);
    }

    @Test
    public void havioKierroksenLoppu() {
        pelaaja.uusiKasi();
        jakaja.uusiKasi();
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 13));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 12));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));

        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 12));

        kierros.kierroksenLoppu();
        assertTrue(kierros.pelaajaVoittaa()==false);
        assertTrue(pelaaja.getKassa() == 900);
    }

    @Test
    public void voittoaKierroksenLoppu() {
        pelaaja.uusiKasi();
        jakaja.uusiKasi();
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 3));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 2));

        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 3));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 7));

        kierros.kierroksenLoppu();
        assertTrue(pelaaja.getKassa() == 1100);
    }

    @Test
    public void voittoBlackjackillaKierroksenLoppu() {
        pelaaja.uusiKasi();
        jakaja.uusiKasi();
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 13));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 12));
        jakaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));

        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 1));
        pelaaja.getKasi().lisaaKortti(new Kortti(Maat.Hertta, 12));

        kierros.kierroksenLoppu();
        assertTrue(pelaaja.getKassa() == 1150);
    }
}
