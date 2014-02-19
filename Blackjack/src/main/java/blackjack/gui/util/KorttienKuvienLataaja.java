package blackjack.gui.util;

import blackjack.domain.Kortti;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class KorttienKuvienLataaja {


    public KorttienKuvienLataaja() {

    }

    private BufferedImage lataaKuva(String polku) {
        try {
            BufferedImage image = ImageIO.read(new File(polku));
            return image;
        } catch (IOException ex) {
            return null;
        }
    }

    public Image getKuva(Kortti kortti) {
        String polku = haeKortinPolku(kortti);
        return lataaKuva(polku);
    }
    
    public Image getKortinTakapuoli() {
        return lataaKuva("res/cards/b.gif");
    }
    

    public String haeKortinPolku(Kortti kortti) {
        String maa = kortti.getMaa();

        String polku = "res/cards/";

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
