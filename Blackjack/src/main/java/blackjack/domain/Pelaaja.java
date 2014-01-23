package blackjack.domain;

public class Pelaaja {

    private Kasi kasi;
    private String nimi;
    private int kassa;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.kasi = new Kasi();
        this.kassa = 0;
    }

    public void lisaaKassaan(int arvo) {
        kassa += arvo;
    }

    public void poistaKassasta(int arvo) {
        kassa -= arvo;
    }

    public boolean vararikko() {
        if (kassa <= 0) {
            return true;
        }
        return false;
    }

    public String getNimi() {
        return nimi;
    }
}
