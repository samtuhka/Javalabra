package blackjack.gui.util;

import blackjack.domain.Kortti;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Lataa pelikorttien kuvia tiedostoista.
 * Etsii halutun kortin kuvan tiedostopolun.
 */
public class KorttienKuvienLataaja {
    private String kuvaKansionPolku;


    /**
     * Luo laatajan.
     * projektinPolku etsii koko projektin polun. 
     * kuvaKansionPolku on kuvien kansion polku.
     * En tiedä onko tämä järkevä tapa etsiä tuo projektin polku, mutta näyttää toimivan ainakin itselläni. 
     */
    public KorttienKuvienLataaja() {
        String projektinPolku = new File("").getAbsolutePath();
        this.kuvaKansionPolku = projektinPolku + "/res/cards/";
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
     * @return
     */
    public Image getKuva(Kortti kortti) {
        String polku = haeKortinPolku(kortti);
        return lataaKuva(polku);
    }
    
    /**
     * Palauttaa kortin kääntöpuolen kuvan.
     * @return
     */
    public Image getKortinTakapuoli() {
        return lataaKuva(kuvaKansionPolku + "b.gif");
    }
    

    /**
     * Selvittää haetun kortin kuvalle tiedostopolun ja palauttaa sen.
     * @param kortti kortti jonka kuvan polkua etsitään.
     * @return
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
    
}
