package utility;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GameConstants {

    public static final Map<Object,Object> RENDER_HINTS =  new HashMap<>(){{
        put(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }};

    //MAGIC NUMBERS
    public static final int MAX_HEALTH = 8;
    public static final int MIN_HEALTH = 0;

    public static final int MAX_LIVES = 3;
    public static final int MIN_LIVES = 0;

    public static final int RES_X_720P = 1280;
    public static final int RES_Y_720P = 720;

    public static final int RES_X_16X9 = 1600;
    public static final int RES_Y_16X9 = 900;

    public static final int RES_X_1080P = 1920;
    public static final int RES_Y_1080P = 1080;

    public static final int RES_X_1440P = 2560;
    public static final int RES_Y_1440P = 1440;

    public static final int RES_X_4K = 3840;
    public static final int RES_Y_4K = 2160;

    //public static final int FIGHTER_MIN_DIST_FROM_FLOOR;
    //public static final int FIGHTER_MIN_DIST_FROM_WALL;

    public static final int GRAVITY = 1;

    //RESOURCE SHORTCUTS
    public static final String menuThemeName = "techinMenuThemeMusic.wav";
    public static final String fightThemeName = "techinFightThemeMusic.wav";

    public static final String LEFT_STAND_SC = "LeftStand";
    public static final String RIGHT_STAND_SC = "RightStand";

    public static final String LEFT_CROUCH_SC = "LeftCrouch";
    public static final String RIGHT_CROUCH_SC = "RightCrouch";

    public static final String LEFT_JUMP_SC = "LeftJump";
    public static final String RIGHT_JUMP_SC = "RightJump";
}
