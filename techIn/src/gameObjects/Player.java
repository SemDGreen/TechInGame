package gameObjects;

import utility.GameConstants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Objects;

public class Player {
    private static final float FIGHTER_DIST_FROM_EDGE_Y_LEFT = 5;
    private static final float FIGHTER_DIST_FROM_EDGE_Y_RIGHT = 210;
    private static final float FIGHTER_DIST_FROM_EDGE_X = 385;

    public enum Input {UP, DOWN, LEFT, RIGHT, PUNCH, KICK}
    private final EnumSet<Input> keysPressed = EnumSet.noneOf(Input.class);

    private float x;
    private float y;
    private float vx;
    private float vy;

    private float angle;
    private float R = 1;
    private float ROTATIONSPEED = 3.0f;

    private long time;
    private boolean hitLag;

    private BufferedImage img;

    private boolean jumping;
    private boolean crouching;
    private boolean moving; //TO STOP FROM ATTACKING AS FAST AS ONE CAN PRESS THE BUTTON
    private boolean kicking;

    private HealthBar healthBar;
    private LifeCount lifeCount;

    private String player;

    private HitBox hitBox;
    private Player otherPlayer;


    Player(float x, float y, float vx, float vy, float angle, BufferedImage img, String player, Player otherPlayer) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.img = img;
        this.angle = angle;
        this.player = player;
        this.healthBar = new HealthBar(player);
        this.lifeCount = new LifeCount();
        this.hitBox = new HitBox(this);
        this.otherPlayer = otherPlayer;
    }

    Player(float x, float y, float vx, float vy, float angle, BufferedImage img, String player) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.img = img;
        this.angle = angle;
        this.player = player;
        this.healthBar = new HealthBar(player);
        this.lifeCount = new LifeCount();
        this.hitBox = new HitBox(this);
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    void setX(float x){ this.x = x; }

    void setY(float y) { this. y = y;}

   public void pressed(Input dir) {
        keysPressed.add(dir);
    }

    public void released(Input dir) {
        keysPressed.remove(dir);
    }

    void update() {

        checkHit();

        this.timeCheck();

        if (this.keysPressed.contains(Input.UP) && !jumping) {
            this.startJump();
        }

        if (this.keysPressed.contains(Input.DOWN)) {
            this.crouch();
        }

        if (this.keysPressed.contains(Input.LEFT)) {
            this.moveLeft();
        }
        if (this.keysPressed.contains(Input.RIGHT)) {
            this.moveRight();
        }
        if (this.keysPressed.contains(Input.PUNCH)) {
            this.punch();
        }
        if (this.keysPressed.contains(Input.KICK)) {
            this.kick();
        }

        if (this.jumping) {
            this.jump();
        }

        /*if (this.y <= GameConstants.GAME_SCREEN_HEIGHT - FIGHTER_DIST_FROM_EDGE_Y) {
            this.vy += GameConstants.GRAV;
        }*/
    }


    private void kick() {

        this.moving = true;

        this.kicking = true;
        if ("player1".equals(player)) {

            if (this.jumping) {

                return;
            }

            if (this.crouching) {

                try {
                    this.img = ImageIO.read(Player.class.getClassLoader().getResource("LeftDuckKick_0003.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                if (!otherPlayer.getJumping()) {
                    this.hitBox.throwBox((int) this.x + 128, (int) this.y + 150);
                }

                return;
            }

            try {
                this.img = ImageIO.read(Player.class.getClassLoader().getResource("LeftStandingKick_0005.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (!otherPlayer.getJumping()) {
                this.hitBox.throwBox((int) this.x + 128, (int) this.y + 150);
            }

        }

        if ("player2".equals(player)) {

            if (this.jumping) {

                return;
            }

            if (this.crouching) {

                try {
                    this.img = ImageIO.read(Player.class.getClassLoader().getResource("RightDuckKick_0003.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                if (!otherPlayer.getJumping()) {
                    this.hitBox.throwBox((int) this.x - 10, (int) this.y + 150);
                }

                return;
            }

            try {
                this.img = ImageIO.read(Player.class.getClassLoader().getResource("RightStandingKick_0005.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (!otherPlayer.getJumping()) {
                this.hitBox.throwBox((int) this.x - 10, (int) this.y + 150);
            }

        }

    }

    private void punch() {

        this.moving = true;

        if ("player1".equals(player)) {

            if (this.jumping) {

                try {
                    this.img = ImageIO.read(Objects.requireNonNull(Player.class.getClassLoader().getResource("LeftJumpPunch_0002.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                if (!otherPlayer.getCrouching()) {
                    this.hitBox.throwBox((int) this.x + 148, (int) this.y + 90);
                }

                return;
            }

            if (this.crouching) {

                try {
                    this.img = ImageIO.read(Player.class.getClassLoader().getResource("LeftDuckPunch_0002.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                if (!otherPlayer.getJumping()) {
                    this.hitBox.throwBox((int) this.x + 148, (int) this.y + 60);
                }
                return;
            }

            try {
                this.img = ImageIO.read(Player.class.getClassLoader().getResource("LeftStandingPunch_0003.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (!otherPlayer.getCrouching()) {
                this.hitBox.throwBox((int) this.x + 148, (int) this.y + 90);
            }

        }

        if ("player2".equals(player)) {

            if (this.jumping) {

                try {
                    this.img = ImageIO.read(Objects.requireNonNull(Player.class.getClassLoader().getResource("RightJumpPunch_0002.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                if (!otherPlayer.getCrouching()) {
                    this.hitBox.throwBox((int) this.x - 10, (int) this.y + 65);
                }

                return;
            }

            if (this.crouching) {

                try {
                    this.img = ImageIO.read(Player.class.getClassLoader().getResource("RightDuckPunch_0002.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                if (!otherPlayer.getJumping()) {
                    this.hitBox.throwBox((int) this.x - 10, (int) this.y + 65);
                }
                return;
            }

            try {
                this.img = ImageIO.read(Player.class.getClassLoader().getResource("RightStandingPunch_0003.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (!otherPlayer.getCrouching()) {
                this.hitBox.throwBox((int) this.x - 10, (int) this.y + 65);
            }

        }

    }

    private void moveLeft() {
        if (crouching) {
            return;
        }
        this.vx = 3;
        this.x -= vx;
        checkHit();
    }

    private void moveRight() {
        if (crouching) {
            return;
        }
        this.vx = 3;
        this.x += vx;
        checkHit();
    }

    private void crouch() {

        if ("player1".equals(player)) {
            try {
                this.img = ImageIO.read(Player.class.getClassLoader().getResource("LeftDuckIdle.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            this.vx = 0;
            if (!jumping) {
                this.vy = 0;
            }
        }

        if  ("player2".equals(player)) {
            try {
                this.img = ImageIO.read(Player.class.getClassLoader().getResource("RightDuckIdle.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            this.vx = 0;
            if (!jumping) {
                this.vy = 0;
            }
        }

        this.y = 615;

        this.crouching = true;
        checkHit();
    }

    private void startJump() {
        if (this.jumping) return;

        this.vy = -10.0f; // negative = up

        this.jumping = true;
    }


    private void jump() {
        if (!this.jumping) return;

        if ("player1".equals(player) && !this.moving) {

            try {
                this.img = ImageIO.read(Player.class.getClassLoader().getResource("LeftJumpIdle_0003.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if  ("player2".equals(player) && !this.moving) {

            try {
                this.img = ImageIO.read(Player.class.getClassLoader().getResource("RightJumpIdle_0003.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        this.y += this.vy;
        this.vy += GameConstants.GRAVITY;

        if (this.y >= GameConstants.GAME_SCREEN_HEIGHT - FIGHTER_DIST_FROM_EDGE_X) {
            this.y = GameConstants.GAME_SCREEN_HEIGHT - FIGHTER_DIST_FROM_EDGE_X;
            this.vy = GameConstants.GRAVITY;
            this.vx = 0;
            this.jumping = false;
            this.stand();
        }

        checkHit();
    }

    private boolean getCrouching() {
        return this.crouching;
    }

    private void checkHit() {
        if (this.x < FIGHTER_DIST_FROM_EDGE_Y_LEFT) {
            this.x = FIGHTER_DIST_FROM_EDGE_Y_LEFT;
        }
        if (this.x >= GameConstants.GAME_SCREEN_WIDTH - FIGHTER_DIST_FROM_EDGE_Y_RIGHT) {
            this.x = GameConstants.GAME_SCREEN_WIDTH - FIGHTER_DIST_FROM_EDGE_Y_RIGHT;
        }
        if (this.y < 30) {
            this.y = 30;
        }
        if (this.y >= GameConstants.GAME_SCREEN_HEIGHT - FIGHTER_DIST_FROM_EDGE_X && !this.crouching) {
            this.y = GameConstants.GAME_SCREEN_HEIGHT - FIGHTER_DIST_FROM_EDGE_X;
        }
        if (this.y >= GameConstants.GAME_SCREEN_HEIGHT - FIGHTER_DIST_FROM_EDGE_X && this.crouching || this.kicking) {
            this.y = GameConstants.GAME_SCREEN_HEIGHT - FIGHTER_DIST_FROM_EDGE_X + 70;
            if (this.kicking) {
                this.y -= 23;
            }
        }
    }

    public void checkHit(HitBox hb) {

        /*if (hb.getX() + hb.getWidth() > otherPlayer.getX()) {
            if (otherPlayer.getY() <= hb.getY() && otherPlayer.getY() >=  hb.getY()) {
                otherPlayer.getLifeCount().takeLife();
            }
        }*/
        if ("player1".equals(player)) {
            if (hb.getX() + hb.getWidth() >= otherPlayer.getX()) {
                if (otherPlayer.getLifeCount().getLivesNum() > 0 && !otherPlayer.getHitLag()) {
                    otherPlayer.setHitLag(true);
                    otherPlayer.setTime();
                    if (otherPlayer.takeHealth() == 0) {
                        otherPlayer.healthBar.resetHealth();
                        otherPlayer.getLifeCount().takeLife();
                    }
                    //otherPlayer.getLifeCount().takeLife();
                }
            }
        }
        if ("player2".equals(player)) {
            if (hb.getX() - hb.getWidth() <= otherPlayer.getX() + 140) {
                if (otherPlayer.getLifeCount().getLivesNum() > 0 && !otherPlayer.getHitLag()) {
                    otherPlayer.setHitLag(true);
                    otherPlayer.setTime();
                    if (otherPlayer.takeHealth() == 0) {
                        otherPlayer.healthBar.resetHealth();
                        otherPlayer.getLifeCount().takeLife();
                    }
                    //otherPlayer.getLifeCount().takeLife();
                }
            }
        }


        /*if (otherPlayer.getLifeCount().takeLife() == 0) {


        }*/

    }

    private void setTime() {
        this.time = System.currentTimeMillis();
    }

    public float getY() {
        return this.y;
    }

    void drawImage(Graphics g) {

        AffineTransform rotation = AffineTransform.getTranslateInstance(this.x, this.y);
        rotation.rotate(Math.toRadians(this.angle), this.img.getWidth() / 2.0, this.img.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.img, rotation, null);
        drawHealth(g);
        drawLives(g);
    }

    void drawHealth(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.healthBar.getCurrentImage(), this.healthBar.getX(), this.healthBar.getY(), null);
    }

    void drawLives(Graphics g) {
        BufferedImage[] temp = this.lifeCount.getLives();
        Graphics2D g2d = (Graphics2D) g;
        if ("player1".equals(this.player)) {
            for (int i = 0; i < GameConstants.MAX_LIVES; i++) {
                g2d.drawImage(temp[i], GameConstants.P1_LIFE_X + (i * 69), GameConstants.P1_LIFE_Y, null);
            }
        }
        if ("player2".equals(this.player)) {
            for (int i = 0; i < GameConstants.MAX_LIVES; i++) {
                g2d.drawImage(temp[i], GameConstants.GAME_SCREEN_WIDTH - (GameConstants.P1_LIFE_X + (i * 69)) - 79, GameConstants.P1_LIFE_Y, null);
            }
        }

        //g2d.fillRect(this.hitBox.getX(), this.hitBox.getY(), this.hitBox.getWidth(), this.hitBox.getHeight());
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public void setCrouching(boolean crouching) {
        this.crouching = crouching;
    }

    public void setImage(BufferedImage img) {
        this.img = img;
    }

    public float getX() {
        return this.x;
    }

    public void collisionCheck(Player toCheck) {
        if ("player1".equals(this.player)) {
            if ((this.x + 184) >= toCheck.getX()) {
                this.x = toCheck.getX() - 185;
            }
        }

        if ("player2".equals(this.player)) {
            if ((this.x - 184) <= toCheck.getX()) {
                this.x = this.x + 2;
            }
        }
    }

    public void stand() {
        if ("player1".equals(this.player)) {
            try {
                this.img = ImageIO.read(Player.class.getClassLoader().getResource("LeftStandIdle_0001.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if ("player2".equals(this.player)) {
            try {
                this.img = ImageIO.read(Player.class.getClassLoader().getResource("RightStandIdle_0001.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        hitBox.retractBox();
        this.moving = false;
        this.crouching = false;
        this.kicking = false;
    }

    public boolean getJumping() {
        return this.jumping;
    }

    public LifeCount getLifeCount() {
        return this.lifeCount;
    }

    private void timeCheck() {
        if ((System.currentTimeMillis() - (long) 3000) > this.time ) {
            this.hitLag = false;
        }
    }

    public boolean getHitLag() {
        return this.hitLag;
    }

    public void setHitLag(boolean hitLag) {
        this.hitLag = hitLag;
    }

    public int takeHealth() {
        return this.healthBar.takeHealth();
    }

}
