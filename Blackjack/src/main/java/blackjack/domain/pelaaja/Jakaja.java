package blackjack.domain.pelaaja;

/**
 * Luokka edustaa pelaajaa vastaa pelavaa jakajaa.
 * Perii BlackJack pelaajan ominaisuudet ja lisaksi luokka maarittaa milloin jakaja ottaa kortin.
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
        if (getKasi().getArvo() <= 16) {
            return true;
        }
        return false;
    }
}