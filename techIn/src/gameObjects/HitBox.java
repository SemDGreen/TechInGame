package gameObjects;

public class HitBox {

    private int x;
    private int y;

    private final int width = 110;
    private final int height = 60;

    private Fighter player;

    public HitBox(Fighter player) {

        this.player = player;
    }

    public void throwBox(int x, int y) {
        this.x = x;
        this.y = y;
        hitBoxCollide(this);
    }

    public void retractBox() {

    }

    public void hitBoxCollide(HitBox hb) {

        this.player.checkHit(this);


    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
