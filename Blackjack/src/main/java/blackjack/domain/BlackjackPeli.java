package blackjack.domain;

import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;

/**
 * Luokka vastaa pelikierrosten ja koko pelin toiminnasta. 
 * attribuutti seuraavaPanos määrittää seuraavan kierroksen panoksen, jonka pelaaja valitsee kierroksen päätettyä.
 */
public class BlackjackPeli {

    private Jakaja jakaja;
    private BlackjackKierros kierros;
    private Pelaaja pelaaja;
    private int seuraavaPanos;

    /**
     * Luo blackjack pelin.
     * @param pelaaja
     */
    public BlackjackPeli(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.seuraavaPanos = 100;
        this.jakaja = new Jakaja();
        this.kierros = new BlackjackKierros(pelaaja, jakaja, 100);
    }

    /**
     * Asettaa pelikierroksen kuten halutaan.
     * @param kierros
     */
    public void setKierros(BlackjackKierros kierros) {
        this.kierros = kierros;
    }

    /**
     * Palauttaa pelikierroksen.
     * @return palautettu kierros
     */
    public BlackjackKierros getKierros() {
        return kierros;
    }

    /**
     * Muuttaa seuraavan kierroksen panoksen valituksi.
     * @param panos
     */
    public void setSeuraavaPanos(int panos) {
        this.seuraavaPanos = panos;
    }

    /**
     * Palautaa seuraavan kierroksen panoksen.
     * @return panos
     */
    public int getSeuraavaPanos() {
        return seuraavaPanos;
    }

    /**
     * Palauttaa pelin pelaajan.
     * @return pelaaja
     */
    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    /**
     * Palauttaa pelin jakajan.
     * @return jakaja
     */
    public Jakaja getJakaja() {
        return jakaja;
    }
}
