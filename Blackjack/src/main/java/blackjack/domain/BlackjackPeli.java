package blackjack.domain;

import blackjack.domain.pelaaja.Pelaaja;

public class BlackjackPeli {

    private BlackjackKierros kierros;
    private Pelaaja pelaaja;
    private int seuraavaPanos;

    public BlackjackPeli(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.kierros = new BlackjackKierros(pelaaja, 100);
        this.seuraavaPanos = 100;
    }

    public void setKierros(BlackjackKierros kierros) {
        this.kierros = kierros;
    }

    public BlackjackKierros getKierros() {
        return kierros;
    }

    public void setSeuraavaPanos(int panos) {
        this.seuraavaPanos = panos;
    }

    public int getSeuraavaPanos() {
        return seuraavaPanos;
    }
    
}
