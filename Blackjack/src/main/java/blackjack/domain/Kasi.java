package blackjack.domain;

import java.util.ArrayList;

public class Kasi {

    private ArrayList<Kortti> kasi;

    public Kasi() {
        this.kasi = new ArrayList<>();
    }

    public void lisaaKortti(Kortti kortti) {
        kasi.add(kortti);
    }

    public void otaPakastaKortti(Pakka pakka) {
        Kortti k = pakka.annaPaallimainen();
        lisaaKortti(k);
        pakka.poistaKortti(k);
    }

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

    public boolean onBlackjack() {
        if (kasi.size() == 2 && getArvo() == 21) {
            return true;
        }
        return false;
    }

    public boolean busted() {
        if (getArvo() > 21) {
            return true;
        }
        return false;
    }

    public void tulostaKasi() {
        for (Kortti k : kasi) {
            System.out.println(k);
        }
    }
    
    public int getKorttienMaara() {
        return kasi.size();
    }
}
