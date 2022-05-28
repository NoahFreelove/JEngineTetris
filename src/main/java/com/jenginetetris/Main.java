package com.jenginetetris;

import com.JEngine.Core.Identity;
import com.JEngine.Core.Position.Vector3;
import com.JEngine.Game.Visual.GameCamera;
import com.JEngine.Game.Visual.GameWindow;
import com.JEngine.Game.Visual.Scenes.SceneManager;
import com.JEngine.Utility.About.GameInfo;
import com.JEngine.Utility.Misc.GameUtility;
import com.jenginetetris.Game.Tetris;
import com.jenginetetris.Game.TetrisType;
import com.jenginetetris.Scenes.GameManager;
import com.jenginetetris.Scenes.MainMenu;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static MainMenu mainMenu = new MainMenu();
    public static GameManager gameScene = new GameManager();
    public static Stage stage;
    static Tetris specialT;

    @Override
    public void start(Stage stage) {
        Main.stage = stage;
        GameInfo.setAppName("JEngine Tetris");
        GameInfo.setAuthors(new String[]{"Noah Freelove"});
        GameInfo.setAppVersionMajor(0);
        GameInfo.setAppVersionMinor(1);

        GameWindow win = new GameWindow(mainMenu, 1f, GameInfo.getAppName(), stage);
        new GameCamera(Vector3.emptyVector(), win, mainMenu, null, new Identity("MainCamera"));
        win.setBackgroundColor(Color.BLACK);

        // add key press event
        stage.addEventHandler(javafx.scene.input.KeyEvent.KEY_PRESSED, (e) -> {
            if (e.getCode() == javafx.scene.input.KeyCode.ESCAPE) {
                GameUtility.exitApp();
            }

            /*if(e.getCode() == KeyCode.SPACE)
            {
                specialT = new Tetris(TetrisType.SQUARE, 5,0);
                gameScene.addTetris(specialT);
            }*/
            if(e.getCode() == KeyCode.F1)
            {
                GameManager.printASCII();
            }
            if(e.getCode() == KeyCode.F2)
            {
                System.out.println(specialT.requestMove(0,1));
            }
        });
        stage.setWidth(GameManager.blockSize*GameManager.width + GameManager.borderLength*2);
    }

    public static void startGame(){
        SceneManager.switchScene(gameScene);
        gameScene.StartGame();
        gameScene.addTetris(new Tetris(4, 0));
        /*gameScene.addTetris(new Tetris(TetrisType.STRAIGHT, 4, 7));
        gameScene.addTetris(new Tetris(TetrisType.STRAIGHT, 4, 10));
        gameScene.addTetris(new Tetris(TetrisType.STRAIGHT, 0, 5));
        gameScene.addTetris(new Tetris(TetrisType.STRAIGHT, 0, 7));
        gameScene.addTetris(new Tetris(TetrisType.STRAIGHT, 0, 10));*/
    }

    public static void main(String[] args) {
        launch();
    }
}