import World.GameScene;

import javax.swing.*;



public class Application implements Runnable {

    Thread gameThread;

    int FPS = 60;

    GamePanel gamePanel; // Declare gamePanel as a class member to share it between methods

    public Application(GamePanel gamePanel) {
        this.gamePanel = gamePanel; // Pass the shared gamePanel instance
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {

        double drawInterval = 1_000_000_000 / FPS; // 1 second in nano/60 = 0.016666
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){

            //System.out.println("starting ...... lets play guys! the game i running");

            update();

            gamePanel.updatePaint();

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
    }


    public static void main(String []args){

        JFrame window = new JFrame();   // Creating instance of JFrame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Animal Farm :-D");

        Player player = new Player();
        Controller Controller = new Controller();
        GamePanel gamePanel = new GamePanel(player);



        window.add(gamePanel);

        //window.setSize(1000, 400);
        window.pack(); //adjust the window to be sized to fit with the game size
        window.setLocationRelativeTo(null);
        window.setVisible(true);// making the frame visible

        Application app = new Application(gamePanel);
        app.startGameThread();

    }
}

