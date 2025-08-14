package utility;

import gameObjects.Fighter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FighterControl implements KeyListener {

    //FIELDS
    private final Fighter fighter;
    private int up;
    private int down;
    private int left;
    private int right;
    private int punch;
    private int kick;

    //CONSTRUCTORS
    public FighterControl(Fighter fighter, int up, int down, int left, int right, int punch, int kick) {
        this.fighter = fighter;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.punch = punch;
        this.kick = kick;
    }

    //GETTERS AND SETTERS

    public int getUp() {
        return up;
    }
    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }
    public void setDown(int down) {
        this.down = down;
    }

    public int getLeft() {
        return left;
    }
    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }
    public void setRight(int right) {
        this.right = right;
    }

    public int getPunch() {
        return punch;
    }
    public void setPunch(int punch) {
        this.punch = punch;
    }

    public int getKick() {
        return kick;
    }
    public void setKick(int kick) {
        this.kick = kick;
    }

    //OTHER METHODS
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        //INTENTIONALLY LEFT EMPTY
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyPressed = keyEvent.getKeyCode();
        if (keyPressed == up) {
            this.fighter.pressed(Fighter.Input.UP);
        }
        if (keyPressed == down) {
            this.fighter.pressed(Fighter.Input.DOWN);
        }
        if (keyPressed == left) {
            this.fighter.pressed(Fighter.Input.LEFT);
        }
        if (keyPressed == right) {
            this.fighter.pressed(Fighter.Input.RIGHT);
        }
        if (keyPressed == punch) {
            this.fighter.pressed(Fighter.Input.PUNCH);
        }
        if (keyPressed == kick) {
            this.fighter.pressed(Fighter.Input.KICK);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int keyReleased = keyEvent.getKeyCode();
        if (keyReleased == up) {
            this.fighter.released(Fighter.Input.UP);
        }
        if (keyReleased == down) {
            this.fighter.released(Fighter.Input.DOWN);
        }
        if (keyReleased == left) {
            this.fighter.released(Fighter.Input.LEFT);
        }
        if (keyReleased == right) {
            this.fighter.released(Fighter.Input.RIGHT);
        }
        if (keyReleased == punch) {
            this.fighter.released(Fighter.Input.PUNCH);
        }
        if (keyReleased == kick) {
            this.fighter.released(Fighter.Input.KICK);
        }
    }
}
