package mazerunner.engine;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mazerunner.gui.Controller;

public class GameController
{
    private Player _player;
    private Map _map;
    private PlayerInputController _playerInputController;
    private Controller _controller;
    private CollisionController _collisionController;
    private Configuration _configuration;
    private final Object loopKey = new Object();
    private int difficulty = 5;
    public boolean _terminator;

    public GameController()
    {
        _configuration = new Configuration();
        _terminator = true;
    }

    public void setController(Controller controller){
        _controller = controller;
        _controller.setLoopKey(loopKey);
    }

    // Displays the score when a game has finished
private void ShowScore(){
    if (_player == null){
        return ;
    }
    if (_player.GetStamina()== 0 && _player.GetGold() > 0){
        System.out.println("Final Score: " + _player.GetGold());
    } else if (_player.GetStamina() == 0 && _player.GetGold() <= 0){
        System.out.println("Final Score: -1");
    } else {
        System.out.println("Final score: " + _player.GetGold());
    }
}

    // Handles the logic of processing a new game
    public void ProcessGame()
    {
        if(IsActive())
        {   
            if (_controller == null){
                _playerInputController.AwaitInput();
            } else {
                Platform.enterNestedEventLoop(loopKey);
            }            
            _collisionController.CollisionCheck(this);
        }
        else
        {
            ShowScore();
            StartGame(difficulty);
        }

        RenderGame();
    }


    // returns player position
    public Player GetPlayer()
    {
        return _player;
    }

    // handles logic of whether an item is active or not on the board
    private boolean IsActive()
    {
        if(_player != null && _player.IsAlive())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Starts a new game
    public void StartGame(int difficulty)
    {
        System.out.println("Starting Game");
        _player = new Player(new SimpleVector(0,9));
        if (_controller == null){
            _map = new Map(10, 10);
            _playerInputController = new PlayerInputController(this, _player, _map, _configuration);
        } else {
            _map = new Map(10, 10, difficulty);            
            _playerInputController = new PlayerInputController(this, _player, _map, _configuration);
            _controller.setPlayerInputController(_playerInputController);
        }
        _collisionController = new CollisionController(_player, _map); //_gameController
        System.out.println("Started Game:"+ difficulty);
    }

    // Renders the generation of the maze and objects
    private void RenderGame()
    {
        WorldRenderer.PrintWorldToConsole(_map.GetCells(), _player);
        UIRenderer.PrintUIToConsole(_player, _configuration);
        if (_controller != null) {

            var playerImage = new Image(getClass().getClassLoader().getResourceAsStream("player.png"));
            var goldImage = new Image(getClass().getClassLoader().getResourceAsStream("gold coin.png"));
            var appleImage = new Image(getClass().getClassLoader().getResourceAsStream("apple.png"));
            var trapImage = new Image(getClass().getClassLoader().getResourceAsStream("trap.png"));
            var exitImage = new Image(getClass().getClassLoader().getResourceAsStream("exit.png"));
            var terrainImage = new Image(getClass().getClassLoader().getResourceAsStream("maze terrain.jpg"));

            WorldRenderer.PrintWorldToGui(_map.GetCells(), _player, _controller, playerImage, goldImage, appleImage, trapImage, exitImage, terrainImage);
            UIRenderer.PrintUIToGUI(_player, _controller);
        }
    }

    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }
}
