package WFGE.Screens;

import WFGE.Utilities.Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MapSelectScreen extends JPanel {

    private BufferedImage background;
    private final Launcher launcher;

    //CONSTRUCTORS
    public MapSelectScreen(Launcher launcher) {
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
