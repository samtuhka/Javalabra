package blackjack.domain;

import java.util.ArrayList;
import java.util.Random;

/**
 * Luokka vastaa korttipakasta.
 */
public class Pakka {

    private ArrayList<Kortti> pakka;

    /**
     * Luo pakan.
     */
    public Pakka() {
        uusiPakka();
        sekoitaPakka();
    }

    /**
     * Lisaa pakkaan 52 korttia.
     */
    public void uusiPakka() {
        pakka = new ArrayList<Kortti>();
        for (Maat m: Maat.values()) {
            for (int j = 1; j <= 13; j++) {
                Kortti uusi = new Kortti(m, j);
                lisaaKortti(uusi);
            }
        }
    }

    /**
     * Poistaa valitun kortin pakasta
     * @param k valittu kortti
     */
    public void poistaKortti(Kortti k) {
        if (sisaltaa(k)) {
            pakka.remove(k);
        }
    }
    
    /**
     * Lisaa valitun kortin pakkaan.
     * @param k valittu kortti.
     */
    public void lisaaKortti(Kortti k) {
        pakka.add(k);
    }

    /**
     * Sekoittaa pakan.
     */
    public void sekoitaPakka() {
        Random sekoittaja = new Random();
        for (int i = pakka.size() - 1; i > 0; i--) {
            int indeksi = sekoittaja.nextInt(i + 1);

            Kortti vaihdettava = pakka.get(indeksi);
            pakka.set(indeksi, pakka.get(i));
            pakka.set(i, vaihdettava);
        }
    }

    /**
     * Maarittaa sisaltaako pakka valitun kortin.
     * @param kortti valittu kortti
     * @return true jos sisältää kortin
     */
    public boolean sisaltaa(Kortti kortti) {
        if (pakka.contains(kortti)) {
            return true;
        }
        return false;
    }
    
    /**
     * Palauttaa pakan ensimmaisen kortin.
     * @return päällimmäinen kortti
     */
    public Kortti annaPaallimainen() {
        return pakka.get(0);
    }

    /**
     * Tulostaa pakassa olevat kortit.
     */
    public void tulostaPakka() {
        for (Kortti k : pakka) {
            System.out.println(k);
        }
    }
    
    /**
     * Palauttaa pakassa olevien korttien lukumaaran.
     * @return pakan korttien määrä.
     */
    public int getPakanKoko() {
        return pakka.size();
    }
}
