package blackjack.gui;

import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 * Vastaa nappuloista joita pelaaja voi painella.
 */
public class Nappulat {
    public static final JButton otaKorttiNappula = new JButton();
    public static final JButton jaaKortitNappula = new JButton();
    public static final JButton jaamisNappula = new JButton();
    public static final JButton tuplausNappula = new JButton();
    public static final JButton pelaaUudestaanNappula = new JButton();
    public static final JRadioButton panos100 = new JRadioButton("100");
    public static final JRadioButton panos200 = new JRadioButton("200");
    public static final JRadioButton panos300 = new JRadioButton("300");
    public static final JRadioButton panos400 = new JRadioButton("400");

    public Nappulat() {
    }
}
