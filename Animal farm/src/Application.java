import javax.swing.*;


public class Application implements Runnable {


    Thread gameThread;

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
        while(gameThread != null){
            //System.out.println("starting ...... lets play guys! the game i running");

            update();
            gamePanel.updatePaint();
        }
    }

    public void update(){
    }


    public static void main(String []args){

        JFrame window = new JFrame();   // Creating instance of JFrame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Animal Farm :-D");

        GamePanel gamePanel = new GamePanel();
        Controller Controller = new Controller();



        window.add(gamePanel);

        //window.setSize(1000, 400);
        window.pack(); //adjust the window to be sized to fit with the game size
        window.setLocationRelativeTo(null);
        window.setVisible(true);// making the frame visible

        Application app = new Application(gamePanel);
        app.startGameThread();

    }

}

