package blackjack.domain;

import blackjack.domain.pelaaja.Jakaja;
import blackjack.domain.pelaaja.Pelaaja;

/**
 *
 * @author Samuel
 */
public class BlackjackPeli {

    private Jakaja jakaja;
    private Pakka pakka;
    private BlackjackKierros kierros;
    private Pelaaja pelaaja;
    private int seuraavaPanos;

    /**
     *
     * @param pelaaja
     */
    public BlackjackPeli(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.seuraavaPanos = 100;
        this.jakaja = new Jakaja();
        this.pakka = new Pakka();
        this.kierros = new BlackjackKierros(pelaaja, pakka, jakaja, 100);
    }

    /**
     *
     * @param kierros
     */
    public void setKierros(BlackjackKierros kierros) {
        this.kierros = kierros;
    }

    /**
     *
     * @return
     */
    public BlackjackKierros getKierros() {
        return kierros;
    }

    /**
     *
     * @param panos
     */
    public void setSeuraavaPanos(int panos) {
        this.seuraavaPanos = panos;
    }

    /**
     *
     * @return
     */
    public int getSeuraavaPanos() {
        return seuraavaPanos;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    /**
     *
     * @return
     */
    public Jakaja getJakaja() {
        return jakaja;
    }

    /**
     *
     * @return
     */
    public Pakka getPakka() {
        return pakka;
    }
}
