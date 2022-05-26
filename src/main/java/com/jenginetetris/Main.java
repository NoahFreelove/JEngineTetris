package com.jenginetetris;

import com.JEngine.Core.Identity;
import com.JEngine.Core.Position.Vector3;
import com.JEngine.Game.Visual.GameCamera;
import com.JEngine.Game.Visual.GameWindow;
import com.JEngine.Utility.About.GameInfo;
import com.jenginetetris.Scenes.MainMenu;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static MainMenu mainMenu = new MainMenu();
    @Override
    public void start(Stage stage) {
        GameInfo.setAppName("JEngine Tetris");
        GameInfo.setAuthors(new String[]{"Noah Freelove"});
        GameInfo.setAppVersionMajor(0);
        GameInfo.setAppVersionMinor(1);

        GameWindow win = new GameWindow(mainMenu, 1f, GameInfo.getAppName(), stage);
        new GameCamera(Vector3.emptyVector(), win, mainMenu, null, new Identity("MainCamera"));
        win.setBackgroundColor(Color.BLACK);

    }

    public static void startGame(){

    }



    public static void main(String[] args) {
        launch();
    }
}