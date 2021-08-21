package mazerunner.engine;
import java.util.*;

    // Handles logic to do with the generation of the maze
public class Map
{
    Cell[][] _mapCells;
    int maxHeight;
    int maxWidth;
    Integer _difficulty;

    // The dimensions of the maze
    public Map(int width, int height)
    {
        _mapCells = new Cell[height][width];
        maxHeight = height;
        maxWidth = width;
        GenerateMap(_mapCells);
    }

    // The dimensions and difficulty of the maze
    public Map(int width, int height, int difficulty)
    {
        _mapCells = new Cell[height][width];
        maxHeight = height;
        maxWidth = width;
        _difficulty = difficulty;
        GenerateMap(_mapCells);    
        
    }

    // returns the bounds of the map
    public SimpleVector GetBounds()
    {
        return new SimpleVector(_mapCells[0].length, _mapCells.length);
    }

    // returns the cells of the maze
    public Cell[][] GetCells()
    {
        return _mapCells;
    
    }


    // generates the map
    public void GenerateMap(Cell[][] mapCells)
    {
        // handles the difficulty of the maze
        int difficulty = 5; //default difficulty to 5

        System.out.println("Enter a difficulty from 1 - 10: ");
        if (_difficulty != null){
            difficulty = _difficulty;
        } else { 
            Scanner _scan = new Scanner(System.in);
            difficulty = _scan.nextInt();
        }
        


        // initialise everything to empty cell
        for(int y = 0; y < maxHeight; y++)
        {
            for(int x = 0; x < maxWidth; x++)
            {
                _mapCells[y][x] = new Cell();
            }
        }

        Random r = new Random();

        // generate 5 coins
        for (int i=0; i<5; i++){
            setRandomCell(r, "Gold");
        }

        // generate an exit
        setRandomCell(r, "Exit");

        // generate traps
        int numOfTraps = difficulty;
        for (int i=0; i<numOfTraps; i++){
            setRandomCell(r, "Trap");
        }

        // generate Apples
        int numOfApples = Math.max(0, 10 - difficulty);
        for (int i=0; i<numOfApples; i++){
            setRandomCell(r, "Apple");
        }
    }

    private void setRandomCell(Random r, String type) {

        // generate random values until we find an empty Cell
        int randomX = r.nextInt(maxWidth);
        int randomY = r.nextInt(maxHeight);
        while ((_mapCells[randomY][randomX].GetChild() != null) || (randomX == 0 && randomY == maxHeight-1)) {
            randomX = r.nextInt(maxWidth);
            randomY = r.nextInt(maxHeight);
        }

        SimpleVector vector = new SimpleVector(randomX, randomY);

        // set the cell to the type
        if (type.equals("Gold")) {
            _mapCells[randomY][randomX] = new Cell(new Gold(vector));

        } else if (type.equals("Exit")) {
            _mapCells[randomY][randomX] = new Cell(new Exit(vector));

        } else if (type.equals("Trap")) {
            _mapCells[randomY][randomX] = new Cell(new Trap(vector));

        } else if (type.equals("Apple")) {
            _mapCells[randomY][randomX] = new Cell(new Apple(vector));

        }

    }}