package WFGE.Screens;

import WFGE.Utilities.Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class EndScreen extends JPanel {

    private BufferedImage background;
    private final Launcher launcher;

    //CONSTRUCTORS
    public EndScreen(Launcher launcher) {
        this.launcher = launcher;

        //MORE CONTENT TO FOLLOW
    }

    //@OVERRIDES
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background, 0, 0, null);
    }
}
