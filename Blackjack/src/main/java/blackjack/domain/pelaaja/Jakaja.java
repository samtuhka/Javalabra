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
     * @return true jos ottaa kortin muuten false
     */
    public boolean ottaaKortin() {
        if (getPisteet() <= 16) {
            return true;
        }
        return false;
    }

    /**
     * Maarittaa jakajan käden, jonka pelaaja näkee ennen kuin pelikierros loppuu.
     * @return näkyvä käsi
     */
    public Kasi getNakyvaKasi() {
        Kasi nakyvaKasi = new Kasi();
        for (int i = 1; i <= this.getKasi().getKorttienMaara() -1; i++) {
            nakyvaKasi.lisaaKortti(this.getKasi().getKortit().get(i));
        }

        return nakyvaKasi;
    }
    
    /**
     * Maarittaa jakajan pisteet, jotka  pelaaja näkee ennen kuin pelikierros loppuu
     * @return näkyvän käden pisteet
     */
    public int getNakyvatPisteet() {
        return getNakyvaKasi().getArvo();
    }
}