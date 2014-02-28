package blackjack.domain;

import blackjack.domain.pelaaja.BlackjackPelaaja;
import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;

/**
 * Luokka vastaa pelikierroksista.
 */
public class BlackjackKierros {

    private Pelaaja pelaaja;
    private Jakaja jakaja;
    private Pakka pakka;
    private int panos;

    /**
     * Luo pelin ensimmaisen kierroksen
     *
     * @param pelaaja pelaaja
     * @param jakaja
     * @param panos valittu panos
     */
    public BlackjackKierros(Pelaaja pelaaja, Jakaja jakaja, int panos) {
        this.pelaaja = pelaaja;
        this.jakaja = jakaja;
        uusiKierros(panos);
    }

    /**
     * Aloittaa uuden kierroksen. Pelaaja ja jakaja ottaa kaksi korttia.
     *
     * @param panos valittu panos
     */
    public void uusiKierros(int panos) {
        this.pakka = new Pakka();
        this.pelaaja.uusiKasi();
        this.jakaja.uusiKasi();
        this.panos = panos;

        lyo(pelaaja);
        lyo(pelaaja);
        lyo(jakaja);
        lyo(jakaja);
    }

    /**
     * Valittu pelaaja ottaa pakasta kortin kateensa.
     *
     * @param pelaaja jakaja tai pelaaja
     */
    public void lyo(BlackjackPelaaja pelaaja) {
        pelaaja.getKasi().otaPakastaKortti(pakka);
    }

    /**
     * Panos tuplaantuu.
     */
    public void tuplaa() {
        panos = panos * 2;
        lyo(pelaaja);
    }

    /**
     * Maarittaa voittaako vai haviaako pelaaja kierroksen.
     *
     * @return jos pelaaja voittaa palauttaa true muuten false.
     */
    public boolean pelaajaVoittaa() {
        if (pelaaja.getKasi().busted()) {
            return false;
        }
        if (pelaaja.getPisteet() < jakaja.getPisteet() && jakaja.getPisteet() <= 21) {
            return false;
        } else if (pelaaja.getPisteet() == 21 && jakaja.getPisteet() == 21 && pelaaja.getKasi().getKorttienMaara() == 2 && jakaja.getKasi().getKorttienMaara() != 2) {
            return true;
        } else if (pelaaja.getPisteet() == jakaja.getPisteet()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Määrittää tuleeko tasapeli vai ei. Jos sekä pelaajalla, että jakajalla on
     * blackjack tai kummallakin on pisteet 21 ilman blackjackia, on tasapeli.
     *
     * @return jos tasapali true muuten false.
     */
    public boolean tasaPeli() {
        if (pelaaja.getKasi().onBlackjack() && jakaja.getKasi().onBlackjack()) {
            return true;
        }
        if (!pelaaja.getKasi().onBlackjack() && !jakaja.getKasi().onBlackjack() && pelaaja.getPisteet() == 21 && jakaja.getPisteet() == 21) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Vastaa kierroksen lopun toiminnasta. Lisaa tai poistaa pelaajan kassasta
     * panoksen sen mukaan voitettiinko, hävittiinkö vai tuliko tasapeli.
     * Jos voittaa blackjackilla voittaa 3:2 kertaa panoksen.   
     */
    public void kierroksenLoppu() {
        if (tasaPeli()) {
            return;
        } else if (pelaajaVoittaa() && pelaaja.getKasi().onBlackjack()) {
            int voitto = (int) (panos * 1.5);
            pelaaja.lisaaKassaan(voitto);
        } else if (pelaajaVoittaa()) {
            pelaaja.lisaaKassaan(panos);
        } else {
            pelaaja.poistaKassasta(panos);
        }
    }

    /**
     * Metodi vastaa jakajan korttien ottamisesta. Jakaja ottaa kortteja, kunnes
     * hänen korttien pistemäärä on >=17.
     */
    public void jakajaOttaaKortteja() {
        while (jakaja.ottaaKortin()) {
            lyo(jakaja);
        }
    }

    /**
     * Palauttaa kierroksella käytetyn korttipakan.
     *
     * @return pakka
     */
    public Pakka getPakka() {
        return pakka;
    }

    /**
     * Palauttaa kierroksen panoksen.
     *
     * @return panos
     */
    public int getPanos() {
        return this.panos;
    }
}
