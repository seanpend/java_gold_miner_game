package mazerunner.engine;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mazerunner.gui.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;

        // This renders the maze and prints it to the console and the GUI
public class WorldRenderer
{
        // this prints the game to the GUI
    public static void PrintWorldToGui(Cell[][] world, Player player, Controller _controller,
                                       Image playerImage, Image goldImage, Image appleImage,
                                       Image trapImage, Image exitImage, Image terrainImage)
    {
        //Clear render space
        //Holding and restoring child 0 here to maintain the grid/system children.
        var node = _controller.gameGridPane.getChildren().get(0);
        _controller.gameGridPane.getChildren().clear();
        _controller.gameGridPane.getChildren().add(0,node);

        var tileWidth = 60;
        var tileHeight = 70;

        for(int y = 0; y < world.length; ++y) {
            for (int x = 0; x < world[y].length; ++x) {
                if (x == player.GetPosition()._x && y == player.GetPosition()._y)
                {
                    ImageView playerImageView = new ImageView();
                    playerImageView.setFitWidth(tileWidth);
                    playerImageView.setFitHeight(tileHeight);
                    playerImageView.setImage(playerImage);

                    _controller.gameGridPane.add(playerImageView, x, y);
                }
                else if (world[y][x] == null || world[y][x]._child == null || !world[y][x]._child.IsAlive())
                {

                    ImageView defaultImageView = new ImageView();
                    defaultImageView.setFitWidth(tileWidth);
                    defaultImageView.setFitHeight(tileHeight);
                    defaultImageView.setImage(terrainImage);

                    _controller.gameGridPane.add(defaultImageView, x, y);
                }
                else
                {
                    if (world[y][x]._child.GetObjectType() == "Gold") {

                        ImageView goldImageView = new ImageView();
                        goldImageView.setFitWidth(tileWidth);
                        goldImageView.setFitHeight(tileHeight);
                        goldImageView.setImage(goldImage);

                        _controller.gameGridPane.add(goldImageView, x, y);
                    } else if (world[y][x]._child.GetObjectType() == "Trap") {
                        ImageView trapImageView = new ImageView();
                        trapImageView.setFitWidth(tileWidth);
                        trapImageView.setFitHeight(tileHeight);
                        trapImageView.setImage(trapImage);

                        _controller.gameGridPane.add(trapImageView, x, y);
                    } else if (world[y][x]._child.GetObjectType() == "Apple") {
                        ImageView appleImageView = new ImageView();
                        appleImageView.setFitWidth(tileWidth);
                        appleImageView.setFitHeight(tileHeight);
                        appleImageView.setImage(appleImage);

                        _controller.gameGridPane.add(appleImageView, x, y);
                    } else if (world[y][x]._child.GetObjectType() == "Exit") {
                        ImageView exitImageView = new ImageView();
                        exitImageView.setFitWidth(tileWidth);
                        exitImageView.setFitHeight(tileHeight);
                        exitImageView.setImage(exitImage);

                        _controller.gameGridPane.add(exitImageView, x, y);
                    }
                }
            }
        }
    }

        // this prints the game to the console
    public static void PrintWorldToConsole(Cell[][] world, Player player)
    {
        for(int y = 0; y < world.length; ++y)
        {
            for(int x = 0; x < world[y].length; ++x)
            {
                if(x == player.GetPosition()._x && y == player.GetPosition()._y)
                {
                    System.out.print("P" + " ");
                }
                else if(world[y][x] == null || world[y][x]._child == null || !world[y][x]._child.IsAlive())
                {
                    System.out.print("_" + " ");
                }
                else
                {
                    if(world[y][x]._child.GetObjectType() == "Gold")
                    {
                        System.out.print("G" + " ");
                    }
                    else if(world[y][x]._child.GetObjectType() == "Trap")
                    {
                        System.out.print("T" + " ");
                    }
                    else if(world[y][x]._child.GetObjectType() == "Apple")
                    {
                        System.out.print("A" + " ");
                    }
                    else if (world[y][x]._child.GetObjectType() == "Exit") {
                        System.out.print("E" + " ");
                    }
                }
            }

            System.out.println();
        }
    }
}
