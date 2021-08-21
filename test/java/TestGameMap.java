import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import mazerunner.engine.Cell;
import mazerunner.engine.Map;
import mazerunner.engine.Player;
import mazerunner.engine.SimpleVector;
import mazerunner.engine.WorldRenderer;

public class TestGameMap {
    static InputStream sysInBackup;
    static int difficulty = 10;

    @BeforeAll
    static void init(){
        sysInBackup = System.in; // backup System.in to restore it later
        // sets difficulty - easier than doing it through the terminal while testing
        ByteArrayInputStream in = new ByteArrayInputStream(String.valueOf(difficulty).getBytes());
        System.setIn(in);

    }

    @AfterAll
    static void teardown(){
        // reset System.in to Original
        System.setIn(sysInBackup);
    }

    @Test
    void testGetMap() {
        int maxWidth = 10;
        int maxHeight = 10;

        Map map = new Map(maxWidth, maxHeight);
        Cell[][] cells = map.GetCells();

        // counter inits
        int goldCount = 0;
        int exitCount = 0;
        int trapCount = 0;
        int appleCount = 0;

        // find all elements in Map
        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < maxHeight; y++) {
                if (cells[x][y].GetChild() != null) {
                    if (cells[x][y].GetChild().GetObjectType().equals("Gold")) {
                        goldCount++;
                    }
                    if (cells[x][y].GetChild().GetObjectType().equals("Exit")) {
                        exitCount++;
                    }
                    if (cells[x][y].GetChild().GetObjectType().equals("Trap")) {
                        trapCount++;
                    }
                    if (cells[x][y].GetChild().GetObjectType().equals("Apple")) {
                        appleCount++;
                    }
                }
            }
        }
        assertEquals(5, goldCount);
        assertEquals(1, exitCount);

        int expectedNumOfTraps = difficulty; // same as difficulty
        assertEquals(expectedNumOfTraps, trapCount);

        int expectedApples = 10-difficulty; // 10 - difficulty, at least one.
        assertEquals(expectedApples, appleCount);

        Player p = new Player(new SimpleVector(0,0));
        WorldRenderer.PrintWorldToConsole(cells, p);
    }

}