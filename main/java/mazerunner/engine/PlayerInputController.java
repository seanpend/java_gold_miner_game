package mazerunner.engine;

import java.util.Scanner;

public class PlayerInputController
{
    private Scanner _scanner;
    private Player _playerReference;
    private Map _mapReference;
    private Configuration _configReference;
    private GameController _gameControllerReference;

    public PlayerInputController(GameController gameController, Player player, Map map, Configuration configuration)
    {
        _scanner = new Scanner(System.in);
        _playerReference = player;
        _mapReference = map;
        _configReference = configuration;
        _gameControllerReference = gameController;
    }

    // displays game rules when user clicks help button in GUI
    public void ShowRules() {
        System.out.println("Mazerunner Rules: \n - Use The directional buttons to move the player! \n - Avoid Traps, you will lose 1 gold coin \n - Gather gold coins" +
                "and try to reach the exit before you run out of stamina \n - Apples give you +3 Stamina \n - Have fun! ");
    }
    // starts a game
    public void StartGame(int difficulty )
    {
        _gameControllerReference.StartGame(difficulty);
    }

    // awaits movement input from the user to move the player
    public void AwaitInput()
    {
        int command = _scanner.nextInt();

        if (command == _configReference.down) {
            UpdatePlayerPosition(0,1);
        } else if (command == _configReference.right) {
            UpdatePlayerPosition(1,0);
        } else if (command == _configReference.up) {
            UpdatePlayerPosition(0,-1);
        } else if (command == _configReference.left) {
            UpdatePlayerPosition(-1,0);
        }
    }

    // updates the players position on the maze after moving
    public void UpdatePlayerPosition(int x, int y)
    {
        var currentPosition = _playerReference.GetPosition();
        var proposedPosition = new SimpleVector(currentPosition._x + x, currentPosition._y + y);

        var mapBounds = _mapReference.GetBounds();

        //Check if movement would exceed bound of map
        if(proposedPosition._x >= 0 && proposedPosition._x < mapBounds._x)
        {
            if(proposedPosition._y >= 0 && proposedPosition._y < mapBounds._y)
            {
                _playerReference.MovePlayer(new SimpleVector(currentPosition._x + x, currentPosition._y + y));
            }
        }
    }
}
