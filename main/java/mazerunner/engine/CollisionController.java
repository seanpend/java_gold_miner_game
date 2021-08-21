package mazerunner.engine;

public class CollisionController
{
    private Player _playerReference;
    private Map _mapReference;
//    private GameController _gameControllerReference;

    public CollisionController(Player player, Map map) //GameController gameController
    {
        _playerReference = player;
        _mapReference = map;
        //_gameControllerReference = gameController;
    }

    // Handles the logic of when player interacts with an item on the board
    public void CollisionCheck(GameController gameController)
    {
        var currentPosition = _playerReference.GetPosition();
        var mapCell = _mapReference._mapCells[currentPosition._y][currentPosition._x];

        var cellChild = mapCell.GetChild();

        if(cellChild != null && cellChild.IsAlive())
        {
            if(cellChild.GetObjectType() == "Gold")
            {
                var gold = (Gold)cellChild;

                gold.TriggerInteraction(gameController);
            }
            else if(cellChild.GetObjectType() == "Apple")
            {
                var gold = (Apple)cellChild;

                gold.TriggerInteraction(gameController);
            }
            else if(cellChild.GetObjectType() == "Trap")
            {
                var gold = (Trap)cellChild;

                gold.TriggerInteraction(gameController);
            }
            else if(cellChild.GetObjectType() == "Exit")
            {
                var gold = (Exit)cellChild;
                _playerReference.IsDead();
                gold.TriggerInteraction(gameController);
            }
        }
    }
}
