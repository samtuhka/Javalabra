package blackjack.domain.pelaaja;

import blackjack.domain.Kasi;

/**
 * Luokka vastaa jakajan ja pelaajan yhteisista ominaisuuksista.
 */
public class BlackjackPelaaja {

    private Kasi kasi;
    private String nimi;

    /**
     * Luo BlackJack pelaajan.
     * @param nimi 
     */
    public BlackjackPelaaja(String nimi) {
        this.nimi = nimi;
        this.kasi = new Kasi();
    }

    /**
     * Luo uuden kaden.
     */
    public void uusiKasi() {
        kasi = new Kasi();
    }

    /**
     * Palauttaa BlackJack pelaajan nimen.
     * @return nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Palauttaa kaden, joka BlackJack pelaajalla on.
     * @return käsi
     */
    public Kasi getKasi() {
        return this.kasi;
    }
    
    /**
     * Palauttaa pisteet.
     * @return pisteet
     */
    public int getPisteet() {
        return this.kasi.getArvo();
    }

}
