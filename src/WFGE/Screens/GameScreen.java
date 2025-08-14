package WFGE.Screens;

import WFGE.GameObjects.Fighter;
import WFGE.Utilities.Launcher;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GameScreen extends JPanel implements Runnable {

    private BufferedImage background;
    private Fighter player1;
    private Fighter player2;
    private final Launcher launcher;

    public GameScreen(Launcher launcher) {
        this.launcher = launcher;
    }

    public void InitGame() {

    }

    //@OVERRIDES
    @Override
    public void run() {

    }
}
