package mazerunner.engine;

import mazerunner.gui.Controller;

    // The main class which is the engine of the game
public class GameEngine
{
    public static void main(String[] args) {

        var gameController = new GameController();

        while (gameController._terminator)
        {
            gameController.ProcessGame();
        }
    }
    
    public void init(Controller controller){
        var gameController = new GameController();
        gameController.setController(controller);
        
        while (gameController._terminator)
        {
            gameController.ProcessGame();
        }
    }
}
