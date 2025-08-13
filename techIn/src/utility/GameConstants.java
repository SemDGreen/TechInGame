package utility;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GameConstants {

    public static final Map<Object,Object> RENDER_HINTS =  new HashMap<>(){{
        put(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }};

    public static final int GAME_SCREEN_WIDTH = 1024;
    public static final int GAME_SCREEN_HEIGHT = 960;

    public static final int OTHER_MENU_SCREEN_WIDTH = 640;
    public static final int OTHER_MENU_SCREEN_HEIGHT = 480;

    public static final float GRAVITY = 1F;

    public static final int MAX_HEALTH = 8;
    public static final int MIN_HEALTH = 0;

    public static final int MAX_LIVES = 3;
    public static final int MIN_LIVES = 0;

    public static final String menuThemeName = "techinMenuThemeMusic.wav";
    public static final String fightThemeName = "techinFightThemeMusic.wav";
}
