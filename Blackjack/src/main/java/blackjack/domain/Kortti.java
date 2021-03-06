package blackjack.domain;


/**
 * Luokka edustaa pelikortteja.
 */
public class Kortti {

    private static String[] Arvot = {"-", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private Maat maa;
    private int arvo;

    /**
     *  Luo kortin.
     * @param maa kortin maa
     * @param arvo kortin arvo
     */
    public Kortti(Maat maa, int arvo) {
        this.arvo = arvo;
        this.maa = maa;
    }

    /**
     * Pelauttaa kortin numeroarvon.
     * @return numeroarvo.
     */
    public int getArvo() {
        return arvo;
    }

    /**
     * Palauttaa kortin pistearvon, joka maarayttyy Blackjackin saantojen mukaan.
     * @return pistearvo
     */
    public int getPisteArvo() {
        if (arvo == 1) {
            return 1;
        } else if (arvo > 10) {
            return 10;
        } else {
            return arvo;
        }
    }

    /**
     * Palauttaa kortin maan.
     * @return 
     */
    public String getMaa() {
        return maa.toString();
    }

    @Override
    public String toString() {
        return maa.toString() + " " + Arvot[arvo];
    }

}
