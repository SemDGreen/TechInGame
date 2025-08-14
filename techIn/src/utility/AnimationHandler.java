package utility;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationHandler {

    //LOADER FUNCTION FOR ANIMATIONS THAT TAKES HASHMAPS OR ARRAYS AND FILLS
    //THEM WITH THE CORRECT ANIMATIONS

    private static AnimationHandler singleton;

    public AnimationHandler() {

    }

    public static AnimationHandler getSingleton() {
        if  (singleton == null) {
            singleton = new AnimationHandler();
        }
        return singleton;
    }

    public void drawImage(Graphics g, BufferedImage image, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x, y, null);
    }
}
