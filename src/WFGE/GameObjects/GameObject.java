package WFGE.GameObjects;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public abstract class GameObject {

    private int x;
    private int y;
    private HashMap<String, BufferedImage[]> animations;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addAnimation(String key, BufferedImage[] animation) {
        animations.put(key, animation);
    }
}
