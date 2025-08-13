package utility;

import gameObjects.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class PlayerControl implements KeyListener {
    private final Player player;
    private int up;
    private int down;
    private int right;
    private int left;
    private int punch;
    private int kick;

    public PlayerControl(Player player, int up, int down, int left, int right, int punch, int kick) {
        this.player = player;
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
            this.player.pressed(Player.Input.UP);
        if (keyPressed == down)
            if (!this.player.getJumping())
                this.player.pressed(Player.Input.DOWN);
        if (keyPressed == left)
            this.player.pressed(Player.Input.LEFT);
        if (keyPressed == right)
            this.player.pressed(Player.Input.RIGHT);
        if (keyPressed == punch)
            this.player.pressed(Player.Input.PUNCH);
        if (keyPressed == kick)
            this.player.pressed(Player.Input.KICK);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int keyReleased = ke.getKeyCode();
        if (keyReleased == up) {
            this.player.released(Player.Input.UP);
            //this.fighter.setJumping(false);
        }
        if (keyReleased == down) {
            this.player.released(Player.Input.DOWN);
            //this.fighter.setCrouching(false);
            this.player.stand();
        }
        if (keyReleased == left)
            this.player.released(Player.Input.LEFT);
        if (keyReleased == right)
            this.player.released(Player.Input.RIGHT);
        if (keyReleased == punch) {
            this.player.released(Player.Input.PUNCH);
            this.player.stand();
        }
        if (keyReleased == kick) {
            this.player.released(Player.Input.KICK);
            this.player.stand();
        }
    }
}
