package mazerunner.engine;

public class Cell
{
    // The empty blank cells in the maze
    WorldObject _child;

    public Cell() { }

    public Cell( WorldObject child )
    {
        _child = child;
    }

    public WorldObject GetChild()
    {
        return _child;
    }
}
