package mazerunner.engine;

    // handles the logic of the entity's in the world
public class WorldObject implements Entity
{
    public SimpleVector _position;
    private String _worldObjectType;
    protected boolean _alive;

    public WorldObject( String worldObjectType, SimpleVector position)
    {
        _worldObjectType = worldObjectType;
        _position = position;
        _alive = true;
    }

    // returns the type of object
    public String GetObjectType()
    {
        return _worldObjectType;
    }

    // returns whether the object is persisting
    @Override
    public boolean IsAlive() {
        return _alive;
    }

    // returns the position
    @Override
    public SimpleVector GetPosition() {
        return _position;
    }
}
