package gameObjects;


import utility.Launcher;
import utility.GameConstants;
import utility.SoundHandler;

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
                this.p1.collisionCheck(p2);
                this.p2.update();
                this.p2.collisionCheck(p1);
                this.repaint();   // redraw game
                /*
                 * Sleep for 1000/144 ms (~6.9ms). This is done to have our 
                 * loop run at a fixed rate per/sec. 
                */
                Thread.sleep(16);
                if (p1.getLifeCount().getLivesNum() == 0 || p2.getLifeCount().getLivesNum() == 0) {
                    break;
                }
            }
        } catch (InterruptedException ignored) {
            System.out.println(ignored);
        }
        SoundHandler.stopSound();
        SoundHandler.playSound(GameConstants.menuThemeName);
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
        try {
            this.world = ImageIO.read(GameWorld.class.getClassLoader().getResource("MountainDojoMapArt.png"));
            this.background = ImageIO.read(GameWorld.class.getClassLoader().getResource("MountainDojoMapArt.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BufferedImage p1Img = null;
        try {
            /*
             * note class loaders read files from the out folder (build folder in Netbeans) and not the
             * current working directory. When running a jar, class loaders will read from within the jar.
             */
            p1Img = ImageIO.read(
                    Objects.requireNonNull(GameWorld.class.getClassLoader().getResource("LeftStandIdle_0001.png"),
                    "Could not find tank1.png")
            );
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        p1 = new Fighter(50, GameConstants.PLAYER_STARTING_Y, 0, 0, (short) 0, p1Img, "player1");
        this.lf.getJf().addKeyListener(
            new FighterControl(p1, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_C, KeyEvent.VK_V)
        );

        BufferedImage p2Img = null;
        try {
            /*
             * note class loaders read files from the out folder (build folder in Netbeans) and not the
             * current working directory. When running a jar, class loaders will read from within the jar.
             */
            p2Img = ImageIO.read(
                    Objects.requireNonNull(GameWorld.class.getClassLoader().getResource("RightStandIdle_0001.png"),
                            "Could not find tank1.png")
            );
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        p2 = new Fighter(GameConstants.GAME_SCREEN_WIDTH - 265, GameConstants.PLAYER_STARTING_Y, 0, 0, (short) 0, p2Img, "player2", p1);
        this.lf.getJf().addKeyListener(
                new FighterControl(p2, KeyEvent.VK_O, KeyEvent.VK_L, KeyEvent.VK_K, KeyEvent.VK_SEMICOLON, KeyEvent.VK_PERIOD, KeyEvent.VK_SLASH)
        );
        p1.setOtherPlayer(p2);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(GameConstants.RENDER_HINTS);
        Graphics2D buffer = world.createGraphics();
        buffer.setColor(Color.BLACK);
        buffer.fillRect(0, 0, GameConstants.GAME_SCREEN_WIDTH, GameConstants.GAME_SCREEN_HEIGHT);
        buffer.drawImage(background, 0, 0, null);
        this.p1.drawImage(buffer);
        this.p2.drawImage(buffer);
        buffer.dispose();
        g2.drawImage(world, 0, 0, null);
    }

    public LifeCount p1LifeCheck() {
        return p1.getLifeCount();
    }


}
