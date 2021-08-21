package mazerunner.engine;

    // The apple object in the maze
public class Apple extends WorldObject implements Interactable
{
    public Apple(SimpleVector position) {
        super("Apple", position);
    }

    // When a player hits an apple in the maze
    @Override
    public void TriggerInteraction(GameController gameController)
    {
        _alive = false;

        gameController.GetPlayer().FeedApple();
    }
}
