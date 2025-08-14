package screens;


import gameObjects.Fighter;
import gameObjects.LifeCount;
import gameObjects.Player;
import utility.Launcher;
import utility.GameConstants;
import utility.PlayerControl;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public class GameWorld extends JPanel implements Runnable {

    private BufferedImage world;
    private Fighter p1;
    private Fighter p2;
    private final Launcher lf;
    private BufferedImage background;

    /**
     *
     */
    public GameWorld(Launcher lf) {
        this.lf = lf;
    }




    @Override
    public void run() {
        try {
            while (true) {
                this.p1.update();
                this.p2.update();
                this.repaint();   // redraw game
                /*
                 * Sleep for 1000/144 ms (~6.9ms). This is done to have our 
                 * loop run at a fixed rate per/sec. 
                */
                Thread.sleep(16);

                //ADD A CASE FOR LIVES OVER HERE
            }
        } catch (InterruptedException ignored) {
            System.out.println(ignored);
        }
        lf.setFrame("end");
    }

    /**
     * Reset game to its initial state.
     */
    public void resetGame() {

    }

    /**
     * Load all resources for Tank Wars Game. Set all Game Objects to their
     * initial state as well.
     */
    public void InitializeGame() {

    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(GameConstants.RENDER_HINTS);
        Graphics2D buffer = world.createGraphics();
        buffer.setColor(Color.BLACK);
        buffer.fillRect(0, 0, GameConstants.RES_X_16X9, GameConstants.RES_Y_16X9);
        buffer.drawImage(background, 0, 0, null);
        //this.p1.drawImage(buffer);
        //this.p2.drawImage(buffer);
        buffer.dispose();
        g2.drawImage(world, 0, 0, null);
    }


}
