package blackjack.domain;

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
    public BlackjackKierros(Pelaaja pelaaja, int panos) {
        this.pelaaja = pelaaja;
        this.jakaja = new Jakaja();
        this.pakka = new Pakka();
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
    }

    /**
     * Valittu pelaaja ottaa pakasta kortin kateensa.
     *
     * @param p jakaja tai pelaaja
     */
    public void lyo(Pelaaja p) {
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
     */
    public boolean pelaajaVoittaa() {
        if (pelaaja.getKasi().busted()) {
            return false;
        }
        if (pelaaja.getPisteet() < jakaja.getPisteet()) {
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
     * Lisaa tai poistaa pelaajan kassasta panoksen.
     */
    public void kierroksenLoppu() {
        if (pelaajaVoittaa()) {
            pelaaja.lisaaKassaan(panos);
        } else {
            pelaaja.poistaKassasta(panos);
        }
    }
}
