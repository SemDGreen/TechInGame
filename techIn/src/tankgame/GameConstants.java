package tankgame;

import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;

public class GameConstants {
    public static final int GAME_SCREEN_WIDTH = 1024;
    public static final int GAME_SCREEN_HEIGHT = 960;

    public static final int OTHER_MENU_SCREEN_WIDTH = 640;
    public static final int OTHER_MENU_SCREEN_HEIGHT = 480;

    /*public static final int END_MENU_SCREEN_WIDTH = 500;
    public static final int END_MENU_SCREEN_HEIGHT = 500;*/
    
    public static final Map<Object,Object> RENDER_HINTS =  new HashMap<>(){{
        put(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }};

    public static final float GRAV = 1F;

    public static final int MAX_HEALTH = 8;
    public static final int MIN_HEALTH = 0;

    public static final int PLAYER_STARTING_Y = 575;

    public static final int MAX_LIVES = 3;
    public static final int MIN_LIVES = 0;

    public static final int P1_HEALTHBAR_X = 5;
    public static final int P1_HEALTHBAR_Y = 5;

    public static final int P2_HEALTHBAR_X = GAME_SCREEN_WIDTH - 420;
    public static final int P2_HEALTHBAR_Y = 5;

    public static final int P1_LIFE_X = 5;
    public static final int P1_LIFE_Y = 66;

    public static final String menuThemeName = "techinMenuThemeMusic.wav";
    public static final String fightThemeName = "techinFightThemeMusic.wav";
}
