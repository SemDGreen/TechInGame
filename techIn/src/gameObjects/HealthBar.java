package gameObjects;

import utility.GameConstants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class HealthBar {

    private BufferedImage currentImage;
    private int x;
    private int y;
    private int health;
    private BufferedImage[] differentHealths = new BufferedImage[9];

    public HealthBar(String player) {
        switch(player) {
            case "player1" -> {

                for (int i = 0; i < differentHealths.length; i++) {
                    int temp = i + 1;
                    try {
                        differentHealths[i] = ImageIO.read(Objects.requireNonNull(HealthBar.class.getClassLoader().getResource(
                                "P1HealthBar_000" + temp + ".png")));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                x = GameConstants.P1_HEALTHBAR_X;
                y = GameConstants.P1_HEALTHBAR_Y;

            }
            case  "player2" -> {

                for (int i = 0; i < differentHealths.length; i++) {
                    int temp = i + 1;
                    try {
                        differentHealths[i] = ImageIO.read(Objects.requireNonNull(HealthBar.class.getClassLoader().getResource(
                                "P2HealthBar_000" + temp + ".png")));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                x = GameConstants.P2_HEALTHBAR_X;
                y = GameConstants.P2_HEALTHBAR_Y;
            }
        }

        this.health = GameConstants.MAX_HEALTH;
        currentImage = differentHealths[0];
    }

    public int takeHealth() {

        health--;
        currentImage = differentHealths[differentHealths.length - 1 - health];
        return getHealth();
    }

    public void resetHealth() {
        setHealth(GameConstants.MAX_HEALTH);
        currentImage = differentHealths[0];
    }

    private int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    public BufferedImage getCurrentImage() {
        return currentImage;
    }

    public int  getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
