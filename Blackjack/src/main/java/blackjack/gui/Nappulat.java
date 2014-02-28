package blackjack.gui;

import java.util.ArrayList;
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
    public static final JButton antautumisNappula = new JButton();
    public static final JButton pelaaUudestaanNappula = new JButton();
    public static final JRadioButton panos1 = new JRadioButton("1");
    public static final JRadioButton panos5 = new JRadioButton("5");
    public static final JRadioButton panos10 = new JRadioButton("10");
    public static final JRadioButton panos25 = new JRadioButton("25");
    public static final JRadioButton panos100 = new JRadioButton("100");
    public static final JRadioButton panos200 = new JRadioButton("200");
    public static final ArrayList<JRadioButton> panokset = new ArrayList<JRadioButton>();

    public Nappulat() {
        panokset.add(panos1);
        panokset.add(panos5);
        panokset.add(panos10);
        panokset.add(panos25);
        panokset.add(panos100);
        panokset.add(panos200);
    }
}
