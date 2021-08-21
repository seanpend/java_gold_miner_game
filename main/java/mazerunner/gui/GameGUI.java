package mazerunner.gui;

import mazerunner.engine.GameEngine;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * GUI for the Maze Runner Game.
 *
 * NOTE: Do NOT run this class directly in IntelliJ - run 'RunGame' instead.
 */
public class GameGUI extends Application {
    private GameEngine engine;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("game_gui.fxml").openStream());

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setTitle("Maze Runner Game");
        primaryStage.show();
        engine = new GameEngine();
        engine.init((Controller) fxmlLoader.getController());
    }

    /** In IntelliJ, do NOT run this method.  Run 'RunGame.main()' instead. */
    public static void main(String[] args) {
        launch(args);

    }
}
