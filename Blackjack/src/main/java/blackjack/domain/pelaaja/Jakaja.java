package blackjack.domain.pelaaja;

import blackjack.domain.Kasi;

/**
 * Luokka edustaa pelaajaa vastaa pelavaa jakajaa. Perii BlackJack pelaajan
 * ominaisuudet ja lisaksi luokka maarittaa milloin jakaja ottaa kortin.
 */
public class Jakaja extends BlackjackPelaaja {

    /**
     * Luo jakajan.
     */
    public Jakaja() {
        super("Jakaja");
    }

    /**
     * Maarittaa ottaako jakaja kortin vai ei.
     */
    public boolean ottaaKortin() {
        if (getPisteet() <= 16) {
            return true;
        }
        return false;
    }

    public Kasi getNakyvaKasi() {
        Kasi nakyvaKasi = new Kasi();
        for (int i = 1; i <= this.getKasi().getKorttienMaara() -1; i++) {
            nakyvaKasi.lisaaKortti(this.getKasi().getKortit().get(i));
        }

        return nakyvaKasi;
    }
    
    public int getNakyvatPisteet() {
        return getNakyvaKasi().getArvo();
    }
}