package userinterfaces;

import effects.DataLoader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameFrame extends JFrame {
    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 600;
    GamePanel gamePanel;

    public GameFrame() {
        super("Mega Man");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = this.getToolkit();
        Dimension solution = toolkit.getScreenSize();

        try {
            DataLoader.getInstance().LoadData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.setBounds((solution.width - SCREEN_WIDTH) / 2, (solution.height - SCREEN_HEIGHT) / 2, SCREEN_WIDTH, SCREEN_HEIGHT);
        gamePanel = new GamePanel();
        addKeyListener(gamePanel);
        add(gamePanel);
    }

    public void startGame() {
        gamePanel.startGame();
        this.setVisible(true);
    }
}
