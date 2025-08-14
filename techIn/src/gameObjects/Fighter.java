package gameObjects;

import java.util.EnumSet;

public class Fighter extends GameObject {

    //FIELDS
    private boolean jumping;
    private boolean crouching;

    private int playerNumber;

    public enum Input {UP, DOWN, LEFT, RIGHT, PUNCH, KICK}
    private EnumSet<Input> inputs = EnumSet.noneOf(Input.class);

    //CONSTRUCTORS
    public Fighter(int x, int y, int playerNumber) {
        super(x, y);
        this.playerNumber = playerNumber;
    }

    //GETTERS AND SETTERS
    public boolean getJumping() {
        return jumping;
    }
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public boolean getCrouching() {
        return crouching;
    }
    public void setCrouching(boolean crouching) {
        this.crouching = crouching;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    //OTHER METHODS
    public void pressed(Input key) {
        inputs.add(key);
    }

    public void released(Input key) {
        inputs.remove(key);
    }

    public void update() {
        if (this.inputs.contains(Input.UP)) {
            this.jump();
        }

        if (this.inputs.contains(Input.DOWN)) {
            this.crouch();
        }

        if (this.inputs.contains(Input.LEFT)) {
            this.moveLeft();
        }

        if (this.inputs.contains(Input.RIGHT)) {
            this.moveRight();
        }

        if (this.inputs.contains(Input.PUNCH)) {
            this.punch();
        }

        if (this.inputs.contains(Input.KICK)) {
            this.kick();
        }
    }

    private void jump() {
        this.setJumping(true);
    }

    private void crouch() {
        this.setCrouching(true);
    }

    private void moveLeft() {

    }

    private void moveRight() {

    }

    private void punch() {

    }

    private void kick() {

    }

    private void checkIdleCollision() {

    }

}
