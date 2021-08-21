package mazerunner.engine;

    // The gold object in the maze
public class Gold extends WorldObject implements Interactable
{
    public Gold(SimpleVector position) {
        super("Gold", position);
    }

    // When a player hits a gold object in the maze
    @Override
    public void TriggerInteraction(GameController gameController)
    {
        _alive = false;

        gameController.GetPlayer().AddGold();
    }
}
