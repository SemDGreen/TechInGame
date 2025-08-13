package gameObjects;

import utility.AnimationHandler;

public abstract class GameObject {

    private int x;
    private int y;

    private AnimationHandler animationHandler;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        this.animationHandler = AnimationHandler.getSingleton();
    }
}
