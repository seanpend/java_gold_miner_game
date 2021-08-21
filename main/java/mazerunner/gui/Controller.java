package mazerunner.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import mazerunner.engine.PlayerInputController;

    // This is the controller class that handles the GUI fxml elements linking to the game engine logic
public class Controller {

    private PlayerInputController _playerInputController;
    private Object _loopKey;
    @FXML TextField difficultyTextField;    

    public Controller (){

    }  
    public void setLoopKey(Object loopKey){
        _loopKey = loopKey;
    }


    public void setPlayerInputController(PlayerInputController playerInputController ){
        _playerInputController = playerInputController;
    }

    @FXML
    public GridPane gameGridPane;

    @FXML
    public TextArea displayStats;


    @FXML
    public void moveUp(){
        _playerInputController.UpdatePlayerPosition(0,-1);
        Platform.exitNestedEventLoop(_loopKey, null);
    }

    @FXML
    public void moveDown(){
        _playerInputController.UpdatePlayerPosition(0,1);
        Platform.exitNestedEventLoop(_loopKey, null);
    }

    @FXML
    public void moveLeft(){
        _playerInputController.UpdatePlayerPosition(-1,0);
        Platform.exitNestedEventLoop(_loopKey, null);
    }

    @FXML
    public void moveRight(){
        _playerInputController.UpdatePlayerPosition(1,0);
        Platform.exitNestedEventLoop(_loopKey, null);
    }

    @FXML
    public void startGameAction(){


        if (isDifficultyAnInteger()){
            _playerInputController.StartGame(Integer.parseInt(difficultyTextField.getText()));
        } else {
            _playerInputController.StartGame(5);
        }
        Platform.exitNestedEventLoop(_loopKey, null);
    }

    private boolean isDifficultyAnInteger(){
        if (difficultyTextField == null){
            return false;
        }
        try {
            Integer.parseInt(difficultyTextField.getText());
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    @FXML
    public void showHelp(){
        _playerInputController.ShowRules();
    }


}
