package mazerunner.engine;

    // The exit cell in the maze
public class Exit extends WorldObject implements Interactable
{
    public Exit(SimpleVector position) {
        super("Exit", position);
    }

    // when the player reaches the exit cell in the maze
    @Override
    public void TriggerInteraction(GameController gameController)
    {

        _alive = false;
        gameController._terminator = true;
        System.out.println("You have escaped the maze!");

    }
}
