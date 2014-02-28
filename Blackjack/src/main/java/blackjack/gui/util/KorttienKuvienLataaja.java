package blackjack.gui.util;

import blackjack.Main;
import blackjack.domain.Kortti;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Lataa pelikorttien kuvia tiedostoista. Etsii halutun kortin kuvan
 * tiedostopolun.
 */
public class KorttienKuvienLataaja {

    private String kuvaKansionPolku;

    /**
     * Luo laatajan. projektinPolku etsii koko projektin polun. 
     * kuvaKansionPolku on kuvien kansion polku.
     */
    public KorttienKuvienLataaja() {
        this.kuvaKansionPolku = projektinPolku() + "src/main/resources/cards/";
    }

    /**
     * Etsii projektin polun.
     * Tuo Main.class.getResource("").getPath() antaa polun tuonne target kansioon jostain syystä, siksi viimeiset 25 merkkiä on poistettu.
     * En tiedä onko tämä järkevä tapa etsiä tuo projektin polku, mutta näyttää toimivan ainakin itselläni.
     * Jar tiedostolla tämä ei tunnu toimivan ja eikä mikään muukaan mitä olen yrittänyt. 
     * @return kansion polku.
     */
    public String projektinPolku() {
        String projektinPolku = Main.class.getResource("").getPath();
        projektinPolku = new StringBuilder(projektinPolku).reverse().toString().substring(25);
        projektinPolku = new StringBuilder(projektinPolku).reverse().toString();
        return projektinPolku;
    }

    private BufferedImage lataaKuva(String polku) {
        try {
            BufferedImage image = ImageIO.read(new File(polku));
            return image;
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * Palauttaa kortin kuvan.
     * @param kortti
     * @return kuva
     */
    public Image getKuva(Kortti kortti) {
        String polku = haeKortinPolku(kortti);
        return lataaKuva(polku);
    }

    /**
     * Palauttaa kortin kääntöpuolen kuvan.
     * @return kuva
     */
    public Image getKortinTakapuoli() {
        return lataaKuva(kuvaKansionPolku + "b.gif");
    }

    /**
     * Selvittää haetun kortin kuvalle tiedostopolun ja palauttaa sen.
     * @param kortti kortti jonka kuvan polkua etsitään.
     * @return kuvan polku
     */
    public String haeKortinPolku(Kortti kortti) {
        String maa = kortti.getMaa();
        String polku = kuvaKansionPolku;

        if (kortti.getArvo() <= 9 && kortti.getArvo() != 1) {
            polku = polku + kortti.getArvo();
        }
        if (kortti.getArvo() == 10) {
            polku = polku + "t";
        }
        if (kortti.getArvo() == 11) {
            polku = polku + "j";
        }
        if (kortti.getArvo() == 12) {
            polku = polku + "q";
        }
        if (kortti.getArvo() == 13) {
            polku = polku + "k";
        }
        if (kortti.getArvo() == 1) {
            polku = polku + "a";
        }

        if (maa.equals("Risti")) {
            polku = polku + "c.gif";
        }
        if (maa.equals("Hertta")) {
            polku = polku + "h.gif";
        }
        if (maa.equals("Ruutu")) {
            polku = polku + "d.gif";
        }
        if (maa.equals("Pata")) {
            polku = polku + "s.gif";
        }

        return polku;
    }

    /**
     * Palauttaa kuvakansion polun.
     * @return  kuvakansion polku
     */
    public String getPolku() {
        return kuvaKansionPolku;
    }
}
