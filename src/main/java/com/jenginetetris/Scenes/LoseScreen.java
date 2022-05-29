package com.jenginetetris.Scenes;

import com.JEngine.Core.Position.Vector2;
import com.JEngine.Game.Visual.Scenes.GameScene;
import com.jenginetetris.Main;
import com.jenginetetris.UI.MenuButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class LoseScreen extends GameScene {

    public LoseScreen() {
        super("Lose Screen");
        Text loseText = new Text("You Lose!");
        loseText.setTranslateX(250);
        loseText.setTranslateY(50);
        loseText.setFill(Color.WHITE);
        loseText.setScaleX(3);
        loseText.setScaleY(3);
        addUI(loseText);

        Text scoreText = new Text("Score: " + GameManager.score);
        scoreText.setTranslateX(250);
        scoreText.setTranslateY(100);
        scoreText.setFill(Color.WHITE);
        scoreText.setScaleX(2);
        scoreText.setScaleY(2);
        addUI(scoreText);
        addUI(new MenuButton(new Vector2(210, 200), 1, "Re-Play", Color.DARKGRAY, Color.WHITE, event -> {
            Main.startGame();
        }));

        Text highScoreText = new Text("High Score: " + processScores());
        highScoreText.setTranslateX(250);
        highScoreText.setTranslateY(400);
        highScoreText.setFill(Color.WHITE);
        highScoreText.setScaleX(2);
        highScoreText.setScaleY(2);
        addUI(highScoreText);

    }
    public static void addScore(long score){
        File scoreFile = new File("scores/");
        try {
            FileWriter fileWriter = new FileWriter(scoreFile.getAbsolutePath(), true);
            fileWriter.write(score+ "\n");
            fileWriter.close();

        } catch (Exception e) {
            //ignore
        }
    }

    private long processScores(){
        File scoreFile = new File("scores/");
        long highScore = 0;
        try {
            Scanner scanner = new Scanner(scoreFile);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                long score = Long.parseLong(line);
                if(score > highScore){
                    highScore = score;
                }
            }
        } catch (FileNotFoundException e) {
            //ignore
        }
        return highScore;
    }
}
