package blackjack.domain;

import java.util.ArrayList;
import java.util.Random;

public class Pakka {

    private ArrayList<Kortti> pakka;

    public Pakka() {
        uusiPakka();
        sekoitaPakka();
    }

    public void uusiPakka() {
        pakka = new ArrayList<Kortti>();
        for (int i = 0; i <= 3; i++) {
            for (int j = 1; j <= 13; j++) {
                Kortti uusi = new Kortti(i, j);
                lisaaKortti(uusi);
            }
        }
    }

    public void poistaKortti(Kortti k) {
        if (sisaltaa(k)) {
            pakka.remove(k);
        }
    }
    
    public void lisaaKortti(Kortti k) {
        pakka.add(k);
    }

    public void sekoitaPakka() {
        Random sekoittaja = new Random();
        for (int i = pakka.size() - 1; i > 0; i--) {
            int indeksi = sekoittaja.nextInt(i + 1);

            Kortti vaihdettava = pakka.get(indeksi);
            pakka.set(indeksi, pakka.get(i));
            pakka.set(i, vaihdettava);
        }
    }

    public boolean sisaltaa(Kortti k) {
        if (pakka.contains(k)) {
            return true;
        }
        return false;
    }
    
    public Kortti annaPaallimainen() {
        return pakka.get(0);
    }

    public void tulostaPakka() {
        for (Kortti k : pakka) {
            System.out.println(k);
        }
    }
    
    public int getPakanKoko() {
        return pakka.size();
    }
}
