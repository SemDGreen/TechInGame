package WFGE.Utilities;

import WFGE.Screens.*;
import WFGE.Utilities.*;
import javax.swing.*;
import java.awt.*;


public class Launcher {

    //FIELDS
    private JPanel mainScreen;
    private GameScreen gameScreen;
    private final JFrame frame;
    private CardLayout cardLayout;

    //CONSTRUCTORS
    public Launcher(){
        this.frame = new JFrame("WFGE");

        //we want to close the game when the GUI is closed
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //MAIN

    public static void main(String[] args) {

        //CALL LOADER TO LOAD ALL THE SHII
        Loader.loadMain();

        (new Launcher()).initGUI();
    }

    public void initGUI() {
        this.mainScreen = new JPanel();

        JPanel startPanel = new InitialScreen(this);

        this.gameScreen = new GameScreen(this);
        this.gameScreen.InitGame();

        JPanel customPanel = new CustomizationScreen(this);

        JPanel mapScreen = new MapSelectScreen(this);

        JPanel endPanel = new EndScreen(this);

        cardLayout = new CardLayout();
        this.mainScreen.setLayout(cardLayout);
        this.mainScreen.add(startPanel, "Start");
        this.mainScreen.add(gameScreen, "Game");
        this.mainScreen.add(endPanel, "End");
    }


}
