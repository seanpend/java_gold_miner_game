package mazerunner.engine;

    // handles the logic of the player entity
public class Player implements Entity
{
    private SimpleVector _position;
    private int _stamina;
    private int _gold;

    //initiates the player
    public Player(SimpleVector position)
    {
        _position = position;
        _stamina = 12;
    }

    // gain 3 stamina when apple is consumed
    public int FeedApple()
    {
        _stamina += 3;
        return _stamina;
    }

    // returns the value of the stamina
    public int GetStamina()
    {
        return _stamina;
    }

    // sets stamina to 0 when player dies to a trap
    public void IsDead() {
        _stamina = 0;
    }

    // handles logic of player being alive when stamina more than 0
    public boolean IsAlive()
    {
        if(_stamina > 0)
        {
            return true;
        }
        else
        {
            return false;

        }
    }

    // returns the position of player
    public SimpleVector GetPosition()
    {
        return _position;
    }

    // moves the player and reduces there stamina
    public SimpleVector MovePlayer(SimpleVector position)
    {
        if(_stamina > 0)
        {
            _position = position;

            _stamina--;
        }

        return _position;
    }

    // returns the gold value of the player
    public int GetGold()
    {
        return _gold;
    }

    // adds gold to the player gold count
    public int AddGold()
    {
        _gold++;
        return _gold;
    }

    // reduces gold from the player gold count
    public int ReduceGold()
    {
        if(_gold >= 0)
        {
            _gold--;
        }

        return _gold;
    }
}


