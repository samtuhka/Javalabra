package blackjack.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Ei tee yhtään mitään viellä. 
 *
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    /**
     *
     */
    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Blackjack");
        frame.setPreferredSize(new Dimension(700, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
    }

    /**
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }
}