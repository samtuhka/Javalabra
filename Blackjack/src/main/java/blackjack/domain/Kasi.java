package blackjack.domain;

import java.util.ArrayList;

/**
 * Luokka vastaa korteista muodostuvasta pelikadesta.
 */
public class Kasi {

    private ArrayList<Kortti> kasi;

    /**
     * Luo kaden.
     */
    public Kasi() {
        this.kasi = new ArrayList<>();
    }

    /**
     * Lisaa kateen kortin.
     * @param kortti kortti joka lisataan
     */
    public void lisaaKortti(Kortti kortti) {
        kasi.add(kortti);
    }

    /**
     * Poistaa kadesta kortin.
     * @param kortti
     */
    public void poistaKortti(Kortti kortti) {
        kasi.remove(kortti);
    }

    /**
     * Ottaa pakasta kortin, poistaa kortin pakasta ja lisaa kortin kateen.
     * @param pakka
     */
    public void otaPakastaKortti(Pakka pakka) {
        Kortti kortti = pakka.annaPaallimainen();
        lisaaKortti(kortti);
        pakka.poistaKortti(kortti);
    }

    /**
     * Laskee kaden pistearvon.
     * @return pistearvo
     */
    public int getArvo() {
        int arvo = 0;
        int assa = 0;
        for (Kortti k : kasi) {
            if (k.getArvo() == 1) {
                assa++;
            }
            arvo = arvo + k.getPisteArvo();
        }
        if (arvo <= 11 && assa > 0) {
            arvo = arvo + 10;
        }
        return arvo;
    }

    /**
     * Maarittaa onko kasi Blackjack.
     * @return true jos on blackjack muuten false
     */
    public boolean onBlackjack() {
        if (kasi.size() == 2 && getArvo() == 21) {
            return true;
        }
        return false;
    }

    /**
     * Tulostaa kadessa olevat kortit.
     */
    public void tulostaKasi() {
        for (Kortti k : kasi) {
            System.out.println(k);
        }
    }

    /**
     * Palauttaa kadessa olevien korttien lukumaaran.
     * @return korttien määrä
     */
    public int getKorttienMaara() {
        return kasi.size();
    }

    /**
     * Maarittaa onko kaden arvo yli 21.
     * @return true jos on yli 21 muuten false
     */
    public boolean busted() {
        if (getArvo() > 21) {
            return true;
        }
        return false;
    }
    
    /**
     * Palauttaa käden kortit Array listana.
     * @return
     */
    public ArrayList<Kortti> getKortit() {
        return kasi;
    }
}
