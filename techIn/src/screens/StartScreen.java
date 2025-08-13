package screens;

import utility.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class StartScreen extends JPanel {

    private BufferedImage menuBackground;
    private final Launcher lf;

    public StartScreen(Launcher lf) {
        this.lf = lf;
        try {

            menuBackground = ImageIO.read(this.getClass().getClassLoader().getResource("TechInTitleScreen.png"));
        } catch (IOException e) {
            System.out.println("Error cant read menu background");
            e.printStackTrace();
            System.exit(-3);
        }
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        JButton start = new JButton("Start");
        start.setFont(new Font("Courier New", Font.BOLD, 24));
        start.setBounds(245, 250, 150, 50);
        start.addActionListener(actionEvent -> this.switchMusic());

        JButton exit = new JButton("Exit");
        exit.setSize(new Dimension(200, 100));
        exit.setFont(new Font("Courier New", Font.BOLD, 24));
        exit.setBounds(245, 350, 150, 50);
        exit.addActionListener((actionEvent -> this.lf.closeGame()));

        this.add(start);
        this.add(exit);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.menuBackground, 0, 0, null);
    }

    private void switchMusic() {
        if (SoundHandler.getClip() != null) {
            SoundHandler.getClip().stop();
        }
        SoundHandler.playSound(GameConstants.fightThemeName);
        this.lf.setFrame("gameObjects");
    }
}
