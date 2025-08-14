package gameObjects;

//PACKAGE IMPORTS
import utility.AnimationHandler;
//LIBRARY IMPORTS
import java.awt.image.BufferedImage;
import java.util.Map;

public abstract class GameObject {

    private int x;
    private int y;

    private AnimationHandler animationHandler;
    private Map<String, BufferedImage[]> animations;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        this.animationHandler = AnimationHandler.getSingleton();
    }
}
