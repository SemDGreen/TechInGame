package screens;

import utility.Launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EndScreen extends JPanel {

    private BufferedImage menuBackground;
    private final Launcher lf;

    public EndScreen(Launcher lf) {
        this.lf = lf;

        if (this.lf.getGameWorld().p1LifeCheck().getLivesNum() <= 1) {
            try {


                menuBackground = ImageIO.read(this.getClass().getClassLoader().getResource("Winners.png"));
            } catch (IOException e) {
                System.out.println("Error cant read menu background");
                e.printStackTrace();
                System.exit(-3);
            }
        }
        else {
            try {


                menuBackground = ImageIO.read(this.getClass().getClassLoader().getResource("Winners2.png"));
            } catch (IOException e) {
                System.out.println("Error cant read menu background");
                e.printStackTrace();
                System.exit(-3);
            }
        }

        this.setBackground(Color.BLACK);
        this.setLayout(null);

        JButton start = new JButton("Restart Game");
        start.setFont(new Font("Courier New", Font.BOLD, 24));
        start.setBounds(200, 250, 250, 50);
        start.addActionListener((actionEvent -> this.lf.resetGame()));


        JButton exit = new JButton("Exit");
        exit.setFont(new Font("Courier New", Font.BOLD, 24));
        exit.setBounds(200, 350, 250, 50);
        exit.addActionListener((actionEvent -> this.lf.closeGame()));

        this.add(start);
        this.add(exit);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.menuBackground, 0, 0, null);
    }
}
