package blackjack.domain.pelaaja;

/**
 * Luokka edustaa pelaajaa. Toteuttaa Blackjack pelaaja luokan ominaisuudet.
 * Lisaksi pelaajalla on mm. kassa ja tuplauksen mahdollisuus.
 */
public class Pelaaja extends BlackjackPelaaja {

    private int kassa;

    /**
     * Luo pelaajan, jolla on nimi ja kassa.
     *
     * @param nimi pelaajan nimi
     * @param kassa pelaajan aloituskassan arvo.
     */
    public Pelaaja(String nimi, int kassa) {
        super(nimi);
        this.kassa = kassa;
    }

    /**
     * lisaa pelaajan kassaan valitun arvon.
     *
     * @param arvo valittu arvo.
     */
    public void lisaaKassaan(int arvo) {
        kassa += arvo;
    }

    /**
     * poistaa pelaajan kassasta valitun arvon.
     *
     * @param arvo valittu arvo.
     */
    public void poistaKassasta(int arvo) {
        kassa -= arvo;
    }

    /**
     * maarittaa onko pelaajan varaa jatkaa pelia.
     * @return 
     */
    public boolean vararikko() {
        if (kassa <= 0) {
            return true;
        }
        return false;
    }

    /**
     * Kertoo kuinka paljon pelaajalla on rahaa kassassa.
     * @return 
     */
    public int getKassa() {
        return kassa;
    }

    /**
     * Maarittaa onko pelaajalla varaa panostaa valitun maaran verran.
     *
     * @param panos valittu panos.
     * @return  
     */
    public boolean voiBetata(int panos) {
        if (kassa < panos) {
            return false;
        }
        return true;
    }

    /**
     * Maarittaa voiko pelaaja tuplata. Pelaaja voi tuplata, jos kahden
     * ensimmaisen kortin pistemaara on valilla 9-11 ja hanella on tarpeeksi
     * rahaa.
     *
     * @param panos valittu panos mita yritetaan tuplata.
     * @return  
     */
    public boolean voiTuplata(int panos) {
        if (getKasi().getArvo() >= 9 && getKasi().getArvo() <= 11 && getKasi().getKorttienMaara() == 2 && (kassa >= 2 * panos)) {
            return true;

        }
        return false;
    }
}
