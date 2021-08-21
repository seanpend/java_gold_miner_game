package mazerunner.engine;

import mazerunner.gui.Controller;

import java.awt.*;

// Renders the UI to the console and the GUI
public class UIRenderer
{
    public static void PrintUIToConsole(Player player, Configuration configuration)
    {
        System.out.println("Stamina:" + player.GetStamina() + " Gold:" + player.GetGold());
        System.out.println("UP:" + configuration.up + " DOWN:" + configuration.down + " LEFT:" + configuration.left + " RIGHT:" + configuration.right);
    }
    public static void PrintUIToGUI(Player player, Controller controller)
    {
        controller.displayStats.setText("Stamina:" + player.GetStamina() + " Gold:" + player.GetGold());

    }
    public static void PrintHelp(Player player, Controller controller){
        System.out.println("Rules of game: ");
    }
}
