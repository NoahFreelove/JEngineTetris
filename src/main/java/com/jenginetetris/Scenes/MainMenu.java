package com.jenginetetris.Scenes;

import com.JEngine.Core.Position.Vector2;
import com.JEngine.Game.Visual.Scenes.GameScene;
import com.jenginetetris.Main;
import com.jenginetetris.UI.MenuButton;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;

public class MainMenu extends GameScene {
    public MainMenu() {
        super("Main Menu");
        addObjects();
    }

    private void addObjects(){
        Text text = new Text("Tetris");
        Stop[] stops = new Stop[] {
                new Stop(0, Color.RED),
                new Stop(.2, Color.ORANGE),
                new Stop(.4, Color.YELLOW),
                new Stop(.6, Color.GREEN),
                new Stop(.8, Color.BLUE),
                new Stop(1, Color.INDIGO),
        };
        LinearGradient gradient =
                new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

        text.setFill(gradient);
        text.setScaleX(5);
        text.setScaleY(5);
        text.setStyle("-fx-font-weight: bold;");
        text.setX(250);
        text.setY(100);
        addUI(text);

        addUI(new MenuButton(new Vector2(210, 200), 1, "Play", Color.CYAN, Color.WHITE, event -> Main.startGame()));


    }
}
