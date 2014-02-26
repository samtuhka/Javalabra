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
     * @param panos valittu panos
     */
    public BlackjackKierros(Pelaaja pelaaja, Pakka pakka, Jakaja jakaja, int panos) {
        this.pelaaja = pelaaja;
        this.jakaja = jakaja;
        this.pakka = pakka;
        this.panos = panos;
    }

    /**
     * Aloittaa uuden kierroksen.
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
     * @param p jakaja tai pelaaja
     */
    public void lyo(BlackjackPelaaja p) {
        p.getKasi().otaPakastaKortti(pakka);
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
     * @return 
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
     *
     * @return
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
     * Lisaa tai poistaa pelaajan kassasta panoksen.
     */
    public void kierroksenLoppu() {
        if (tasaPeli()) {
            return;
        } else if (pelaajaVoittaa()) {
            pelaaja.lisaaKassaan(panos);
        } else {
            pelaaja.poistaKassasta(panos);
        }
    }

    /**
     *
     */
    public void jakajaOttaaKortteja() {
        while (jakaja.ottaaKortin()) {
            lyo(jakaja);
        }
    }



}
