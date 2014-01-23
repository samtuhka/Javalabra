package blackjack.domain;

public class Kortti {
    
    public static String[] Maat = {"Risti", "Ruutu", "Hertta", "Pata"};
    public static String[] Arvot = {"-", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private int arvo;
    private int maa;

    public Kortti(int maa, int arvo) {
        this.arvo = arvo;
        this.maa = maa;
    }

    public int getArvo() {
        return arvo;
    }
    
    public int getPisteArvo() {
        if (arvo==1) {
            return 1;
        }     
        else if (arvo>10) {
            return 10;
        }
        else {
            return arvo;
        }
    }

    public int getMaa() {
        return maa;
    }

    @Override
    public String toString() {
        return Maat[maa]+" "+Arvot[arvo];
    }
}
