package mazerunner.engine;

    // The trap object in the maze
public class Trap extends WorldObject implements Interactable
{
    public Trap(SimpleVector position)
    {
        super("Trap", position);
    }

    // handles when a player hits a trap in the maze
    @Override
    public void TriggerInteraction(GameController gameController)
    {

        gameController.GetPlayer().ReduceGold();
        int checkGold = gameController.GetPlayer().GetGold();
        if(checkGold < 0) {
            gameController.GetPlayer().IsDead();


        }


        System.out.println("Player collides with " + GetObjectType());


    }
}
