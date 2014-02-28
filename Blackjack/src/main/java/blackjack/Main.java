
package blackjack;

import blackjack.gui.Kayttoliittyma;

/**
 * Peli käynnistetään täältä.
 */
public class Main {
    

    public static void main(String[] args) {
       
        Kayttoliittyma ui = new Kayttoliittyma();
        ui.run();
    }
}

