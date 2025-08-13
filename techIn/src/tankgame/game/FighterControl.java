package tankgame.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class FighterControl implements KeyListener {
    private final Fighter fighter;
    private int up;
    private int down;
    private int right;
    private int left;
    private int punch;
    private int kick;

    public FighterControl(Fighter fighter, int up, int down, int left, int right, int punch, int kick) {
        this.fighter = fighter;
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
        this.punch = punch;
        this.kick = kick;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int keyPressed = ke.getKeyCode();
        if (keyPressed == up)
            this.fighter.pressed(Fighter.Input.UP);
        if (keyPressed == down)
            if (!this.fighter.getJumping())
                this.fighter.pressed(Fighter.Input.DOWN);
        if (keyPressed == left)
            this.fighter.pressed(Fighter.Input.LEFT);
        if (keyPressed == right)
            this.fighter.pressed(Fighter.Input.RIGHT);
        if (keyPressed == punch)
            this.fighter.pressed(Fighter.Input.PUNCH);
        if (keyPressed == kick)
            this.fighter.pressed(Fighter.Input.KICK);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int keyReleased = ke.getKeyCode();
        if (keyReleased == up) {
            this.fighter.released(Fighter.Input.UP);
            //this.fighter.setJumping(false);
        }
        if (keyReleased == down) {
            this.fighter.released(Fighter.Input.DOWN);
            //this.fighter.setCrouching(false);
            this.fighter.stand();
        }
        if (keyReleased == left)
            this.fighter.released(Fighter.Input.LEFT);
        if (keyReleased == right)
            this.fighter.released(Fighter.Input.RIGHT);
        if (keyReleased == punch) {
            this.fighter.released(Fighter.Input.PUNCH);
            this.fighter.stand();
        }
        if (keyReleased == kick) {
            this.fighter.released(Fighter.Input.KICK);
            this.fighter.stand();
        }
    }
}
