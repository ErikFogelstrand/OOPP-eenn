import View.GamePanel;
import Model.World.GameSceneCreator;
import Model.World.GameSceneManager;

import javax.swing.*;
import Model.Player.Player;


public class Application implements Runnable {

    private Thread gameThread;

    private static final int FPS = 60;

    private final GamePanel gamePanel; // Declare gamePanel as a class member to share it between methods
    private final Controller controller;

    public Application(GamePanel gamePanel) {
        this.gamePanel = gamePanel; // Pass the shared gamePanel instance
        controller = new Controller(gamePanel, Player.getInstance());
        gamePanel.addKeyListener(controller);
        gamePanel.setFocusable(true);
    }

    private void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {

        double drawInterval = 1_000_000_000 / FPS; // 1 second in nano/60 = 0.016666
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){

            update();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        gamePanel.updatePaint();
        Player.getInstance().updateInventory();
    }


    public static void main(String []args){

        JFrame window = new JFrame();   // Creating instance of JFrame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Animal Farm :-D");

        GameSceneManager.getInstance().addGameScene("Main", GameSceneCreator.createGameScene(16, 12));
        GameSceneManager.getInstance().switchActiveGameScene("Main");

        GamePanel gamePanel = new GamePanel(Player.getInstance(), Player.getInstance(), Player.getInstance());

        window.add(gamePanel);

        //window.setSize(1000, 400);
        window.pack(); //adjust the window to be sized to fit with the game size
        window.setLocationRelativeTo(null);
        window.setVisible(true);// making the frame visible

        Application app = new Application(gamePanel);
        app.startGameThread();

    }
}

