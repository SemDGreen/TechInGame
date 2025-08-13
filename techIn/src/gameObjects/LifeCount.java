package gameObjects;

import GameConstants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class LifeCount {

    private BufferedImage[] lifeStatus = new BufferedImage[3];
    private BufferedImage hasLife;
    private BufferedImage noLife;
    private int lives;

    public LifeCount() {

        try {
            hasLife = ImageIO.read(Objects.requireNonNull(LifeCount.class.getClassLoader().getResource("Stock_0001.png")));
            noLife = ImageIO.read(Objects.requireNonNull(LifeCount.class.getClassLoader().getResource("Stock_0002.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Arrays.fill(lifeStatus, hasLife);

        lives = GameConstants.MAX_LIVES;
    }

    public BufferedImage[] getLives() {
        return  lifeStatus;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int takeLife() {
        if (lives == 0) {
            return lives;
        }
        lifeStatus[lives - 1] = noLife;
        lives--;
        return lives;
    }

    public void resetLives() {
        lives = GameConstants.MAX_LIVES;
        Arrays.fill(lifeStatus, hasLife);
    }

    public int getLivesNum() {
        return lives;
    }
}
