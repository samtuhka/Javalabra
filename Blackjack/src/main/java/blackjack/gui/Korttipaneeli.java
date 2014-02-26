/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.gui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Samuel
 */
public class Korttipaneeli extends JPanel {
    private JPanel korttipaneeli = new JPanel(new GridLayout(4, 1));
    public JPanel pelaajanKortit = new JPanel();
    public JPanel vastustajanKortit = new JPanel();
    private JPanel jakajanPaneeli = new JPanel();
    private JPanel pelaajanPaneeli = new JPanel();

    public Korttipaneeli() {
    }

    public void korttiPaneeli() {
        pelaajanKortit.setBackground(new Color(0, 150, 0));
        vastustajanKortit.setBackground(new Color(0, 150, 0));

        korttipaneeli.setBackground(new Color(0, 150, 0));

        korttipaneeli.add(jakajanPaneeli);
        korttipaneeli.add(vastustajanKortit);

        korttipaneeli.add(pelaajanKortit);
        korttipaneeli.add(pelaajanPaneeli);
    }
}
