package WFGE.Screens;

import WFGE.Utilities.Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class InitialScreen extends JPanel {

    private BufferedImage background;
    private final Launcher launcher;
    private String resoltion;

    //CONSTRUCTORS
    public InitialScreen(Launcher launcher) {
        this.launcher = launcher;

        this.setBackground(Color.white);
        this.setLayout(null);

        JButton res720p = new  JButton("720p");

        JButton res1080p = new  JButton("1080p");

        JButton res1440p = new  JButton("1440p");

        JButton res16X9 =  new  JButton("16X9");

        JButton res4K =   new  JButton("4K");

        this.add(res720p);
        this.add(res1080p);
        this.add(res1440p);
        this.add(res16X9);
        this.add(res4K);
        //MORE CONTENT TO FOLLOW
    }

    //GETTERS AND SETTERS
    public String getResolution() {
        return resoltion;
    }
    public void setResolution(String resolution) {
        this.resoltion = resolution;
    }

    //OTHER METHODS

    //@OVERRIDES
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background, 0, 0, null);
    }
}
